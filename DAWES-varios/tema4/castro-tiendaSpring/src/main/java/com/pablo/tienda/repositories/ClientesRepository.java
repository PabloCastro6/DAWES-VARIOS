package com.pablo.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.entities.ClientesEntity;

@Repository
public interface ClientesRepository extends CrudRepository<ClientesEntity, Integer> {

}
