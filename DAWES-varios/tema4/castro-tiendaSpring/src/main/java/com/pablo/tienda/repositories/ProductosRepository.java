package com.pablo.tienda.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dtos.ProductoDTO;
import com.pablo.tienda.entities.ProductoEntity;

@Repository
public interface ProductosRepository extends CrudRepository<ProductoEntity, Integer> {

	// List<ProductoEntity> findByNombreContainingAndPrecioBetween(String nombre,
	// BigDecimal precioMin, BigDecimal precioMax);

	@Query("SELECT new com.pablo.tienda.dtos.ProductoDTO("
			+ "p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, "
			+ "p.categoriaEntity.id, p.proveedorEntity.id) " + "FROM com.pablo.tienda.entities.ProductoEntity p "
			+ "WHERE (:nombre IS NULL OR :nombre = '' OR p.nombre LIKE CONCAT('%', :nombre, '%')) "
			+ "AND (:descripcion IS NULL OR :descripcion = '' OR p.descripcion LIKE CONCAT('%', :descripcion, '%')) "
			+ "AND (:precio IS NULL OR :precio = '' OR p.precio >= CAST (:precio AS BigDecimal)) "
			+ "AND (:cantidadEnStock IS NULL OR :cantidadEnStock = '' OR p.cantidadEnStock >= CAST(:cantidadEnStock AS BigDecimal)) "
			+ "AND (:idCategoria IS NULL OR :idCategoria = '' OR p.categoriaEntity.id = CAST (:idCategoria AS Integer)) "
			+ "AND (:idProveedor IS NULL OR :idProveedor = '' OR p.proveedorEntity.id = CAST (:idProveedor AS Integer)) "
			+ "AND (:id IS NULL OR :id = '' OR p.id = CAST (:id AS Integer))")

	List<ProductoDTO> buscarProducto(@Param("id") String id, @Param("nombre") String nombre,
			@Param("descripcion") String descripcion, @Param("precio") String precio,
			@Param("cantidadEnStock") String cantidadEnStock, @Param("idCategoria") String idCategoria,
			@Param("idProveedor") String idProveedor);

}
