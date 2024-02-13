package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IClientesDAO;
import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.PoblacionEntity;
import com.pablo.tienda.repositories.ClientesRepository;
import com.pablo.tienda.repositories.PoblacionRepository;


@Component("ClientesDAOImplSpringDataJPA")
public class ClientesDAOImplSpringDataJPA implements IClientesDAO {

	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private PoblacionRepository poblacionRepository;

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

//		 mapear clienteEntuty a clienteDTO
//		 return clientesRepository.findAll();
		return null;
		
//		Integer poblacion = idPoblacion.isEmpty() ? null : Integer.parseInt(idPoblacion);
//		Integer estadoActivo = activo.isEmpty() ? null : Integer.parseInt(activo);
//		  
//		return clientesRepository.buscarCliente(id, nombre, correo, poblacion, estadoActivo);

	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		
	
//		PoblacionEntity p = poblacionRepository.findById(Integer.parseInt(idPoblacion)).get();
//		
//		ClientesEntity c = new ClientesEntity(nombre, correoElectronico, p, Integer.parseInt(activo));
//		clientesRepository.save(c);
//		
//		return c.getId();
		return null;

	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
//		PoblacionEntity p = poblacionRepository.findById(Integer.parseInt(idPoblacion)).get();
//		ClientesEntity c = new ClientesEntity(id, correo, p, Integer.parseInt(activo));
//		clientesRepository.save(c);
//		return c.getId();
		
		return null;

	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {
//		ClientesEntity c =  clientesRepository.findById(Integer.parseInt(id)).get();
//		c.setActivo(0);
//		clientesRepository.save(c);
//		return c.getId();
		
		return null;

	}

}
