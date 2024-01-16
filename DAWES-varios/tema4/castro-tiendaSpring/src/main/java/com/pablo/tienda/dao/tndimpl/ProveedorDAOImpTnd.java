package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProveedorDAO;
import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.utils.DBUtils;

@Component
public class ProveedorDAOImpTnd implements IProveedorDAO {
	
	

		@Override
		public List<ProveedorDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
				String correo, String direccion, String activo)
				throws ClassNotFoundException, SQLException, NamingException {

			String sql = "SELECT ID_Proveedor, Nombre, Contacto, Telefono, CorreoElectronico, Direccion, Activo FROM proveedores"
					+ " WHERE ID_Proveedor LIKE ? AND Nombre LIKE ? AND Contacto LIKE ? AND Telefono LIKE ? AND CorreoElectronico LIKE ? AND Direccion LIKE ? AND Activo = ?";

			Connection connection = DBUtils.conectaBBDD();
			List<ProveedorDTO> listaProveedores = new ArrayList<>();

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + contacto + "%");
			ps.setString(4, "%" + telefono + "%");
			ps.setString(5, "%" + correo + "%");
			ps.setString(6, "%" + direccion + "%");
			ps.setString(7, activo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listaProveedores.add(new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			connection.close();

			return listaProveedores;
		}

		@Override
		public Integer insertarProveedores(String nombre, String contacto, String telefono, String correo, String direccion,
				String activo) throws ClassNotFoundException, SQLException, NamingException {

			String sql = "INSERT INTO proveedores(Nombre, Contacto, Telefono, CorreoElectronico, Direccion, Activo)"
					+ "VALUES ( ? ,? ,? ,?, ?, ? )";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setString(2, contacto);
			ps.setString(3, telefono);
			ps.setString(4, correo);
			ps.setString(5, direccion);
			ps.setString(6, activo);

			Integer resultado = ps.executeUpdate();

			connection.close();

			return resultado;
		}

		@Override
		public Integer actualizarProveedores(String id, String nombre, String contacto, String telefono, String correo,
				String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
			String sql = "UPDATE proveedores SET Nombre = ?, Contacto = ? , Telefono = ?, CorreoElectronico = ?, Direccion = ?, Activo = ?"
					+ "WHERE ID_Proveedor = ?";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setString(2, contacto);
			ps.setString(3, telefono);
			ps.setString(4, correo);
			ps.setString(5, direccion);
			ps.setString(6, activo);
			ps.setString(7, id);

			Integer resultado = ps.executeUpdate();

			connection.close();

			return resultado;
		}

		@Override
		public Integer borrarProveedores(String id) throws ClassNotFoundException, SQLException, NamingException {

			String sql = "UPDATE proveedores SET  Activo = 0 " + "WHERE ID_Proveedor = ?";

			Connection connection = DBUtils.conectaBBDD();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, id);

			Integer resultado = ps.executeUpdate();

			connection.close();

			return resultado;
		}

	}



