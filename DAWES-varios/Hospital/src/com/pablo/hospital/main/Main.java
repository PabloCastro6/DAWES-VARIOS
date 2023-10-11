package com.pablo.hospital.main;

import java.sql.SQLException;

import com.pablo.hospital.vistas.MenuPrincipal;



public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();

	}

}


