package com.pablo.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.hospital.dtos.MedicosDTO;
import com.pablo.hospital.dtos.PacienteDTO;

import utils.DBUtils;

public class MedicosModelo {
	
	public List<MedicosDTO> buscarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM Medicos " +
	             "WHERE " +
	             "    (ID = ? OR ? = '') AND " +
	             "    (Nombre LIKE ? OR ? = '') AND " +
	             "    (Apellido LIKE ? OR ? = '') AND " +
	             "    (Especialidad LIKE ? OR ? = '') AND " +
	             "    (LicenciaMedica LIKE ? OR ? = '') AND " +
	             "    (Telefono LIKE ? OR ? = '') AND " +
	             "    (CorreoElectronico LIKE ? OR ? = '');";
		
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
		List<MedicosDTO> listaMedicos = new ArrayList<>();
		
		while(medicoRS.next()) {
			MedicosDTO m = new MedicosDTO (medicoRS.getInt("ID"), medicoRS.getString("nombre"), medicoRS.getString("apellido"), medicoRS.getString("especialidad"), medicoRS.getString("licenciaMedica") , medicoRS.getString("telefono"),
					medicoRS.getString("correoElectronico"));
			listaMedicos.add(m);
		}
		
		conexionBD.close();
		return listaMedicos;
	}
	
	public Integer insertarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO medico (iD,  nombre,  apellido,  especialidad,  licenciaMedica"
				+  " telefono,  correoElectronico) VALUES (?, ?, ?, ?, ?, ?, ?); ";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = conexionBD.prepareStatement(sql);
		
		ps.setInt(1, iD);
		ps.setString(2, apellido);
		ps.setString(3, especialidad);
		ps.setString(4, licenciaMedica);
		ps.setString(5, telefono);
		ps.setString(6, correoElectronico);
		
		
		resultado = ps.executeUpdate();
		
		conexionBD.close();
		
		return resultado;  
		
	}
	
	
	public Integer actualizarMedico (Integer iD, String nombre, String apellido, String especialidad, String licenciaMedica,
			String telefono, String correoElectronico) throws ClassNotFoundException, SQLException {
		
		String sql = "UPDATE Pacientes " +
	             "SET " +
	             "    Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, " +
	             "    Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END, " +
	             "    especialidad = CASE WHEN ? = '' THEN especialidad ELSE ? END, " +
	             "    licenciaMedica = CASE WHEN ? = '' THEN licenciaMedica ELSE ? END, " +
	             "    Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END, " +
	             "    correoElectronico = CASE WHEN ? = '' THEN correoElectronico ELSE ? END, " +
	             "WHERE ID = ?";
		
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
