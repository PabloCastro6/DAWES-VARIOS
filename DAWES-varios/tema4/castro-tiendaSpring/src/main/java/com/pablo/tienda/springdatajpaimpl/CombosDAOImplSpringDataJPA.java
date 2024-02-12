package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.repositories.CategoriasRepository;

@Component("combospringdatajpa")
public class CombosDAOImplSpringDataJPA implements IComboDAO {
	
	@Autowired
	private CategoriasRepository categoriaRepository;

	@Override
	public List<ComboDTO> recuperaCombosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		Iterable <CategoriasEntity> listaCategorias = CategoriasRepository.findAll();
		return mapeoCategoriasEntityComboDTO(listaCategorias);
	}
	

	private List<ComboDTO> mapeoCategoriasEntityComboDTO (Iterable <CategoriasEntity> listaCategorias){
		
		List<ComboDTO> comboCategoria = new ArrayList<>();
		
		for (CategoriasEntity m : listaCategorias) {
			comboCategoria.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		
	
		return comboCategoria;
	}




	@Override
	public List<ComboDTO> recuperarCombosProductos() throws ClassNotFoundException, SQLException, NamingException {
	// TODO Auto-generated method stub
	return null;
	}



	@Override
	public List<ComboDTO> recuperaCombosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperarCombosEstadoPedidos() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<ComboDTO> recuperarCombosClientes() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	

}


