package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPeticionesDAO;
import com.pablo.tienda.dtos.PeticionesDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.EstadoPedidoEntity;
import com.pablo.tienda.entities.PeticionEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.repositories.ClientesRepository;
import com.pablo.tienda.repositories.EstadoPedidoRepository;
import com.pablo.tienda.repositories.PeticionesRepository;
import com.pablo.tienda.repositories.ProductosRepository;

@Component("PeticionesDAOImplSpringDataJPA")
public class PeticionesDAOImplSpringDataJPA implements IPeticionesDAO {

	@Autowired
	private PeticionesRepository peticionesRepository;

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;

	@Override
	public List<PeticionesDTO> buscarPeticion(String idPeticiones, String idCliente, String idProducto,
			String fechaAñadido, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {

		return peticionesRepository.buscarPorFiltros("%" + idPeticiones + "%", "%" + idCliente + "%",
				"%" + idProducto + "%", fechaAñadido, cantidad, "%" + estado + "%");

	}

	@Override
	public Integer insertarPeticion(String idCliente, String idProducto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {

		ClientesEntity clienteEntity = clientesRepository.findById(Integer.parseInt(idCliente)).get();
		ProductoEntity productoEntity = productosRepository.findById(Integer.parseInt(idProducto)).get();
		EstadoPedidoEntity estadoPedidoEntity = estadoPedidoRepository.findById(Integer.parseInt(estado)).get();

		PeticionEntity p = new PeticionEntity(clienteEntity, productoEntity, Integer.parseInt(cantidad),
				estadoPedidoEntity);

		peticionesRepository.save(p);
		return p.getPeticionID();
	}

	@Override
	public Integer actualizarPeticion(String id, String idCliente, String idProducto, String fechaAnhadido,
			String cantidad, String idEstadoPedido) throws ClassNotFoundException, SQLException, NamingException {

		ClientesEntity clienteEntity = clientesRepository.findById(Integer.parseInt(idCliente)).get();
		ProductoEntity productoEntity = productosRepository.findById(Integer.parseInt(idProducto)).get();
		EstadoPedidoEntity estadoPedidoEntity = estadoPedidoRepository.findById(Integer.parseInt(idEstadoPedido)).get();
		;

		PeticionEntity p = new PeticionEntity(Integer.parseInt(id), clienteEntity, productoEntity, fechaAnhadido,
				Integer.parseInt(cantidad), estadoPedidoEntity);

		peticionesRepository.save(p);
		return p.getPeticionID();
	}

	@Override
	public Integer borrarPeticion(String idPeticiones) throws ClassNotFoundException, SQLException, NamingException {
		Integer id = Integer.parseInt(idPeticiones);
		// peticionesRepository.deleteById (id);

		PeticionEntity peticion = peticionesRepository.findById(id).get();
		EstadoPedidoEntity estado = estadoPedidoRepository.findById(5).get();
		peticion.setEstado(estado);

		peticionesRepository.save(peticion);

		return peticion.getPeticionID();

		// return id;
	}
}
