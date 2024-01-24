package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.pablo.tienda.dao.tndimpl.PeticionesDAOImplTnd;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

//public class PeticionesService implements IPeticionesService{
//	
////	@Override
//    public List<PeticionesDTO> buscarPeticiones(String idPeticiones, String idCliente, String idProducto, String fechaAñadido, String cantidad, String estado)
//            throws ClassNotFoundException, SQLException, NamingException {
//        return new PeticionesDAOImplTnd().buscarPeticiones(idPeticiones, idCliente, idProducto, fechaAñadido, cantidad, estado);
//    }
//
//    @Override
//    public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
//            throws ClassNotFoundException, SQLException, NamingException {
//        return new PeticionesDAOImplTnd().insertarPeticiones(idCliente, idProducto, cantidad, estado);
//    }
//
//    @Override
//    public Integer actualizarPeticiones(String idPeticiones, String idCliente, String idProducto, String cantidad, String estado)
//            throws ClassNotFoundException, SQLException, NamingException {
//        return new PeticionesDAOImplTnd().actualizarPeticiones(idPeticiones, idCliente, idProducto, cantidad, estado);
//    }
//
//    @Override
//    public Integer borrarPeticiones(String idPeticiones)
//            throws ClassNotFoundException, SQLException, NamingException {
//        return new PeticionesDAOImplTnd().borrarPeticiones(idPeticiones);
//    }


