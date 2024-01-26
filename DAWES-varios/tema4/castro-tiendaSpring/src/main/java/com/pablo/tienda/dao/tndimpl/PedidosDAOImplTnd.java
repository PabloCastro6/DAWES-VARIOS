package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.utils.DBUtils;

@Component
public class PedidosDAOImplTnd implements IPedidosDAO {

	@Override
	public List<PedidoDTO> buscarPedidos(String id, String idCliente, String fecha, String idEstado)
			throws ClassNotFoundException, SQLException {
		String sql = null;
		Connection connection = DBUtils.conectaBBDD();

		List<PedidoDTO> listaPedido = new ArrayList<>();

		if (fecha.equals("")) {
			sql = "SELECT p.ID_Pedido, p.ID_Cliente,CAST(p.FechaPedido AS DATE), p.EstadoID, c.Nombre, e.NombreEstado, "
					+ " pr.ID_Producto, pr.Nombre , dp.Cantidad, dp.PrecioUnitario , dp.ID_Detalle" + " FROM pedidos p "
					+ " INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente "
					+ " INNER JOIN estadospedidos e ON p.EstadoID = e.EstadoID "
					+ " INNER JOIN detalles_pedido dp ON p.ID_Pedido = dp.ID_Pedido "
					+ " INNER JOIN productos pr ON dp.ID_Producto = pr.ID_Producto"
					+ " WHERE p.ID_Pedido LIKE ? AND p.ID_Cliente LIKE ? " + " AND p.EstadoID LIKE ? ;";

		} else {

			sql = "SELECT p.ID_Pedido, p.ID_Cliente, CAST(p.FechaPedido AS DATE), p.EstadoID, c.Nombre, e.NombreEstado, "
					+ " pr.ID_Producto,pr.Nombre, dp.Cantidad, dp.PrecioUnitario, dp.ID_Detalle" + " FROM pedidos p "
					+ " INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente "
					+ " INNER JOIN estadospedidos e ON p.EstadoID = e.EstadoID "
					+ " INNER JOIN detalles_pedido dp ON p.ID_Pedido = dp.ID_Pedido "
					+ " INNER JOIN productos pr ON dp.ID_Producto = pr.ID_Producto"
					+ " WHERE p.ID_Pedido LIKE ? AND p.ID_Cliente LIKE ? " + " AND CAST(p.FechaPedido AS DATE) >= ? "
					+ " AND p.EstadoID LIKE ? ;";
		}

		PreparedStatement ps = connection.prepareStatement(sql);

		if (fecha.equals("")) {
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + idCliente + "%");
			ps.setString(3, "%" + idEstado + "%");

		} else {
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + idCliente + "%");
			ps.setString(3, fecha);
			ps.setString(4, "%" + idEstado + "%");
		}

		ResultSet rs = ps.executeQuery();
		System.out.println(ps.toString());

		while (rs.next()) {
			listaPedido.add(new PedidoDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getDouble(10), rs.getInt(11)));
		}
		connection.close();
		return listaPedido;
	}

	// MODIFICAR

	@Override
	public Integer actualizarPedidos(String idDetalle, String idCliente, String idProducto, String cantidad,
			String precio) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE pedidos AS p " + " INNER JOIN detalles_pedido AS dp ON p.ID_Pedido = dp.ID_Pedido "
				+ " SET p.ID_Cliente = ?, dp.ID_Producto = ?, dp.Cantidad = ?, dp.PrecioUnitario = ? "
				+ " WHERE dp.ID_Detalle = ?;";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, cantidad);
		ps.setString(4, precio);
		ps.setString(5, idDetalle);

		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	public Double buscarPrecioAcumulado(Integer cliente) throws ClassNotFoundException, SQLException {

		String sql = "SELECT SUM(d.Cantidad * d.PrecioUnitario) AS TotalGastos "
				+ " FROM pedidos p INNER JOIN detalles_pedido d ON p.ID_Pedido = d.ID_Pedido "
				+ " WHERE p.ID_Cliente = ? GROUP BY p.ID_Cliente;";

		Connection connection = DBUtils.conectaBBDD();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, cliente);

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		rs.next();
		Double precioAcumulado = rs.getDouble(1);

		connection.close();
		return precioAcumulado;
	}

	public Double calcularDescuento(Double precioAcumulado) throws ClassNotFoundException, SQLException {

		String sql = "SELECT descuento FROM tienda.descuentos WHERE cantidad < ?  order by cantidad desc LIMIT 1; ";

		Connection connection = DBUtils.conectaBBDD();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setDouble(1, precioAcumulado);

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		rs.next();
		Double descuento = rs.getDouble(1);

		connection.close();
		return descuento;
	}

	
	@Override
	public Integer insertarPedidos(String id, String idCliente, String idProducto, String cantidad, String precio)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

// TODO

// public Integer insertarPedido(List<ItemDTO> lista) {
// TODO: insertra un registro en la tabla pedido y reucperar eñ ID_PEDIDO
// autogenerado
// TODO:2 entrar en un bucle dodne recorramos cada elemtno de la lista y por
// cada uno hacer lo siguiente:
// TODO 2.1: Hacer un insert en la tabla detallePedido
// TODO 2.2: Restar en la tabla productos la cantidad

// }
