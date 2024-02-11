package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.EstadoPedidoEntity;
import com.pablo.tienda.entities.PeticionEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.utils.DBUtils;

@Component("HibernateImplPeticion")
public class PeticionesDAOHibernate implements IPeticionesDAO {

	@Override
	public List<PeticionesDTO> buscarPeticion(String idPeticiones, String idCliente, String idProducto,
			String fechaAnhadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {

		String jpql = "SELECT new com.pablo.tienda.dtos.PeticionesDTO (p.peticionID, p.cliente.id, p.producto.id, p.estado.id,p.fecha, p.cantidad, p.cliente.nombre, p.producto.nombre, p.estado.nombre)"
				+ " FROM PeticionEntity p WHERE  CAST (p.peticionID  AS string) LIKE :peticion AND CAST (p.cliente.id AS string) LIKE :cliente AND CAST(p.producto.id AS string) LIKE :producto "
				+ " AND (CASE WHEN :fecha = ''  THEN  CAST(p.fecha AS DATE) >= CAST ('1970-01-01' AS DATE )  ELSE CAST(p.fecha AS Date) >= CAST (:fecha AS DATE) END ) "
				+ " AND (case WHEN :cantidad = '' THEN p.cantidad >=0 ELSE p.cantidad >= CAST(:cantidad AS Integer) END) "
				+ " AND CAST (p.estado.id AS String) LIKE :estado";

		System.out.println("fecha: " + fechaAnhadido);

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query<PeticionesDTO> query = session.createQuery(jpql, PeticionesDTO.class)
				.setParameter("peticion", "%" + idPeticiones + "%").setParameter("cliente", "%" + idCliente + "%")
				.setParameter("producto", "%" + idProducto + "%").setParameter("fecha", fechaAnhadido)
				.setParameter("cantidad", cantidad).setParameter("estado", "%" + estado + "%");

		List<PeticionesDTO> listaPeticiones = query.getResultList();

		session.getTransaction().commit();
		session.close();
		return listaPeticiones;

	}

	@Override
	public Integer insertarPeticion(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

//		PeticionEntity nuevaPeticion = new PeticionEntity();
//		
//		nuevaPeticion.setFecha(LocalDateTime.now().toString());

		ClientesEntity clienteEntity = session.find(ClientesEntity.class, Integer.parseInt(idCliente));
		ProductoEntity productoEntity = session.find(ProductoEntity.class, Integer.parseInt(idProducto));
		EstadoPedidoEntity estadoPedidoEntity = session.find(EstadoPedidoEntity.class, Integer.parseInt(estado));

		PeticionEntity peticionEntity = new PeticionEntity(clienteEntity, productoEntity, Integer.parseInt(cantidad),
				estadoPedidoEntity);

		session.persist(peticionEntity);
		session.getTransaction().commit();
		session.close();

		return peticionEntity.getPeticionID();
	}

	@Override
	public Integer actualizarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		ClientesEntity clienteEntity = session.find(ClientesEntity.class, Integer.parseInt(idCliente));
		ProductoEntity productoEntity = session.find(ProductoEntity.class, Integer.parseInt(idProducto));
		EstadoPedidoEntity estadoPedidoEntity = session.find(EstadoPedidoEntity.class,
				Integer.parseInt(idEstadoPedido));

		PeticionEntity peticionEntity = new PeticionEntity();

		peticionEntity.setPeticionID(Integer.parseInt(id));
		peticionEntity.setFecha(fechaAnhadido);
		peticionEntity.setCantidad(Integer.parseInt(cantidad));
		peticionEntity.setCliente(clienteEntity);
		peticionEntity.setProducto(productoEntity);
		peticionEntity.setEstado(estadoPedidoEntity);

		session.merge(peticionEntity);
		session.getTransaction().commit();
		session.close();
		return peticionEntity.getPeticionID();
	}

	@Override
	public Integer borrarPeticion(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		PeticionEntity peticion = session.get(PeticionEntity.class, Integer.parseInt(idPeticiones));

		if (peticion != null) {
			peticion.setEstado(session.find(EstadoPedidoEntity.class, 5));

			session.merge(peticion);
			session.getTransaction().commit();
			session.close();
			return 1;
		}

		session.close();
		return 0;
	}
}
