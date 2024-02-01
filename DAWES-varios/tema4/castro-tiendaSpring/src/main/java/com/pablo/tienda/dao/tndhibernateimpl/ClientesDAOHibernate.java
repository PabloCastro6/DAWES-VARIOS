package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.utils.DBUtils;

public class ClientesDAOHibernate {

//	@Override
//    public List<ClienteDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException {
//        // Implementación para obtener todos los clientes
//        return null;
//    }
//
//    @Override
//    public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo, String nombrePoblacion)
//            throws ClassNotFoundException, SQLException, NamingException {
//
//        String jpql = "SELECT new com.pablo.tienda.dtos.ClienteDTO (c.id, c.nombre, c.correo, c.idPoblacion, c.activo, c.nombrePoblacion)"
//                + " FROM ClienteEntity c"
//                + " WHERE CAST (c.id AS string) LIKE :id"
//                + " AND c.nombre LIKE :nombre"
//                + " AND c.correo LIKE :correo"
//                + " AND CAST (c.idPoblacion AS string) LIKE :idPoblacion"
//                + " AND c.activo = :activo"
//                + " AND c.nombrePoblacion LIKE :nombrePoblacion";
//
//        SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//
//        Query<ClienteDTO> query = session.createQuery(jpql, ClienteDTO.class)
//                .setParameter("id", "%" + id + "%")
//                .setParameter("nombre", "%" + nombre + "%")
//                .setParameter("correo", "%" + correo + "%")
//                .setParameter("idPoblacion", "%" + idPoblacion + "%")
//                .setParameter("activo", activo)
//                .setParameter("nombrePoblacion", "%" + nombrePoblacion + "%");
//
//        List<ClienteDTO> listaClientes = query.getResultList();
//
//        session.getTransaction().commit();
//        session.close();
//        return listaClientes;
//    }

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
