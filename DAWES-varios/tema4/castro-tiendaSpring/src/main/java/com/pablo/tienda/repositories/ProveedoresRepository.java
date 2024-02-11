package com.pablo.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.entities.ProveedorEntity;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedorEntity, Integer> {

}
