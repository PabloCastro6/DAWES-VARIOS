package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.MedicoDTO;
import com.pablo.hospital.dtos.PacienteDTO;
import com.pablo.hospital.utils.DBUtils;

public class MedicosModelo {

	public List<MedicoDTO> buscarMedico(String iD, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correoElectronico)
			throws SQLException, ClassNotFoundException {

		String query = "SELECT * from medicos where ID LIKE ? AND Nombre LIKE ? AND Apellido LIKE ? AND "
				+ "Especialidad LIKE ? AND LicenciaMedica LIKE ? AND Telefono LIKE ? AND CorreoElectronico LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + iD + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + especialidad + "%");
		ps.setString(5, "%" + licenciaMedica + "%");
		ps.setString(6, "%" + telefono + "%");
		ps.setString(7, "%" + correoElectronico + "%");

		ResultSet medicoRS = ps.executeQuery();
		List<MedicoDTO> listaMedicos = new ArrayList<>();

		while (medicoRS.next()) {
			MedicoDTO m = new MedicoDTO(medicoRS.getString("ID"), medicoRS.getString("nombre"),
					medicoRS.getString("apellido"), medicoRS.getString("especialidad"),
					medicoRS.getString("licenciaMedica"), medicoRS.getString("telefono"),
					medicoRS.getString("correoElectronico"));
			listaMedicos.add(m);
		}

		conexionBD.close();
		return listaMedicos;
	}

	public Integer insertarMedico( String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correoElectronico)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO medico (  nombre,  apellido,  especialidad,  licenciaMedica"
				+ " telefono,  correoElectronico) VALUES (?, ?, ?, ?, ?, ?); ";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = conexionBD.prepareStatement(sql);

	
		ps.setString(1, apellido);
		ps.setString(2, especialidad);
		ps.setString(3, licenciaMedica);
		ps.setString(4, telefono);
		ps.setString(5, correoElectronico);

		resultado = ps.executeUpdate();

		conexionBD.close();

		return resultado;

	}

	public Integer actualizarMedico( String id, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correoElectronico)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE Pacientes " + "SET " + "  ID = CASE WHEN ? = '' THEN Nombre ELSE ? END,  "
				+ "  Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, "
				+ "    Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END, "
				+ "    especialidad = CASE WHEN ? = '' THEN especialidad ELSE ? END, "
				+ "    licenciaMedica = CASE WHEN ? = '' THEN licenciaMedica ELSE ? END, "
				+ "    Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END, "
				+ "    correoElectronico = CASE WHEN ? = '' THEN correoElectronico ELSE ? END, " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, especialidad);
		ps.setString(4, licenciaMedica);
		ps.setString(5, telefono);
		ps.setString(6, correoElectronico);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}

}
