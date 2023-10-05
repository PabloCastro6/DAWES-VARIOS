package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.AlergiaDTO;
import dtos.PacienteDTO;
import utils.DBUtils;

public class PacienteModelo {
	
	public List<PacienteDTO> buscarPaciente (String id, String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM pacientes INNER JOIN alergias ON pacientes.AlergiaID=alergias.ID where ID = ? or Nombre LIKE ? OR Apellido LIKE ? OR FechaDeNacimiento LIKE ? OR DNI LIKE ? OR Direccion LIKE ? "
				+ "OR Telefono LIKE ? OR CorreoElectronico LIKE ? OR Alergia.descripcion LIKE ? OR HistoriaMedica LIKE ?;";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + FechaDeNacimiento + "%");
		ps.setString(5, "%" + DNI + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, "%" + telefono + "%");
		ps.setString(8, "%" + correo + "%");
		ps.setString(9, "%" + alergia + "%");
		ps.setString(10, "%" + HistoriaMedica + "%");
		
		
		ResultSet pacienteRS = ps.executeQuery();
		List<PacienteDTO> listaPacientes = new ArrayList<>();
		
		
		while(pacienteRS.next()) {
			PacienteDTO p = new PacienteDTO (pacienteRS.getInt("ID"), pacienteRS.getString("nombre"), pacienteRS.getString("apellido"), pacienteRS.getString("FechaDeNacimiento"), pacienteRS.getString("DNI") , pacienteRS.getString("direccion"),
					pacienteRS.getString("telefono"), pacienteRS.getString("correoElectronico"), pacienteRS.getInt("AlergiaID"), pacienteRS.getString("HistoriaMedica"));
			listaPacientes.add(p);
		}
		
		conexionBD.close();
		return listaPacientes;
	}

	
	public Integer insertarPaciente (String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica)throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO paciente (nombre,  apellido, FechaDeNacimiento,  DNI, direccion,  telefono"
				+ "	 correo,  alergia, HistoriaMedica ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = conexionBD.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, FechaDeNacimiento);
		ps.setString(4, DNI);
		ps.setString(5, direccion);
		ps.setString(6, telefono);
		ps.setString(7,correo);
		ps.setInt(8, alergia);
		ps.setString(9, HistoriaMedica);
		
		
		
		return 0;
	}
	
	
	
	
	public Integer actualizarPaciente (String nombre, String apellido,String FechaDeNacimiento, String DNI, String direccion, String telefono,
			String correo, Integer alergia, String HistoriaMedica) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE pacientes SET Nombre = case when ? ='' then Nombre else ? END, \"\r\n"
				+ "				+ \"Apellido = case when ? ='' then Apellido else ? END, \"\r\n"
				+ "				+ \"FechaDeNacimiento = case when ? ='' then FechaDeNacimiento else ? END, \"\r\n"
				+ "				+ \"DNI = case when ? ='' then DNI else ? END, \"\r\n"
				+ "				+ \"Direccion = case when ? ='' then Direccion else ? END, \"\r\n"
				+ "				+ \"Telefono = case when ? ='' then Telefono else ? END, \"\r\n"
				+ "				+ \"CorreoElectronico = case when ? ='' then CorreoElectronico else ? END, \"\r\n"
				+ "				+ \"AlergiaID = case when ? ='' then AlergiaID else ? END,\"\r\n"
				+ "				+ \"HistoriaMedica = case when ? ='' then HistoriaMedica else ?\"\r\n"
				+ "				+ \"END \"\r\n"
				+ "				+ \"WHERE ID = ?";
		
				Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);		

		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, FechaDeNacimiento);
		ps.setString(4, DNI);
		ps.setString(5, direccion);
		ps.setString(6, telefono);
		ps.setString(7, correo);
		ps.setInt(8, alergia);
		ps.setString(9, HistoriaMedica);
		
		
		
		resultado = ps.executeUpdate();
		
		connection.close();
		
		return resultado;
		
	}
	
	
}
