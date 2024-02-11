package com.pablo.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.entities.ProductoEntity;



@Repository
public interface ProductosRepository  extends CrudRepository<ProductoEntity, Integer> {

}
