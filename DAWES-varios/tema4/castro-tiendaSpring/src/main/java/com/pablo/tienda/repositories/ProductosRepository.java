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
	
   // List<ProductoEntity> findByNombreContainingAndPrecioBetween(String nombre, BigDecimal precioMin, BigDecimal precioMax);
    
	 @Query("SELECT new com.pablo.tienda.dtos.ProductoDTO(" +
	           "p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, " +
	           "p.categoriaEntity.id, p.proveedorEntity.id, p.categoriaEntity.nombre, p.proveedorEntity.nombre) " +
	           "FROM ProductoEntity p " +
	           "WHERE (:nombre IS NULL OR :nombre = '' OR p.nombre LIKE CONCAT('%', :nombre, '%')) " +
	           "AND (:descripcion IS NULL OR :descripcion = '' OR p.descripcion LIKE CONCAT('%', :descripcion, '%')) " +
	           "AND (:precio IS NULL OR p.precio = :precio) " +
	           "AND (:cantidadEnStock IS NULL OR p.cantidadEnStock = :cantidadEnStock) " +
	           "AND (:idCategoria IS NULL OR p.categoriaEntity.id = :idCategoria) " +
	           "AND (:idProveedor IS NULL OR p.proveedorEntity.id = :idProveedor)")
	 List<ProductoDTO> buscarProducto(@Param("nombre") String nombre,
             @Param("descripcion") String descripcion,
             @Param("precio") Double precio,
             @Param("cantidadEnStock") Integer cantidadEnStock,
             @Param("idCategoria") Integer idCategoria);

}

