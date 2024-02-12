package com.pablo.tienda.springdatajpaimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IComboDAO;
import com.pablo.tienda.dtos.ComboDTO;
import com.pablo.tienda.entities.CategoriasEntity;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.entities.EstadoPedidoEntity;
import com.pablo.tienda.entities.ProductoEntity;
import com.pablo.tienda.repositories.CategoriasRepository;
import com.pablo.tienda.repositories.ClientesRepository;
import com.pablo.tienda.repositories.EstadoPedidoRepository;
import com.pablo.tienda.repositories.ProductosRepository;

@Component("combospringdatajpa")
public class CombosDAOImplSpringDataJPA implements IComboDAO {

	@Autowired
	private CategoriasRepository categoriaRepository;

	@Autowired
	private ProductosRepository productoRepository;

	@Autowired
	private ClientesRepository clienteRepository;
	
	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;

	@Override
	public List<ComboDTO> recuperaCombosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<CategoriasEntity> listaCategorias = categoriaRepository.findAll();
		return mapeoCategoriasEntityComboDTO(listaCategorias);
	}

	private List<ComboDTO> mapeoCategoriasEntityComboDTO(Iterable<CategoriasEntity> lista) {

		List<ComboDTO> combo = new ArrayList<>();

		for (CategoriasEntity m : lista) {
			combo.add(new ComboDTO(m.getId(), m.getNombre()));
		}

		return combo;
	}

	@Override
	public List<ComboDTO> recuperarCombosProductos() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<ProductoEntity> listaProductos = productoRepository.findAll();
		return mapeoProductosEntityComboDTO(listaProductos);
	}

	private List<ComboDTO> mapeoProductosEntityComboDTO(Iterable<ProductoEntity> lista) {

		List<ComboDTO> combo = new ArrayList<>();

		for (ProductoEntity m : lista) {
			combo.add(new ComboDTO(m.getId(), m.getNombre()));
		}

		return combo;
	}

	@Override
	public List<ComboDTO> recuperaCombosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperarCombosEstadoPedidos() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<EstadoPedidoEntity> listaEstado = estadoPedidoRepository.findAll();
		return mapeoEstadoEntityComboDTO(listaEstado);
	}

	private List<ComboDTO> mapeoEstadoEntityComboDTO(Iterable<EstadoPedidoEntity> lista) {

		List<ComboDTO> combo = new ArrayList<>();

		for (EstadoPedidoEntity m : lista) {
			combo.add(new ComboDTO(m.getId(), m.getNombre()));
		}

		return combo;
	}

	@Override
	public List<ComboDTO> recuperarCombosClientes() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<ClientesEntity> listaClientes = clienteRepository.findAll();
		return mapeoClientesEntityComboDTO(listaClientes);
	}

	private List<ComboDTO> mapeoClientesEntityComboDTO(Iterable<ClientesEntity> lista) {

		List<ComboDTO> combo = new ArrayList<>();

		for (ClientesEntity m : lista) {
			combo.add(new ComboDTO(m.getId(), m.getNombre()));
		}

		return combo;
	}
}
