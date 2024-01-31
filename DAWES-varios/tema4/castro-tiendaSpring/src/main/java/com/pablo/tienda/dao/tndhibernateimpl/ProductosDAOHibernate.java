package com.pablo.tienda.dao.tndhibernateimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.entities.ProveedorEntity;
import com.pablo.tienda.utils.DBUtils;

public class ProductosDAOHibernate implements IProductoDAO {

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor) {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "SELECT new com.pablo.tienda.dtos.ProductoDTO(p.id, p.nombre, p.descripcion, p.precio,"
				+ " p.cantidadEnStock, p.categoria.id, p.proveedor.id, p.categoria.nombre, p.proveedor.nombre)"
				+ " FROM ProductoEntity p"
				+ " WHERE p.id = :id AND p.nombre LIKE :nombre AND p.descripcion LIKE :descripcion"
				+ " AND p.precio >= :precio AND p.cantidadEnStock >= :cantidadStock"
				+ " AND p.categoria.id = :idCategoria AND p.proveedor.id = :idProveedor";

		Query<ProductoDTO> query = session.createQuery(hql, ProductoDTO.class).setParameter("id", id)
				.setParameter("nombre", "%" + nombre + "%").setParameter("descripcion", "%" + descripcion + "%")
				.setParameter("precio", Double.parseDouble(precio))
				.setParameter("cantidadStock", Integer.parseInt(cantidadStock))
				.setParameter("idCategoria", Integer.parseInt(idCategoria))
				.setParameter("idProveedor", Integer.parseInt(idProveedor));

		return query.getResultList();
	}

	@Override
	public ProductoDTO buscarProductoPorID(Integer id) {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ProductoEntity producto = session.find(ProductoEntity.class, id);
		return producto != null
				? new ProductoDTO(producto.getId(), producto.getNombre(), producto.getDescripcion(),
						producto.getPrecio().doubleValue(), producto.getCantidadEnStock(),
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
		
		ProductoEntity producto = new ProductoEntity( nombre, descripcion,  precioBigDecimal, cantidadStockInteger, categoriaEntity,proveedorEntity);
		
		
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
