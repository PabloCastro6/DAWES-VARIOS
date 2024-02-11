package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.ItemDTO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.DetalleEntity;
import com.pablo.tienda.entities.PedidoEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.utils.DBUtils;

@Component("HibernateImplPedido")
public class PedidosDAOHibernate implements IPedidosDAO {

	@Override
	public List<PedidoDTO> buscarPedidos(String idPedido, String idCliente, String idEstado, String fecha)
			throws ClassNotFoundException, SQLException {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT new com.pablo.tienda.dtos.PedidoDTO("
				+ "pe.id AS id, c.id AS idCliente, pe.fechaRegistro AS fecha, ep.id AS idEstado, c.nombre AS nombreCliente, "
				+ "ep.nombre AS nombreEstado, pr.id AS idProducto, pr.nombre AS nombreProducto, dp.cantidad AS cantidad, "
				+ "dp.precioUnitario AS precio, dp.id AS idDetalle)" + " FROM PedidoEntity pe" + " JOIN pe.cliente c"
				+ " JOIN pe.estado ep" + " JOIN pe.detallesPedido dp" + " JOIN dp.producto pr"
				+ " WHERE pe.fechaRegistro >= :fechaRegistro";

		String hqlId = " AND pe.id = :id";
		String hqlCliente = "AND c.id = :cliente";
		String hqlEstado = "AND ep.id = :estado";

		StringBuilder sbHql = new StringBuilder(hql);

		if (idPedido != "") {
			sbHql.append(hqlId);
		}
		if (idCliente != "") {
			sbHql.append(hqlCliente);
		}
		if (idEstado != "") {
			sbHql.append(hqlEstado);
		}

		if (fecha != null) {
			hql += " AND pe.fechaRegistro >= :fechaRegistro";
		}

		Query<PedidoDTO> query = session.createQuery(sbHql.toString(), PedidoDTO.class).setParameter("fechaRegistro",
				fecha);

		if (idPedido != "") {
			query.setParameter("id", idPedido);
		}
		if (idCliente != "") {
			query.setParameter("cliente", idCliente);
		}
		if (idEstado != "") {
			query.setParameter("estado", idEstado);
		}

		List<PedidoDTO> listaPedidos = query.getResultList();
		session.close();

		return listaPedidos;
	}

	@Override
	public Integer actualizarPedidos(String id, String idCliente, String idProducto, String cantidad, String precio)
			throws ClassNotFoundException, SQLException {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		PedidoEntity pedido = session.get(PedidoEntity.class, Integer.parseInt(id));
		DetalleEntity detallePedido = session.get(DetalleEntity.class, Integer.parseInt(id));

		pedido.setCliente(session.find(ClientesEntity.class, Integer.parseInt(idCliente)));
		detallePedido.setProducto(session.find(ProductoEntity.class, Integer.parseInt(idProducto)));
		detallePedido.setCantidad(Integer.parseInt(cantidad));
		detallePedido.setPrecioUnitario(Double.parseDouble(precio));

		session.merge(pedido);
		session.merge(detallePedido);
		session.getTransaction().commit();
		session.close();
		return 1;

	}

	@Override
	public Double buscarPrecioAcumulado(Integer cliente) throws ClassNotFoundException, SQLException, NamingException {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT SUM(d.cantidad * d.precioUnitario) AS totalGastos " + "FROM DetallePedido d "
				+ "JOIN d.pedido p " + "WHERE p.cliente.id = :clienteId " + "GROUP BY p.cliente.id";

		Query<Double> query = session.createQuery(hql, Double.class);
		query.setParameter("clienteId", cliente);

		Double precioAcumulado = query.uniqueResult();
		session.close();
		return precioAcumulado != null ? precioAcumulado : 0.0;

	}

	@Override
	public Double calcularDescuento(Double precioAcumulado) throws ClassNotFoundException, SQLException {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT d.descuento FROM Descuentos d " + "WHERE d.cantidad < :precioAcumulado "
				+ "ORDER BY d.cantidad DESC";

		Query<Double> query = session.createQuery(hql, Double.class).setParameter("precioAcumulado", precioAcumulado)
				.setMaxResults(1);

		Double descuento = query.uniqueResult();
		session.close();
		return descuento != null ? descuento : 0.0;
	}

	@Override
	public Integer insertarPedido(List<ItemDTO> lista) throws ClassNotFoundException, SQLException {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		return null;
	}

}
