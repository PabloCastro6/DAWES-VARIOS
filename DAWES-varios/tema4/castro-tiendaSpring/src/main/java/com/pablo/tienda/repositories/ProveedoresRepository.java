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

	@Query(value = " select new com.pablo.tienda.dtos.ProveedorDTO (p.id, p.nombre,  p.contacto,  p.telefono,  p.correoElectronico,  p.direccion,  p.activo) "
			+ " FROM com.pablo.tienda.entities.ProveedorEntity p "
			+ " WHERE cast (p.id AS string) LIKE CONCAT ('%', :id, '%') "
			+ " AND p.nombre like CONCAT ('%', :nombre, '%') " + " AND p.contacto like CONCAT ('%', :contacto, '%') "
			+ " AND p.telefono like CONCAT ('%', :telefono, '%') "
			+ " AND p.correoElectronico LIKE CONCAT ('%', :correoElectronico, '%') "
			+ " AND p.direccion LIKE CONCAT ('%', :direccion, '%') " + " AND p.activo = :activo ")

	public List<ProveedorDTO> buscaProveedores(@Param("id") String id, @Param("nombre") String nombre,
			@Param("contacto") String contacto, @Param("telefono") String telefono,
			@Param("correoElectronico") String correoElectronico, @Param("direccion") String direccion,
			@Param("activo") Integer activo);

}
