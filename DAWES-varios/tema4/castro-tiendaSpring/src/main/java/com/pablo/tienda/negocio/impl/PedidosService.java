package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.ClienteProductoDTO;
import com.pablo.tienda.dtos.ItemDTO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.negocio.IPedidosService;


@Component
public class PedidosService implements IPedidosService {
	//Calculo precio total, y pasar por parametro el ClienteProductoDTO
	
	@Autowired
	IPedidosDAO pedidoDAO;

	public Double calcularPrecio(ClienteProductoDTO clienteProducto) {

		try {
			pedidoDAO.buscarPrecioAcumulado(null);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		// TODO:1 llamar al DAO para comprobar las compras acumuladas del clienteID
		// devuelve el numero de compras
		// TODO:2 Hacer en el DAO un metodo para calcular el descuento
		// TODO:3 Consultar el precio del producto ya con el descuento return
		// precio*(1-descuento/100)
		return null;
	}

	public Integer doPedido(List<ItemDTO> lista) {

		// TODO: Llaar al DAO insertar
		return null;

	}


	
	@Override
	public List<PedidoDTO> buscarPedidos(String id, String idcliente, String fecha, String idestado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidoDAO.buscarPedidos(id, idcliente, fecha, idestado);
	}

	@Override
	public Integer actualizarPedidos(String id, String idcliente, String idProducto, String cantidad, String precio)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidoDAO.actualizarPedidos(id, idcliente, idProducto, cantidad, precio);
	}

}

