package com.pablo.tienda.springdatajpaimpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IProductoDAO;
import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.entities.ProveedorEntity;
import com.pablo.tienda.repositories.CategoriasRepository;
import com.pablo.tienda.repositories.ProductosRepository;
import com.pablo.tienda.repositories.ProveedoresRepository;

@Component("ProductosDAOImplSpringDataJPA")
public class ProductosDAOImplSpringDataJPA implements IProductoDAO {

	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	private CategoriasRepository categoriasRepository;

	@Autowired
	private ProveedoresRepository proveedoresRepository;

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor)
			throws ClassNotFoundException, SQLException, NamingException {

		return productosRepository.buscarProducto(id, nombre, descripcion, precio, cantidadStock, idCategoria,
				idProveedor);
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException {

		CategoriasEntity categoriaEntity = null;
		ProveedorEntity proveedorEntity = null;

		if (idCategoria != null && !idCategoria.isEmpty()) {
			categoriaEntity = categoriasRepository.findById(Integer.parseInt(idCategoria)).orElse(null);
		}

		if (idProveedor != null && !idProveedor.isEmpty()) {
			proveedorEntity = proveedoresRepository.findById(Integer.parseInt(idProveedor)).orElse(null);
		}

		BigDecimal precioDecimal = (!precio.isEmpty()) ? new BigDecimal(precio) : BigDecimal.ZERO;
		Integer cantidadEnStock = (!cantidadStock.isEmpty()) ? Integer.parseInt(cantidadStock) : 0;

		ProductoEntity producto = new ProductoEntity(nombre, descripcion, precioDecimal, cantidadEnStock,
				categoriaEntity, proveedorEntity);
		productosRepository.save(producto);
		return producto.getId();
	}

//		CategoriasEntity categoriaEntity = categoriasRepository.findById(Integer.parseInt(idCategoria)).get();
//		ProveedorEntity proveedorEntity = proveedoresRepository.findById(Integer.parseInt(idProveedor)).get();
//
//		BigDecimal precioDecimal = new BigDecimal(precio);
//		Integer cantidadEnStock = Integer.valueOf(cantidadStock);
//
//		ProductoEntity p = new ProductoEntity(nombre, descripcion, precioDecimal, cantidadEnStock, categoriaEntity,
//				proveedorEntity);
//		productosRepository.save(p);
//		return p.getId();

//	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException, NamingException {

		CategoriasEntity categoriaEntity = categoriasRepository.findById(Integer.parseInt(idCategoria)).get();
		ProveedorEntity proveedorEntity = proveedoresRepository.findById(Integer.parseInt(idProveedor)).get();

		BigDecimal precioDecimal = new BigDecimal(precio);
		Integer cantidadEnStock = Integer.parseInt(cantidadStock);

		Integer idProducto = Integer.parseInt(id);

		ProductoEntity p = new ProductoEntity(idProducto, nombre, descripcion, precioDecimal, cantidadEnStock,
				categoriaEntity, proveedorEntity);

		productosRepository.save(p);
		return p.getId();
	}

	@Override
	public ProductoDTO buscarProductoPorID(Integer id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
