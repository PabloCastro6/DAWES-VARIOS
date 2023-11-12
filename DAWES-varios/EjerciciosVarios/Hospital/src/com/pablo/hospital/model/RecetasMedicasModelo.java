package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.RecetasMedicasDTO;
import com.pablo.hospital.utils.DBUtils;

public class RecetasMedicasModelo {

	public List<RecetasMedicasDTO> buscarRecetasMedicas(String iD, String pacienteID, String medicoID,
			String medicamentoID, String fecha, String cantidadPrescrita)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM recetasMedicas rm INNER JOIN pacientes pa ON rm.pacienteID = pa.id"
				+ " INNER JOIN medicos me ON rm.medicoID = me.id"
				+ " INNER JOIN farmacia far ON rm.medicamentoID = far.id" + " WHERE rm.id LIKE ? "
				+ " OR rm.pacienteID LIKE ?" + " OR rm.medicoID LIKE ?" + " OR rm.medicamentoID LIKE ?"
				+ " OR rm.fecha LIKE ?" + " OR rm.cantidadPrescrita LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, iD);
		ps.setString(2, pacienteID);
		ps.setString(3, medicoID);
		ps.setString(4, medicamentoID);
		ps.setString(5, fecha);
		ps.setString(6, cantidadPrescrita);

		ResultSet recetasMedicasRS = ps.executeQuery();
		List<RecetasMedicasDTO> listaRecetasMedicas = new ArrayList<>();

		while (recetasMedicasRS.next()) {
			RecetasMedicasDTO p = new RecetasMedicasDTO(recetasMedicasRS.getString("ID"),
					recetasMedicasRS.getString("pacienteID"), recetasMedicasRS.getString("medicoID"),
					recetasMedicasRS.getString("medicamentoID"), recetasMedicasRS.getString("fecha"),
					recetasMedicasRS.getString("cantidadPrescrita"));
			listaRecetasMedicas.add(p);
		}

		conexionBD.close();
		return listaRecetasMedicas;
	}

	public Integer insertarRecetasMedicas(String pacienteID, String medicoID, String medicamentoID, String fecha,
			String cantidadPrescrita)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO recetasMedicas (pacienteID, medicoID, medicamentoID, fecha, cantidadPrescrita) VALUES (?, ?, ?, ?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		ps.setString(1, pacienteID);
		ps.setString(2, medicoID);
		ps.setString(3, medicamentoID);
		ps.setString(4, fecha);
		ps.setString(5, cantidadPrescrita);
		

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;
	}

	public Integer actualizarRecetasMedicas(String iD, String pacienteID, String medicoID, String medicamentoID,
			String fecha, String cantidadPrescrita) throws SQLException, ClassNotFoundException {

		String sql = " UPDATE recetasMedicas SET pacienteID = CASE WHEN ? = '' THEN pacienteID ELSE ? END,"
				+ "  medicoID = CASE WHEN ? = '' THEN medicoID ELSE ? END,"
				+ " medicamentoID = CASE WHEN ? = '' THEN medicamentoID ELSE ? END,"
				+ "  fecha = CASE WHEN ? = '' THEN fecha ELSE ? END,"
				+ "  cantidadPrescrita = CASE WHEN ? = '' THEN cantidadPrescrita ELSE ? END " + " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, pacienteID);
		ps.setString(2, pacienteID);
		ps.setString(3, medicoID);
		ps.setString(4, medicoID);
		ps.setString(5, medicamentoID);
		ps.setString(6, medicamentoID);
		ps.setString(7, fecha);
		ps.setString(8, fecha);
		ps.setString(9, cantidadPrescrita);
		ps.setString(10, cantidadPrescrita);
		ps.setString(11, iD);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}
}
