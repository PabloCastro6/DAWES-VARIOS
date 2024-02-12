package com.pablo.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dtos.ClienteDTO;
import com.pablo.tienda.entities.ClientesEntity;

@Repository
public interface ClientesRepository extends CrudRepository<ClientesEntity, Integer> {
	
	 @Query("SELECT new com.pablo.tienda.dtos.ClienteDTO(" +
	           "c.id, c.nombre, c.correoElectronico, c.idPoblacion, c.activo, p.nombre) " +
	           "FROM ClientesEntity c " +
	           "JOIN PoblacionEntity p ON c.idPoblacion = p.id " +
	           "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
	           "AND (:correo IS NULL OR c.correoElectronico = :correo) " +
	           "AND (:idPoblacion IS NULL OR c.idPoblacion = :idPoblacion) " +
	           "AND (:activo IS NULL OR c.activo = :activo)")
	    List<ClienteDTO> buscarPorFiltros(@Param("nombre") String nombre,
	                                      @Param("correo") String correo,
	                                      @Param("idPoblacion") Integer idPoblacion,
	                                      @Param("activo") Integer activo);

}
