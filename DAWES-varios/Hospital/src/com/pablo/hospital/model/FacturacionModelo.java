package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.FacturacionDTO;
import com.pablo.hospital.utils.DBUtils;

public class FacturacionModelo {

	public List<FacturacionDTO> buscarFacturacion(String id, Integer pacienteID, String fecha, Float monto,
			Integer estadoID) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM facturacion WHERE iD LIKE ? OR PacienteID LIKE ? OR Fecha LIKE ? OR Monto LIKE ? OR EstadoID LIKE ?;";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, pacienteID);
		ps.setString(3, fecha);
		ps.setFloat(4, monto);
		ps.setInt(1, estadoID);

		ResultSet facturacionRS = ps.executeQuery();
		List<FacturacionDTO> listaFacturacion = new ArrayList<>();

		while (facturacionRS.next()) {
			FacturacionDTO p = new FacturacionDTO(facturacionRS.getInt("Id"), facturacionRS.getInt("pacienteID"),
					facturacionRS.getString("fecha"), facturacionRS.getFloat("monto"),
					facturacionRS.getInt("estadoID"));
			listaFacturacion.add(p);
		}

		conexionBD.close();
		return listaFacturacion;
	}

	public Integer insertarFacturacion(String fecha, Float monto) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO facturacion ( fecha, monto) VALUES (?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		ps.setString(1, fecha);
		ps.setFloat(2, monto);

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;
	}

	public Integer actualizarFacturacion(String id, Integer pacienteID, String fecha, Float monto, Integer estadoID)
			throws SQLException, ClassNotFoundException {

		String sql = " UPDATE facturacion SET pacienteID = CASE WHEN ? = '' THEN pacienteID ELSE ? END,"
				+ "  fecha = CASE WHEN ? = '' THEN fecha ELSE ? END,"
				+ "  monto = CASE WHEN ? = '' THEN monto ELSE ? END,"
				+ " estadoID = CASE WHEN ? = '' THEN estadoID ELSE ? END," + " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, pacienteID);
		ps.setInt(2, pacienteID);
		ps.setString(3, fecha);
		ps.setString(4, fecha);
		ps.setFloat(5, monto);
		ps.setFloat(6, monto);
		ps.setInt(7, estadoID);
		ps.setInt(8, estadoID);
		ps.setString(9, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}

}
