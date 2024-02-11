package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ClienteProductoDTO;
import com.pablo.tienda.dtos.ItemDTO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.negocio.IPedidosService;

@Component
public class PedidosService implements IPedidosService {
	// Calculo precio total, y pasar por parametro el ClienteProductoDTO

//	@Qualifier("HibernateImplPedido")
//	@Autowired
//	IPedidosDAO pedidoDAO;
	
	@Autowired
	@Qualifier("PedidosDAOImplSpringDataJPA")
	IPedidosDAO pedidoDAO;
	

//	@Autowired
//	@Qualifier("HibernateImplProducto")
//	IProductoDAO productoDAO;
	
	@Autowired
	@Qualifier("ProductosDAOImplSpringDataJPA")
	IProductoDAO productoDAO;

	public Double calcularPrecio(ClienteProductoDTO clienteProducto) {

		try {
			Double precioAcumulado = pedidoDAO.buscarPrecioAcumulado(clienteProducto.getCliente());

			Double descuento = pedidoDAO.calcularDescuento(precioAcumulado);

			ProductoDTO producto = productoDAO.buscarProductoPorID(clienteProducto.getProducto());

			Double precioDelProducto = producto.getPrecio();

			return precioDelProducto * (1 - descuento / 100);

		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		return null;

		// TODO:1 llamar al DAO para comprobar las compras acumuladas del clienteID
		// devuelve el numero de compras x
		// TODO:2 Hacer en el DAO un metodo para calcular el descuento x
		// TODO:3 Consultar el precio del producto ya con el descuento return x HECHO!!

	}

	public Integer doPedido(List<ItemDTO> lista) throws ClassNotFoundException, SQLException {

		// TODO: Llamar al DAO insertar
		pedidoDAO.insertarPedido(lista);
		return null;

	}

	@Override
	public List<PedidoDTO> buscarPedidos(String id, String idcliente, String fecha, String idestado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidoDAO.buscarPedidos(id, idcliente, fecha, idestado);
	}

	@Override
	public Integer actualizarPedidos(String idDetalle, String idcliente, String idProducto, String cantidad,
			String precio) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidoDAO.actualizarPedidos(idDetalle, idcliente, idProducto, cantidad, precio);
	}

}
