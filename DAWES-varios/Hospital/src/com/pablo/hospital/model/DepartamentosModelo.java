package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.DepartamentoDTO;
import com.pablo.hospital.utils.DBUtils;

public class DepartamentosModelo {

	public List<DepartamentoDTO> buscarDepartamento(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM departamentos WHERE id LIKE ? OR nombre LIKE ? OR descripcion LIKE ? OR activo LIKE ?;";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, activo);

		ResultSet departamentoRS = ps.executeQuery();
		List<DepartamentoDTO> listaDepartamentos = new ArrayList<>();

		while (departamentoRS.next()) {
			DepartamentoDTO p = new DepartamentoDTO(departamentoRS.getInt("Id"), departamentoRS.getString("nombre"),
					departamentoRS.getString("descripcion"), departamentoRS.getInt("activo"));
			listaDepartamentos.add(p);
		}

		conexionBD.close();
		return listaDepartamentos;
	}

	public Integer insertarDepartamento(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO departamentos ( nombre, descripcion, activo) VALUES (?, ?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;
	}

	public Integer actualizarDepartamento(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException {

		String sql = " UPDATE departamentos SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END,"
				+ "  descripcion = CASE WHEN ? = '' THEN descripcion ELSE ? END,"
				+ " activo = CASE WHEN ? = '' THEN activo ELSE ? END," + " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, descripcion);
		ps.setString(5, activo);
		ps.setString(6, activo);
		ps.setString(7, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}

	public Integer borrarDepartamento(String id) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM departamentos WHERE id = ?  ";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}

}
