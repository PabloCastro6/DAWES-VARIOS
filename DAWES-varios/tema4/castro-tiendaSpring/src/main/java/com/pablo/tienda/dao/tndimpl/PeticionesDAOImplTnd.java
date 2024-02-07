package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.utils.DBUtils;

@Component
public class PeticionesDAOImplTnd implements IPeticionesDAO {

	private static final Logger logger = LoggerFactory.getLogger(PeticionesDAOImplTnd.class);

	public List<PeticionesDTO> buscarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT p.ID_Peticiones, p.ID_Cliente, p.ID_Producto,  p.Estado, CAST(p.FechaAñadido AS DATE),  p.cantidad, c.Nombre ,pd.Nombre,ep.NombreEstado "
				+ "FROM peticiones p  " + "INNER JOIN productos pd ON p.ID_Producto = pd.ID_Producto  "
				+ "INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente  "
				+ "INNER JOIN estadospedidos ep ON p.Estado = ep.EstadoID  "
				+ "WHERE p.ID_Peticiones LIKE ? AND p.ID_Cliente LIKE ? AND p.ID_Producto LIKE ? "
				+ "AND IF(p.FechaAñadido IS NULL, CAST(p.FechaAñadido AS DATE) >= '1970-01-01' ,CAST(p.FechaAñadido AS SIGNED) >= ?) "
				+ "AND if(? = '' ,p.cantidad >=0, p.cantidad >= ?) AND ep.EstadoID LIKE ? ;";

		Connection connection = DBUtils.conectaBBDD();

		List<PeticionesDTO> listaPeticiones = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, "%" + idProducto + "%");
		ps.setString(4, fechaAnhadido);
		ps.setString(5, cantidad);
		ps.setString(6, cantidad);
		ps.setString(7, "%" + idEstadoPedido + "%");

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		while (rs.next()) {
			listaPeticiones.add(new PeticionesDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
					rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));
		}
		connection.close();
		return listaPeticiones;
	}

	public Integer insertarPeticion(String idCliente, String idProducto,String cantidad, String idEstadoPedido)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "INSERT INTO peticiones (ID_Cliente,ID_Producto,cantidad,Estado) " + " VALUES (?,?,?,?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, cantidad);
		ps.setString(4, idEstadoPedido);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	public Integer actualizarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "UPDATE peticiones SET ID_Cliente = ?, ID_Producto = ?, FechaAñadido= ?, cantidad = ?, Estado = ? "
				+ " WHERE ID_Peticiones = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, fechaAnhadido);
		ps.setString(4, cantidad);
		ps.setString(5, idEstadoPedido);
		ps.setString(6, id);

		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	public Integer borrarPeticion(String id) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "UPDATE peticiones SET Estado = 5 WHERE ID_Peticiones = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		ps.toString();
		connection.close();

		return resultado;
	}

}
