package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import com.pablo.tienda.dtos.PedidoDTO;

public interface IPedidosDAO {
	
	public List<PedidoDTO> buscarPedidos(String id, String cliente, String fecha, String estado)throws ClassNotFoundException, SQLException;
	
	public Integer actualizarPedidos(String id, String cliente,String fecha,String estado)throws ClassNotFoundException, SQLException;
	

}
