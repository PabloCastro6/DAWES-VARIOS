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
//
//	    @Query(value = "select new com.pablo.tienda.dtos.ClienteDTO(c.id, c.nombre, c.correoElectronico, p.id, c.activo, p.nombre) "
//	            + "from com.pablo.tienda.entities.ClientesEntity c "
//	            + "INNER JOIN c.poblacion p "
//	            + "WHERE CAST(c.id AS string) LIKE CONCAT('%', :id, '%') "
//	            + "AND c.nombre LIKE CONCAT('%', :nombre, '%') "
//	            + "AND c.correoElectronico LIKE CONCAT('%', :correoElectronico, '%') "
//	            + "AND (:idPoblacion is null OR p.id = :idPoblacion) "
//	            + "AND c.activo = :activo ")
//	    List<ClienteDTO> buscarCliente(@Param("id") String id,
//	                                    @Param("nombre") String nombre,
//	                                    @Param("correoElectronico") String correoElectronico,
//	                                    @Param("idPoblacion") Integer idPoblacion,
//	                                    @Param("activo") Integer activo);
	}


