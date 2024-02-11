package com.pablo.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dtos.CategoriasDTO;
import com.pablo.tienda.entities.CategoriasEntity;

@Repository
public interface CategoriasRepository extends CrudRepository<CategoriasEntity, Integer> {

	@Query(value = "SELECT new com.pablo.tienda.dtos.CategoriasDTO(a.id, a.nombre, a.descripcion, a.activo) " +
	        "FROM com.pablo.tienda.entities.CategoriasEntity a " +
	        "WHERE (:nombre IS NULL OR :nombre = '' OR a.nombre LIKE CONCAT('%', :nombre, '%')) " +
	        "AND (:descripcion IS NULL OR :descripcion = '' OR a.descripcion LIKE CONCAT('%', :descripcion, '%')) " +
	        "AND (:activo IS NULL OR a.activo = :activo)")
	
	public List<CategoriasDTO> buscaCategorias(@Param("nombre") String nombre,
	                                           @Param("descripcion") String descripcion,
	                                           @Param("activo") Integer activo);

}