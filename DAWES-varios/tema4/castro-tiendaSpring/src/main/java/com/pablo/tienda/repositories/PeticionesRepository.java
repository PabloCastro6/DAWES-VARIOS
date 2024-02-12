
package com.pablo.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.entities.PeticionEntity;

@Repository
public interface PeticionesRepository extends CrudRepository<PeticionEntity, Integer> {

	
    @Query("SELECT new com.pablo.tienda.dtos.PeticionesDTO(" +
           "p.peticionID, " +
           "p.cliente.id, " +
           "p.producto.id, " +
           "p.estado.id, " +
           "p.fecha, " +
           "p.cantidad, " +
           "p.cliente.nombre, " +
           "p.producto.nombre, " +
           "p.estado.nombreEstado) " +
           "FROM com.pablo.tienda.entities.PeticionEntity p " +
           "WHERE (:idCliente IS NULL OR p.cliente.id = :idCliente) " +
           "AND (:idProducto IS NULL OR p.producto.id = :idProducto) " +
           "AND (:idEstado IS NULL OR p.estado.id = :idEstado)")
    List<PeticionesDTO> buscarPorFiltros(@Param("idCliente") Integer idCliente,
                                         @Param("idProducto") Integer idProducto,
                                         @Param("idEstado") Integer idEstado);
}

