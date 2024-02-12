package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.repositories.ProductosRepository;

@Component("ProductosDAOImplSpringDataJPA")
public class ProductosDAOImplSpringDataJPA implements IProductoDAO {

	@Autowired
	private ProductosRepository productosRepository;

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		
		 
        Integer idCategoriaInt = (idCategoria != null && !idCategoria.isEmpty()) ? Integer.valueOf(idCategoria) : null;
        Integer idProveedorInt = (idProveedor != null && !idProveedor.isEmpty()) ? Integer.valueOf(idProveedor) : null;

        
        return productosRepository.buscarProducto(nombre, null, null, idCategoriaInt, idProveedorInt);
    }
  
	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException {
		
		// ProductoEntity p = new ProductoEntity(nombre,descripcion,Integer.parseInt(precio),Integer.parseInt(cantidadStock),CategoriasEntity,ProveedorEntity);
		
	//	productosRepository.save(p);
	//	return p.getId();
		return null;
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDTO buscarProductoPorID(Integer id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
