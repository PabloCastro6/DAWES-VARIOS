package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.HistorialMedicoDTO;
import com.pablo.hospital.utils.DBUtils;

public class HistorialMedicoModelo {

	public List<HistorialMedicoDTO> buscaHistorialMedico(String iD, String pacienteID, String medicoID, String fecha,
			String diagnostico, String tratamiento) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM HistorialMedico " + "WHERE "
				+ "(PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE ? END OR PacienteID LIKE ?) "
				+ "AND (MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE ? END OR MedicoID LIKE ?) "
				+ "AND (Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END OR Fecha LIKE ?) "
				+ "AND (Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END OR Diagnostico LIKE ?) "
				+ "AND (Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END OR Tratamiento LIKE ?)";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, iD);
		ps.setString(2, '%' + iD + '%');
		ps.setString(3, pacienteID);
		ps.setString(4, '%' + pacienteID + '%');
		ps.setString(5, medicoID);
		ps.setString(6, '%' + medicoID + '%');
		ps.setString(7, fecha);
		ps.setString(8, '%' + fecha + '%');
		ps.setString(9, diagnostico);
		ps.setString(10, '%' + diagnostico + '%');
		ps.setString(11, tratamiento);
		ps.setString(12, '%' + tratamiento + '%');

		ResultSet historialRS = ps.executeQuery();
		List<HistorialMedicoDTO> listaHistorial = new ArrayList<>();

		while (historialRS.next()) {
			HistorialMedicoDTO h = new HistorialMedicoDTO(historialRS.getString("iD"), historialRS.getString("pacienteID"),
					historialRS.getString("medicoID"), historialRS.getString("fecha"),
					historialRS.getString("diagnostico"), historialRS.getString("tratamiento"));
			listaHistorial.add(h);
		}

		conexionBD.close();

		return listaHistorial;

	}

	public Integer insertarHistorialMedico( Integer pacienteID, Integer medicoID, String fecha,
			String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO HistorialMedico (PacienteID, MedicoID, Fecha, Diagnostico, Tratamiento) VALUES (?, ?, ?, ?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		return resultado;

	}

	public Integer actualizarHistorialMedico(String iD, Integer pacienteID, Integer medicoID, String fecha,
			String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE HistorialMedico " + "SET "
				+ "    PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE ? END, "
				+ "    MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE ? END, "
				+ "    Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, "
				+ "    Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END, "
				+ "    Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, iD);
		ps.setString(2, iD);
		ps.setInt(3, pacienteID);
		ps.setInt(4, pacienteID);
		ps.setInt(5, medicoID);
		ps.setInt(6, medicoID);
		ps.setString(7, fecha);
		ps.setString(8, fecha);
		ps.setString(9, diagnostico);
		ps.setString(10, diagnostico);
		ps.setString(11, tratamiento);
		ps.setString(12, tratamiento);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}

}
