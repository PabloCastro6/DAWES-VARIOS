package com.pablo.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pablo.tienda.entities.EstadoPedidoEntity;

@Repository
public interface EstadoPedidoRepository extends CrudRepository<EstadoPedidoEntity, Integer> {

}
