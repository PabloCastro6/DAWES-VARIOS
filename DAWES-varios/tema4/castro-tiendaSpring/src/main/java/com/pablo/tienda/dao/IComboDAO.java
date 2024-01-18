package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ComboDTO;

public interface IComboDAO {
	

	public List<ComboDTO> recuperaCombosCategorias() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaCombosProveedores() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException;
	
	public List<ComboDTO> recuperarCombosEstadoPedidos() throws ClassNotFoundException, SQLException, NamingException;

}
