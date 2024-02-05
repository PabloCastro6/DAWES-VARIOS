package com.pablo.tienda.dao.tndhibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.entities.ProveedorEntity;
import com.pablo.tienda.utils.DBUtils;

@Component("HibernateImplProveedor")
public class ProveedoresDAOHibernate implements IProveedorDAO {

	@Override
	public List<ProveedorDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		StringBuilder building = new StringBuilder();
		String jpql = "SELECT new com.pablo.tienda.dtos.ProveedorDTO (prov.id, prov.nombre, prov.contacto, prov.telefono, prov.correoElectronico, prov.direccion, prov.activo)"
				+ " FROM ProveedorEntity prov INNER JOIN ProductoEntity prod on prov.id = prod.id WHERE ";

		building.append(jpql);

		String jpql1 = "";
		if (id.equals("")) {
			jpql1 = " cast (prov.id as String) like :id ";
		} else {
			jpql1 = " cast (prov.id as String) = :id ";
		}
		building.append(jpql1);

		
		String jpql2 = "";

		jpql2 = " and prov.nombre like :nombre and prov.contacto like :contacto and prov.telefono like :telefono and prov.correoElectronico like :correoElectronico and prov.direccion like :direccion and prov.activo = :activo";

		building.append(jpql2);

		String jpqlFinal = building.toString();

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Query<ProveedorDTO> query = session.createQuery(jpqlFinal, ProveedorDTO.class);

		if (!id.isEmpty()) {
			query.setParameter("id", id);
		} else {
			query.setParameter("id", "%" + id + "%");
		}

		query.setParameter("nombre", "%" + nombre + "%");

		query.setParameter("contacto", "%" + contacto + "%");

		query.setParameter("telefono", "%" + telefono + "%");

		query.setParameter("correoElectronico", "%" + correoElectronico + "%");

		query.setParameter("direccion", "%" + direccion + "%");

		query.setParameter("activo", Integer.parseInt(activo));

		List<ProveedorDTO> listaProveedores = query.getResultList();
		session.close();

		return listaProveedores;
	}

	@Override
	public Integer insertarProveedores(String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		ProveedorEntity entidadProveedor = new ProveedorEntity(nombre, contacto, telefono, correoElectronico, direccion,
				Integer.parseInt(activo));

		session.persist(entidadProveedor);

		session.getTransaction().commit();

		session.close();
		Integer pk = entidadProveedor.getId();
		return pk;
	}

	
	@Override
	public Integer actualizarProveedores(String id, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		ProveedorEntity entidadProveedor = new ProveedorEntity(Integer.parseInt(id), nombre, contacto, telefono,
				correoElectronico, direccion, Integer.parseInt(activo));

		session.merge(entidadProveedor);

		session.getTransaction().commit();

		session.close();
		Integer pk = entidadProveedor.getId();
		return pk;
	}

	
	@Override
	public Integer borrarProveedores(String id) throws ClassNotFoundException, SQLException, NamingException {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		ProveedorEntity entidadProveedor = new ProveedorEntity(Integer.parseInt(id));

		entidadProveedor.setActivo(0);

		session.merge(entidadProveedor);

		session.getTransaction().commit();

		session.close();
		Integer pk = entidadProveedor.getId();
		return pk;
	}

}
