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

	public List<RecetasMedicasDTO> buscarRecetasMedicas(Integer iD, Integer pacienteID, Integer medicoID,
			Integer medicamentoID, String fecha, Integer cantidadPrescrita)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT *" + "FROM recetasMedicas rm" + "INNER JOIN pacientes pa ON rm.pacienteID = pa.id"
				+ "INNER JOIN medicos me ON rm.medicoID = me.id"
				+ "INNER JOIN medicamento met ON rm.medicamentoID = met.id" + "WHERE rm.id LIKE ?"
				+ "OR rm.pacienteID LIKE ?" + "OR rm.medicoID LIKE ?" + "OR rm.medicamentoID LIKE ?"
				+ "OR rm.fecha LIKE ?" + "OR r.cantidadPrescrita LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setInt(1, iD);
		ps.setInt(2, pacienteID);
		ps.setInt(3, medicoID);
		ps.setInt(4, medicamentoID);
		ps.setString(5, fecha);
		ps.setInt(6, cantidadPrescrita);

		ResultSet recetasMedicasRS = ps.executeQuery();
		List<RecetasMedicasDTO> listaRecetasMedicas = new ArrayList<>();

		while (recetasMedicasRS.next()) {
			RecetasMedicasDTO p = new RecetasMedicasDTO(recetasMedicasRS.getInt("ID"),
					recetasMedicasRS.getInt("pacienteID"), recetasMedicasRS.getInt("medicoID"),
					recetasMedicasRS.getInt("medicamentoID"), recetasMedicasRS.getString("fecha"),
					recetasMedicasRS.getInt("cantidadPrescrita"));
			listaRecetasMedicas.add(p);
		}

		conexionBD.close();
		return listaRecetasMedicas;
	}

	public Integer insertarRecetasMedicas(String fecha, Integer cantidadPrescrita) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO recetasMedicas ( fecha, cantidadPrescrita) VALUES (?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

		
		ps.setString(1, fecha);
		ps.setInt(2, cantidadPrescrita);

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;
	}

	public Integer actualizarRecetasMedicas(Integer iD, Integer pacienteID, Integer medicoID, Integer medicamentoID,String fecha, Integer cantidadPrescrita)throws SQLException, ClassNotFoundException {

		String sql = " UPDATE recetasMedicas SET pacienteID = CASE WHEN ? = '' THEN pacienteID ELSE ? END,"
				+ "  medicoID = CASE WHEN ? = '' THEN medicoID ELSE ? END,"
				+ " medicamentoID = CASE WHEN ? = '' THEN medicamentoID ELSE ? END," 
				+ "  fecha = CASE WHEN ? = '' THEN fecha ELSE ? END,"
				+ "  cantidadPrescrita = CASE WHEN ? = '' THEN cantidadPrescrita ELSE ? END,"
				+ " WHERE ID = ?;";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, pacienteID);
		ps.setInt(2, pacienteID);
		ps.setInt(3, medicoID);
		ps.setInt(4, medicoID);
		ps.setInt(5, medicamentoID);
		ps.setInt(6, medicamentoID);
		ps.setString(7, fecha);
		ps.setString(8, fecha);
		ps.setInt(9, cantidadPrescrita);
		ps.setInt(10, cantidadPrescrita);
		ps.setInt(11, iD);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}
}
