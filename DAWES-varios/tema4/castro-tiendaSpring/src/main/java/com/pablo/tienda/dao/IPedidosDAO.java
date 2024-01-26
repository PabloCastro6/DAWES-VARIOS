package com.pablo.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dtos.ItemDTO;
import com.pablo.tienda.dtos.PedidoDTO;

public interface IPedidosDAO {

	public List<PedidoDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException;

	public Integer actualizarPedidos(String id, String idCliente, String idProducto, String cantidad, String precio)
			throws ClassNotFoundException, SQLException;

	public Double buscarPrecioAcumulado(Integer cliente) throws ClassNotFoundException, SQLException, NamingException;

	public Double calcularDescuento(Double precioAcumulado) throws ClassNotFoundException, SQLException;

	public Integer insertarPedido(List<ItemDTO> lista) throws ClassNotFoundException, SQLException;

}
