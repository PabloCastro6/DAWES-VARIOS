package com.pablo.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.dtos.ProveedorDTO;
import com.pablo.tienda.entities.ProveedorEntity;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedorEntity, Integer> {
	
	@Query("SELECT new com.pablo.tienda.dtos.ProveedorDTO(" +
	           "p.id, p.nombre, p.contacto, p.telefono, p.correoElectronico, p.direccion, p.activo) " +
	           "FROM ProveedorEntity p " +
	           "WHERE (:nombre IS NULL OR p.nombre LIKE %:nombre%) " +
	           "AND (:contacto IS NULL OR p.contacto LIKE %:contacto%) " +
	           "AND (:telefono IS NULL OR p.telefono = :telefono) " +
	           "AND (:correo IS NULL OR p.correoElectronico = :correo) " +
	           "AND (:direccion IS NULL OR p.direccion LIKE %:direccion%) " +
	           "AND (:activo IS NULL OR p.activo = :activo)")
	    List<ProveedorDTO> buscarProveedoresConFiltros(@Param("nombre") String nombre,
	                                                   @Param("contacto") String contacto,
	                                                   @Param("telefono") String telefono,
	                                                   @Param("correo") String correo,
	                                                   @Param("direccion") String direccion,
	                                                   @Param("activo") Integer activo);
	}

