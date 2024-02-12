package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IClientesDAO;
import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.repositories.ClientesRepository;

@Component("ClientesDAOImplSpringDataJPA")
public class ClientesDAOImplSpringDataJPA implements IClientesDAO {

	@Autowired
	private ClientesRepository clientesRepository;

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		
		//mapear clienteEntuty a clienteDTO
		return clientesRepository.findAll();
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
