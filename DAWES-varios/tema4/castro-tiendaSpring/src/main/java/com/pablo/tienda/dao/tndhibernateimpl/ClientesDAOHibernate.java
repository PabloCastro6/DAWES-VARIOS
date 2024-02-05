package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IClientesDAO;
import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.PoblacionEntity;
import com.pablo.tienda.utils.DBUtils;

@Component("HibernateImplCliente")
public class ClientesDAOHibernate implements IClientesDAO {

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		String hql = "SELECT new com.pablo.tienda.dtos.ClientesDTO (c.id, c.nombre, c.correoElectronico, p.id, c.activo, p.nombre) "
				+ "FROM ClientesEntity c " + "INNER JOIN PoblacionEntity p ON c.poblacion.id = p.id "
				+ "WHERE c.nombre LIKE :nombre " + "AND c.correoElectronico LIKE :correoElectronico "
				+ "AND c.activo = :activo ";

		String hqlPoblacion = "AND p.id = :poblacion ";
		String hqlId = "AND c.id = :id ";

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		StringBuilder sbHql = new StringBuilder(hql);

		if (idPoblacion != "") {
			sbHql.append(hqlPoblacion);
		}
		if (id != "") {
			sbHql.append(hqlId);
		}

		Query<ClienteDTO> query = session.createQuery(sbHql.toString(), ClienteDTO.class)
				.setParameter("nombre", "%" + nombre + "%").setParameter("correoElectronico", "%" + correo + "%")
				.setParameter("activo", activo);

		if (idPoblacion != "") {
			query.setParameter("poblacion", idPoblacion);
		}

		if (id != "") {
			query.setParameter("id", id);
		}

		List<ClienteDTO> listaClientes = query.getResultList();
		session.close();

		return listaClientes;

	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo) {

		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ClientesEntity cliente = new ClientesEntity();
		cliente.setId(Integer.parseInt(id));
		cliente.setNombre(nombre);
		cliente.setCorreoElectronico(correo);
		cliente.setIdPoblacion(Integer.parseInt(idPoblacion));
		cliente.setActivo(Integer.parseInt(activo));
		session.merge(cliente);

		session.getTransaction().commit();
		return cliente.getId();
	}

	@Override
	public Integer borrarClientes(String id) {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ClientesEntity cliente = session.find(ClientesEntity.class, Integer.parseInt(id));
		if (cliente != null) {
			cliente.setActivo(0); // Si quieres desactivar en lugar de borrar
			session.merge(cliente); // o session.delete(cliente) para eliminar
		}

		session.getTransaction().commit();
		return cliente != null ? cliente.getId() : null;
	}

	
	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ClientesEntity nuevoCliente = new ClientesEntity();

		nuevoCliente.setNombre(nombre);
		nuevoCliente.setCorreoElectronico(correo);
		nuevoCliente.setIdPoblacion(Integer.parseInt(idPoblacion));
		nuevoCliente.setActivo(Integer.parseInt(activo));

		session.persist(nuevoCliente);
		session.getTransaction().commit();
		session.close();

		Integer idGenerado = nuevoCliente.getId();

		return idGenerado;
	}
}
