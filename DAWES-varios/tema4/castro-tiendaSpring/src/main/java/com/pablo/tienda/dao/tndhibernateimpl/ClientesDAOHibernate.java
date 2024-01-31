package com.pablo.tienda.dao.tndhibernateimpl;

import org.hibernate.Session;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;

public class ClientesDAOHibernate {
	
//	@Override
//	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo) {
//	    try (Session session = sessionFactory.openSession()) {
//	        String hql = "SELECT new com.pablo.tienda.dtos.ClienteDTO(c.id, c.nombre, c.correoElectronico, p.nombre, c.idPoblacion, c.activo)"
//	                   + " FROM ClienteEntity c"
//	                   + " INNER JOIN PoblacionEntity p ON p.id = c.idPoblacion"
//	                   + " WHERE c.id LIKE :id AND c.nombre LIKE :nombre AND c.correoElectronico LIKE :correo"
//	                   + (idPoblacion.isEmpty() ? "" : " AND c.idPoblacion = :idPoblacion")
//	                   + " AND c.activo = :activo";
//
//	        Query<ClienteDTO> query = session.createQuery(hql, ClienteDTO.class)
//	                                        .setParameter("id", "%" + id + "%")
//	                                        .setParameter("nombre", "%" + nombre + "%")
//	                                        .setParameter("correo", "%" + correo + "%")
//	                                        .setParameter("activo", activo);
//
//	        if (!idPoblacion.isEmpty()) {
//	            query.setParameter("idPoblacion", idPoblacion);
//	        }
//
//	        return query.getResultList();
//	    }
//	}
//	
//	@Override
//	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo) {
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//
//	        ClientesEntity cliente = new ClientesEntity();
//	        cliente.setNombre(nombre);
//	        cliente.setCorreoElectronico(correo);
//	        cliente.setIdPoblacion(idPoblacion);
//	        cliente.setActivo(activo);
//	        session.persist(cliente);
//
//	        session.getTransaction().commit();
//	        return cliente.getId();
//	    }
//	}
//	
//	@Override
//	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo) {
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//
//	        ClientesEntity cliente = new ClientesEntity();
//	        cliente.setId(Integer.parseInt(id));
//	        cliente.setNombre(nombre);
//	        cliente.setCorreoElectronico(correo);
//	        cliente.setIdPoblacion(idPoblacion);
//	        cliente.setActivo(activo);
//	        session.merge(cliente);
//
//	        session.getTransaction().commit();
//	        return cliente.getId();
//	    }
//	}
//	
//	@Override
//	public Integer borrarClientes(String id) {
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//
//	        ClientesEntity cliente = session.find(ClientesEntity.class, Integer.parseInt(id));
//	        if (cliente != null) {
//	            cliente.setActivo("0"); // Si quieres desactivar en lugar de borrar
//	            session.merge(cliente); // o session.delete(cliente) para eliminar
//	        }
//
//	        session.getTransaction().commit();
//	        return cliente != null ? cliente.getId() : null;
//	    }
//	}
//
}
