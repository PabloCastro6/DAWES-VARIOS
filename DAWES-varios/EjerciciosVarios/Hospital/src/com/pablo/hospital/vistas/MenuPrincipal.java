package com.pablo.hospital.vistas;

import java.sql.SQLException;
import java.util.Scanner;

import com.pablo.hospital.utils.MiScanner;

public class MenuPrincipal {
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE HOSPITAL");
			System.out.println("===============================================");
			System.out.println("1- Gestión de  Pacientes");
			System.out.println("2- Gestión de Médicos");
			System.out.println("3- Gestión de Citas");
			System.out.println("4- Gestión de Departamentos");
			System.out.println("5- Gestión de Historial Médico");
			System.out.println("6- Gestión de Facturación");
			System.out.println("7- Gestión de Farmacia");
			System.out.println("8- Gestión de Recetas Médicas");
			System.out.println("9- Gestión de Habitaciones");
			System.out.println("10- Gestión de Admisiones");
			System.out.println("11- Gestión de Alergias");
			System.out.println("12- Gestión de Estado de Citas");
			System.out.println("13- Gestión de Estado de Facturación");
			System.out.println("14- Salir");

			n = Integer.parseInt(sc.nextLine());

			if (n > 14 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				System.out.println("Ahora ejecutaría la gestión de Pacientes");
				VistaPaciente vm = new VistaPaciente();
				vm.menuGeneralPaciente();
				continue;
			}

			if (n == 2) {
				System.out.println("Ahora ejecutaría la gestión de Médicos");
				VistaMedico vm = new VistaMedico();
				vm.menuGeneralMedico();
				continue;
			}
			if (n == 3) {
				System.out.println("Ahora ejecutaría la gestión Citas");
				VistaCitas vc = new VistaCitas();
				vc.menuGeneralCita();
				continue;
			}
			if (n == 4) {
				System.out.println("Ahora ejecutaría la gestión Departamentos");
				VistaDepartamentos vm = new VistaDepartamentos();
				vm.menuGeneralDepartamentos();
				continue;
			}

			if (n == 5) {
				System.out.println("Ahora ejecutaria la gestion de Historial Medico");
				VistaHistorialMedico hm = new VistaHistorialMedico();
				hm.menuGeneralHistorialMedico();
				continue;
			}

			if (n == 6) {
				System.out.println("Ahora ejecutaria la gestion de Facturacion");
				VistaFacturacion hm = new VistaFacturacion();
				hm.menuGeneralFacturacion();

				continue;
			}

			if (n == 7) {
				System.out.println("Ahora ejecutaria la gestion de Farmacia");
				VistaFarmacia vm = new VistaFarmacia();
				vm.menuGeneralFarmacia();
				continue;
			}

			if (n == 8) {
				System.out.println("Ahora ejecutaria la gestion de Recetas Medicas");
				VistasRecetasMedica rm = new VistasRecetasMedica();
				rm.menuGeneralRecetasMedicas();

				continue;
			}

			if (n == 9) {
				System.out.println("Ahora ejecutaria la gestion de Habitaciones ");
				VistaHabitaciones vm = new VistaHabitaciones();
				vm.menuGeneralHabitacion();
				continue;

			}
			if (n == 10) {
				System.out.println("Ahora ejecutaria la gestion de Admisiones ");

				continue;

			}

			if (n == 11) {
				System.out.println("Ahora ejecutaria la gestion de Alergias ");
				VistaAlergias vc = new VistaAlergias();
				vc.menuGeneralAlergias();

				continue;

			}

			if (n == 12) {
				System.out.println("Ahora ejecutaria la gestion de Estado Citas ");
				VistaCitas vc = new VistaCitas();
				vc.menuGeneralCita();
				continue;

			}

			if (n == 13) {
				System.out.println("Ahora ejecutaria la gestion de Estado de Facturación ");
				VistaEstadoFacturacion vc = new VistaEstadoFacturacion();
				vc.menuGeneralEstadoFacturacion();

				continue;

			}

		} while (n != 14);
	}

}