package com.pablo.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pablo.tienda.dao.ICategoriasDAO;
import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.negocio.IPeticionesService;

@Service
public class PeticionesService implements IPeticionesService{
	
	@Autowired
	@Qualifier("HibernateImplPeticiones")
	IPeticionesDAO peticionesDAO;
	
	@Override
    public List<PeticionesDTO> buscarPeticiones(String idPeticiones, String idCliente, String idProducto, String fechaAñadido, String cantidad, String estado)
            throws ClassNotFoundException, SQLException, NamingException {
        return peticionesDAO.buscarPeticiones(idPeticiones, idCliente, idProducto, fechaAñadido, cantidad, estado);
    }

    @Override
    public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String estado)
            throws ClassNotFoundException, SQLException, NamingException {
        return peticionesDAO.insertarPeticiones(idCliente, idProducto, cantidad, estado);
    }

    @Override
    public Integer actualizarPeticiones(String idPeticiones, String idCliente, String idProducto, String cantidad, String estado)
            throws ClassNotFoundException, SQLException, NamingException {
        return peticionesDAO.actualizarPeticiones(idPeticiones, idCliente, idProducto, cantidad, estado);
    }

    @Override
    public Integer borrarPeticiones(String idPeticiones)
            throws ClassNotFoundException, SQLException, NamingException {
        return peticionesDAO.borrarPeticiones(idPeticiones);
    }
}
