package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.utils.DBUtils;

public class PedidosDAOImplTnd implements IPedidosDAO {
	
	
	
	@Override
	public List<PedidoDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Integer actualizarPedidos(String id, String cliente, String fecha, String estado)throws ClassNotFoundException, SQLException, NamingException {
		
		String sql="UPDATE pedidos SET ID_Cliente = ?, Fecha = ?, EstadoID = ?, ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, cliente);
		ps.setString(2, fecha);
		ps.setString(3, estado);
		ps.setString(4, id);
		
		Integer resultado = ps.executeUpdate();
		
		connection.close();
		
	
		return resultado;
	}

	

}
