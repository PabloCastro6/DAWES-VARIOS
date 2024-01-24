package com.pablo.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ClienteProductoDTO;
import com.pablo.tienda.dtos.PedidoDTO;

public interface IPedidosService {
	
	public Double calcularPrecio(ClienteProductoDTO clienteProducto);
	
	public List<PedidoDTO> buscarPedidos(String id,String cliente, String fecha,String estado)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarPedidos(String id,String cliente, String fecha, String estado)throws ClassNotFoundException, SQLException, NamingException;

}
