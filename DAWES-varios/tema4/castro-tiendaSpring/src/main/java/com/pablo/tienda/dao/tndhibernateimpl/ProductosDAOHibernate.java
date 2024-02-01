package com.pablo.tienda.dao.tndhibernateimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.entities.ProveedorEntity;
import com.pablo.tienda.utils.DBUtils;

@Primary
@Component("HibernateImplProducto")
public class ProductosDAOHibernate implements IProductoDAO {

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor) {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT new com.pablo.tienda.dtos.ProductoDTO(pe.id, pe.nombre, pe.descripcion, pe.precio,"
				+ " pe.cantidadEnStock, c.id, pr.id)" + " FROM ProductoEntity pe"
				+ " INNER JOIN CategoriasEntity c ON pe.categoriaEntity.id = c.id "
				+ " INNER JOIN ProveedorEntity pr ON pr.id = pe.proveedorEntity.id" + " WHERE pe.nombre LIKE :nombre"
				+ " AND pe.descripcion LIKE :descripcion" + " AND pe.precio >= :precio"
				+ " AND pe.cantidadEnStock >= :cantidadStock";

		StringBuilder sb = new StringBuilder(hql);

		if (!idCategoria.equals("")) {
			sb.append(" AND pe.categoriaEntity.id LIKE :idCategoria");
		}

		if (!idProveedor.equals("")) {
			sb.append(" AND pe.proveedorEntity.id LIKE :idProveedor");
		}

		if (!id.equals("")) {
			sb.append(" AND pe.id = :id");
		}

		hql = sb.toString();

		Query<ProductoDTO> query = session.createQuery(hql, ProductoDTO.class)
				.setParameter("nombre", "%" + nombre + "%").setParameter("descripcion", "%" + descripcion + "%")
				.setParameter("precio", precio.isEmpty() ? 0 : Double.parseDouble(precio))
				.setParameter("cantidadStock", cantidadStock.isEmpty() ? 0 : Integer.parseInt(cantidadStock));

		if (!idCategoria.equals("")) {
			query.setParameter("idCategoria", "%" + idCategoria + "%");
		}

		if (!idProveedor.equals("")) {
			query.setParameter("idProveedor", "%" + idProveedor + "%");
		}

		if (!id.equals("")) {
			query.setParameter("id", "%" + id + "%");
		}

		List<ProductoDTO> lista = query.getResultList();

		session.close();

		return lista;
	}

	@Override
	public ProductoDTO buscarProductoPorID(Integer id) {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ProductoEntity producto = session.find(ProductoEntity.class, id);
		return producto != null
				? new ProductoDTO(producto.getId(), producto.getNombre(), producto.getDescripcion(),
						producto.getPrecio(), producto.getCantidadEnStock(),
						producto.getCategoria().getId(), producto.getProveedorEntity().getId())
				: null;
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// Setear propiedades del producto...
		CategoriasEntity categoriaEntity = session.find(CategoriasEntity.class, Integer.parseInt(idCategoria));
		ProveedorEntity proveedorEntity = session.find(ProveedorEntity.class, Integer.parseInt(idProveedor));

		BigDecimal precioBigDecimal = new BigDecimal(precio);
		Integer cantidadStockInteger = Integer.parseInt(cantidadStock);

		ProductoEntity producto = new ProductoEntity(nombre, descripcion, precioBigDecimal, cantidadStockInteger,
				categoriaEntity, proveedorEntity);

		session.persist(producto);

		session.getTransaction().commit();
		return producto.getId();
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ProductoEntity producto = new ProductoEntity();
		// Setear propiedades del producto...
		session.merge(producto);

		session.getTransaction().commit();
		return producto.getId();
	}
}
