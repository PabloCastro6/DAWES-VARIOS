package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.FarmaciaDTO;
import com.pablo.hospital.utils.DBUtils;

public class FarmaciaModelo {

	public List<FarmaciaDTO> buscaFarmacia(String ID, String nombre, String descripcion, Integer cantidadDisponible,
			Float precio) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM farmacia WHERE id LIKE ? OR nombre LIKE ? OR descripcion LIKE ? OR cantidadDisponible LIKE ? OR precio LIKE ?;  ";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + ID + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, "%" + cantidadDisponible + "%");
		ps.setString(5, "%" + precio + "%");

		ResultSet farmaciasRS = ps.executeQuery();
		List<FarmaciaDTO> listaFarmacia = new ArrayList<>();

		while (farmaciasRS.next()) {
			FarmaciaDTO f = new FarmaciaDTO(farmaciasRS.getInt("ID"), farmaciasRS.getString("nombre"),
					farmaciasRS.getString("descripcion"), farmaciasRS.getInt("cantidadDisponible"),
					farmaciasRS.getFloat("precio"));
			listaFarmacia.add(f);
		}

		conexionBD.close();

		return listaFarmacia;
	}

	public Integer insertarFarmacia(String nombre, String descripcion, Integer cantidadDisponible, Float precio)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO farmacias (nombre,descripcion, cantidadDisponible, precio) VALUES (?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setInt(3, cantidadDisponible);
		ps.setFloat(4, precio);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarFarmacia(Integer ID, String nombre, String descripcion, Integer cantidadDisponible,
			Float precio) throws SQLException, ClassNotFoundException {

		String sql = " UPDATE farmacia SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END,"
				+ "  descripcion = CASE WHEN ? = '' THEN descripcion ELSE ? END,"
				+ " cantidadDisponible = CASE WHEN ? = '' THEN cantidadDisponible ELSE ? END,"
				+ "precio = CASE WHEN ? = '' THEN precio ELSE ? END, " + " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, descripcion);
		ps.setInt(5, cantidadDisponible);
		ps.setInt(6, cantidadDisponible);
		ps.setFloat(7, precio);
		ps.setFloat(8, precio);
		ps.setInt(9, ID);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
