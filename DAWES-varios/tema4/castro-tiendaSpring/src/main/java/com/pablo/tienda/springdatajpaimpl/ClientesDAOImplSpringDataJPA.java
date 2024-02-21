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

		// mapear clienteEntity a clienteDTO
		// return clientesRepository.findAll();
		// return null;

		Integer poblacion = idPoblacion.isEmpty() ? null : Integer.parseInt(idPoblacion);
		Integer estadoActivo = activo.isEmpty() ? null : Integer.parseInt(activo);

		return clientesRepository.buscarCliente(id, nombre, correo, poblacion, estadoActivo);

	}

	@Override
	public Integer insertarClientes(String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {


		PoblacionEntity poblacion = null;
		try {
			poblacion = poblacionRepository.findById(Integer.parseInt(idPoblacion)).get();
		} catch(NumberFormatException e){
			//error
			
		}
		ClientesEntity c = new ClientesEntity(nombre, correoElectronico, poblacion, Integer.parseInt(activo));
		clientesRepository.save(c);

		return c.getId();

	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		PoblacionEntity p = null;
		try {
			 p = poblacionRepository.findById(Integer.parseInt(idPoblacion)).get();
		} catch(NumberFormatException e){
			//error
			
		}
				

		Integer idCliente = Integer.parseInt(id);

		ClientesEntity c = new ClientesEntity(idCliente, nombre, correo, p, Integer.parseInt(activo));
		clientesRepository.save(c);
		return c.getId();

	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {
		ClientesEntity c = clientesRepository.findById(Integer.parseInt(id)).get();
		c.setActivo(0);
		clientesRepository.save(c);
		return c.getId();

	}

}
