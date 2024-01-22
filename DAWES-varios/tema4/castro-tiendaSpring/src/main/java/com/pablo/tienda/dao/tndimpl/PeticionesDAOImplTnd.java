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
		

		public List<PeticionesDTO> buscarPeticiones(String iD, String iD_Cliente, String iD_Producto, String fecha,
				String cantidad, String idEstado) throws ClassNotFoundException, SQLException {

			Connection connection = DBUtils.conectaBBDD();

			List<PeticionesDTO> listaPeticiones = new ArrayList<>();

			String sql = "SELECT p.ID_Peticiones, p.ID_Cliente, p.ID_Producto, p.FechaAñadido, "
					+ "p.cantidad, ep.EstadoID, c.Nombre AS NombreCliente, pd.Nombre AS NombreProducto "
					+ "FROM peticiones p INNER JOIN productos pd ON p.ID_Producto = pd.ID_Producto "
					+ "INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente "
					+ "INNER JOIN estadospedidos ep ON p.Estado = ep.EstadoID " + " WHERE p.ID_Peticiones LIKE ? "
					+ " AND p.FechaAñadido >= ?" + " AND p.cantidad >= ?";

			String sqlCliente = " AND p.ID_Cliente LIKE ?";
			String sqlProducto = " AND p.ID_Producto LIKE ?";
			String sqlEstado = " AND ep.EstadoID LIKE ?";

			StringBuilder sb = new StringBuilder(sql);

			if (!iD_Cliente.equals("") && !iD_Producto.equals("") && !idEstado.equals("")) {

				sb.append(sqlCliente);
				sb.append(sqlProducto);
				sb.append(sqlEstado);
				
			} else if (!iD_Cliente.equals("") && !iD_Producto.equals("") && idEstado.equals("")) {
				
				sb.append(sqlCliente);
				sb.append(sqlProducto);

			} else if (!iD_Cliente.equals("") && iD_Producto.equals("") && !idEstado.equals("")) {
				
				sb.append(sqlCliente);
				sb.append(sqlEstado);

			} else if (iD_Cliente.equals("") && !iD_Producto.equals("") && !idEstado.equals("")) {
				
				sb.append(sqlProducto);
				sb.append(sqlEstado);

			} else if (!iD_Cliente.equals("") && iD_Producto.equals("") && idEstado.equals("")) {
				
				sb.append(sqlCliente);

			} else if (iD_Cliente.equals("") && !iD_Producto.equals("") && idEstado.equals("")) {
				
				sb.append(sqlProducto);

			} else if (iD_Cliente.equals("") && iD_Producto.equals("") && !idEstado.equals("")) {
				
				sb.append(sqlEstado);

			}
		
			PreparedStatement ps = connection.prepareStatement(sb.toString());

			ps.setString(1, "%" + iD + "%");
			ps.setString(2, fecha);
			ps.setString(3, cantidad);

			if (!iD_Cliente.equals("") && !iD_Producto.equals("") && !idEstado.equals("")) {

				ps.setString(4, "%" + iD_Cliente + "%");
				ps.setString(5, "%" + iD_Producto + "%");
				ps.setString(6, "%" + idEstado + "%");
				
			} else if (!iD_Cliente.equals("") && !iD_Producto.equals("") && idEstado.equals("")) {

				ps.setString(4, "%" + iD_Cliente + "%");
				ps.setString(5, "%" + iD_Producto + "%");

			} else if (!iD_Cliente.equals("") && iD_Producto.equals("") && !idEstado.equals("")) {

				ps.setString(4, "%" + iD_Cliente + "%");
				ps.setString(5, "%" + idEstado + "%");

			} else if (iD_Cliente.equals("") && !iD_Producto.equals("") && !idEstado.equals("")) {

				ps.setString(4, "%" + iD_Producto + "%");
				ps.setString(5, "%" + idEstado + "%");

			} else if (!iD_Cliente.equals("") && iD_Producto.equals("") && idEstado.equals("")) {

				ps.setString(4, "%" + iD_Cliente + "%");

			} else if (iD_Cliente.equals("") && !iD_Producto.equals("") && idEstado.equals("")) {

				ps.setString(4, "%" + iD_Producto + "%");

			} else if (iD_Cliente.equals("") && iD_Producto.equals("") && !idEstado.equals("")) {

				ps.setString(4, "%" + idEstado + "%");

			}


			ResultSet rs = ps.executeQuery();

			System.out.println(ps.toString());

			while (rs.next()) {
				listaPeticiones.add(
						new PeticionesDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), DBUtils.cambiarFormato(rs.getString(4)),
								rs.getInt(5), rs.getString(7), rs.getString(8), rs.getString(6)));
			}
			connection.close();
			return listaPeticiones;

		}

		public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
				throws ClassNotFoundException, SQLException {
			String sql = "INSERT INTO peticiones (ID_Cliente, ID_Producto, cantidad, estado) " + " VALUES (?,?,?,?)";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, idCliente);
			ps.setString(2, idProducto);
			ps.setString(3, cantidad);
			ps.setString(4, estado);

			Integer resultado = ps.executeUpdate();
			connection.close();
			return resultado;
		}

		public Integer actualizarPeticiones(String iD, String iD_Cliente, String iD_Producto, String cantidad, String fecha,
				String nombreEstado) throws ClassNotFoundException, SQLException {
			String sql = "UPDATE peticiones SET ID_Cliente = ?, ID_Producto = ?, fechaañadido = ?, cantidad = ?, estado = ? WHERE ID_Peticiones = ?";

			try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

				ps.setString(1, iD_Cliente);
				ps.setString(2, iD_Producto);
				ps.setString(3, fecha);
				ps.setString(4, cantidad);
				ps.setString(5, nombreEstado);

				ps.setString(6, iD);

				Integer resultado = ps.executeUpdate();
				System.out.println(ps.toString());

				return resultado;
			}
		};

		public Integer borrarPeticiones(String iD) throws ClassNotFoundException, SQLException {
			String sql = "UPDATE peticiones SET Estado = 5 WHERE ID_Peticiones = ? ";

			try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

				ps.setString(1, iD);

				Integer resultado = ps.executeUpdate();
				System.out.println(ps.toString());

				return resultado;
			}
		}

		@Override
		public Integer actualizarPeticiones(String idPeticiones, String idCliente, String idProducto, String cantidad,
				String estado) throws ClassNotFoundException, SQLException, NamingException {
			
			return null;
		};

	}