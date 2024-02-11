package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.utils.DBUtils;

// @Repository  
@Component("HibernateImplCategoria")
public class CategoriasDAOHibernate implements ICategoriasDAO {

	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		return null;
	}

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		String jpql = "SELECT new com.pablo.tienda.dtos.CategoriasDTO (c.id, c.nombre, c.descripcion, c.activo)"
				+ " FROM CategoriasEntity c" + " WHERE CAST (c.id AS string) LIKE :id" + " AND c.nombre LIKE :nombre"
				+ " AND c.descripcion LIKE :descripcion" + " AND c.activo = :activo";

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query<CategoriasDTO> query = session.createQuery(jpql, CategoriasDTO.class).setParameter("id", "%" + id + "%")
				.setParameter("nombre", "%" + nombre + "%").setParameter("descripcion", "%" + descripcion + "%")
				.setParameter("activo", activo);

		List<CategoriasDTO> listaCategorias = query.getResultList();

		session.getTransaction().commit();
		session.close();
		return listaCategorias;
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		CategoriasEntity categoriaEntity = new CategoriasEntity(nombre, descripcion, Integer.parseInt(activo));

//        CategoriasEntity categoriaEntity = new CategoriasEntity(9, nombre, descripcion, 1);

		session.persist(categoriaEntity);
		session.getTransaction().commit();
		session.close();

		return categoriaEntity.getId();
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		CategoriasEntity categoriaEntity = new CategoriasEntity(Integer.parseInt(id), nombre, descripcion,
				Integer.parseInt(activo));

		session.merge(categoriaEntity);

		session.getTransaction().commit();
		session.close();
		return categoriaEntity.getId();
	}

	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		CategoriasEntity categoriaEntity = session.find(CategoriasEntity.class, Integer.parseInt(id));
		if (categoriaEntity != null) {
			session.delete(categoriaEntity);
		}

		session.getTransaction().commit();
		session.close();
		return categoriaEntity != null ? categoriaEntity.getId() : null;
	}

}
