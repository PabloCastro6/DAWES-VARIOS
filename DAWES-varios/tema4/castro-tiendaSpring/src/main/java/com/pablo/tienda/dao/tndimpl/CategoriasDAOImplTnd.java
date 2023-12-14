package com.pablo.tienda.dao.tndimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pablo.tienda.dao.CategoriasDAO;
import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.utils.DBUtils;

@Service
public class CategoriasDAOImplTnd implements CategoriasDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoriasDAOImplTnd.class) ; 

	@Override
	public List<CategoriasDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet categoriasResultSet = null;
		List<CategoriasDTO> listaCategorias = new ArrayList<CategoriasDTO>();
		Connection connection = DBUtils.conectaBBDD();
		
		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM categorias");
		
		while(categoriasResultSet.next()) {
			listaCategorias.add(new CategoriasDTO(categoriasResultSet.getInt(1), categoriasResultSet.getString(2)));
			logger.info("añadida categoria " + categoriasResultSet.getInt(1)+ " " + categoriasResultSet.getString(2)  );
		}
		
		return listaCategorias;
	}

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT c.id_categoria, c.nombre, c.descripcion, c.activo " 
					+ " FROM categorias c  " + 
				" WHERE c.id_categoria LIKE ? AND c.nombre LIKE ? AND c.descripcion LIKE ? "
				+ " AND c.activo = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		List<CategoriasDTO> listaCategorias = new ArrayList<>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, activo );

		ResultSet rs  = ps.executeQuery();
	
		while (rs.next()) {
			listaCategorias.add(new CategoriasDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		connection.close();
		return listaCategorias;
		
		
	}

	
	@Override
	public Integer insertarCategoria(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO categorias (id_categoria, nombre, descripcion, activo) "
					+ "  VALUES (?, ?, ?, ? ) ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, activo);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	
	@Override
	public Integer actualizarCategoria(String id,String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE categorias set nombre = ?, descripcion = ?, activo = ? "
					+ "WHERE id_categoria = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		ps.setString(4, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}


	@Override
	public Integer borrarCategoria(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "UPDATE categorias set activo = 0 WHERE id_categoria LIKE ?  ";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
	
		return resultado;
	}


	

}


