package com.pract.classicmodels.main;

import java.sql.SQLException;

import com.pract.classicmodels.model.PedidosModel;
import com.pract.classicmodels.vistas.MenuPrincipal;

class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		VistaClientes vc = new VistaClientes();
//		vc.menuRecuperaNombreTelefonoFiltrando();
		
//		vc.menuInsertaCliente();
		
//		vc.menuActualizaCliente();
		
//		PedidosModel pm = new PedidosModel();
//		List<CantidadPedidaProducto> lista = new ArrayList<>();
//		lista.add(new CantidadPedidaProducto("S10_1678", 3));
//		lista.add(new CantidadPedidaProducto("S10_1949", 1));
//		
//		pm.creaPedido("2021-05-1", "2021-05-06", "En proceso", "", 103, lista);
		
		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();

	}

}
