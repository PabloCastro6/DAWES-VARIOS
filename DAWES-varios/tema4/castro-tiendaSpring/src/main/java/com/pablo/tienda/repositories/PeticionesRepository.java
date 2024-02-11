package com.pablo.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.entities.PeticionEntity;

@Repository
public interface PeticionesRepository extends CrudRepository<PeticionEntity, Integer> {

}
