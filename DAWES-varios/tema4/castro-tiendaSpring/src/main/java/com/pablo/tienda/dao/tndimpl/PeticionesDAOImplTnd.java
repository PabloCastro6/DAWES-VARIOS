package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.utils.DBUtils;



@Component
public class PeticionesDAOImplTnd implements IPeticionesDAO {
	
	
	public List<PeticionesDTO> buscarPeticiones(String idPeticiones, String idCliente, String idProducto, String fecha,
			String cantidad, String estado) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT p.ID_Peticiones, p.ID_Cliente, p.ID_Producto, p.FechaAñadido, "
				+ "p.cantidad, ep.EstadoID, c.Nombre AS NombreCliente, pd.Nombre AS NombreProducto "
				+ "FROM peticiones p " + "INNER JOIN productos pd ON p.ID_Producto = pd.ID_Producto "
				+ "INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente "
				+ "INNER JOIN pedidos pdd ON pdd.ID_Cliente = c.ID_Cliente "
				+ "INNER JOIN estadospedidos ep ON pdd.EstadoID = ep.EstadoID " + "WHERE p.ID_Peticiones LIKE ? "
				+ "AND p.ID_Cliente LIKE ? " + "AND p.ID_Producto LIKE ? " + "AND p.FechaAñadido LIKE ? "
				+ "AND IF(p.cantidad = '', p.cantidad >= 0, p.cantidad >= ?) " + "AND ep.EstadoID LIKE ?";

		Connection connection = DBUtils.conectaBBDD();

		List<PeticionesDTO> listaPeticiones = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + idPeticiones + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, "%" + idProducto + "%");
		ps.setString(4, "%" + fecha + "%");
		ps.setString(5, cantidad);
		ps.setString(6, "%" + estado + "%");

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		while (rs.next()) {
			listaPeticiones.add(new PeticionesDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
					rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
		}
		connection.close();
		return listaPeticiones;
	}

	
	
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO peticiones (ID_Cliente,ID_Producto,cantidad) " + " VALUES (?,?,?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, cantidad);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	
	
	@Override
	public Integer actualizarPeticiones(String idPeticiones, String idCliente, String idProducto, String cantidad,
			String estado) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE peticiones SET ID_Cliente = ?, ID_Producto = ?, cantidad = ?, estado = ? WHERE ID_Peticiones = ?";

		try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, idCliente);
			ps.setString(2, idProducto);
			ps.setString(3, cantidad);
			ps.setString(4, estado);
			ps.setString(5, idPeticiones);

			Integer resultado = ps.executeUpdate();
			System.out.println(ps.toString());

			return resultado;
		} 
	}

	
	
	@Override
	public Integer borrarPeticiones(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE peticiones SET Estado = 5 WHERE ID_Peticiones = ? ";

		try (Connection connection = DBUtils.conectaBBDD(); 
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, idPeticiones);

			Integer resultado = ps.executeUpdate();
			System.out.println(ps.toString());

			return resultado;
		}
	}

}
		
	


