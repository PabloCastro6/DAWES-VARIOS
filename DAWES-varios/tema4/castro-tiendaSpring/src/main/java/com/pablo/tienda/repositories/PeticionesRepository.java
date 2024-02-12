
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

	@Query("SELECT new com.pablo.tienda.dtos.PeticionesDTO (p.peticionID, p.cliente.id, p.producto.id, p.estado.id,p.fecha, p.cantidad, p.cliente.nombre, p.producto.nombre, p.estado.nombre)"
			+ " FROM com.pablo.tienda.entities.PeticionEntity p WHERE  CAST (p.peticionID  AS string) LIKE :peticion AND CAST (p.cliente.id AS string) LIKE :cliente AND CAST(p.producto.id AS string) LIKE :producto "
			+ " AND (CASE WHEN :fecha = ''  THEN  CAST(p.fecha AS DATE) >= CAST ('1970-01-01' AS DATE )  ELSE CAST(p.fecha AS Date) >= CAST (:fecha AS DATE) END ) "
			+ " AND (case WHEN :cantidad = '' THEN p.cantidad >=0 ELSE p.cantidad >= CAST(:cantidad AS Integer) END) "
			+ " AND CAST (p.estado.id AS String) LIKE :estado")

	List<PeticionesDTO> buscarPorFiltros(@Param("peticion") String idPeticiones, @Param("cliente") String idCliente,
			@Param("producto") String idProducto, @Param("fecha") String fecha, @Param("cantidad") String cantidad,
			@Param("estado") String idEstado);
}
