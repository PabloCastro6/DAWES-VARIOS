package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.negocio.IPedidosService;

public class PedidosService implements IPedidosService {
	//Calculo precio total, y pasar por parametro el ClienteProductoDTO
	
	@Autowired 
	IPedidosDAO pedidosDAO;
	
	public List<PedidoDTO> buscarPedidos(String id, String cliente,String fecha,String estado )throws ClassNotFoundException, SQLException, NamingException {
		return IPedidosDAO.buscarPedidos(id, cliente, fecha,estado);
	}
}
