import java.sql.SQLException;
import java.util.Scanner;

import dtos.BancoDTO;
import model.ClientesModelo;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuPrincipal(sc);
        sc.close();
    }

    public static void menuPrincipal(Scanner sc) {
        int accion = 0;
        do {
            System.out.flush();
            System.out.println("\nAPLICACIÓN BANCOS");
            System.out.println("1. Crear cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("5. Salir");
            System.out.print("¿Qué acción deseas ejecutar?: ");
            accion = sc.nextInt();
            sc.nextLine();
            try {
                switch (accion) {
                    case 1:
                        crearCliente(sc);
                        break;
                    case 2:
                        buscarCliente(sc);
                        break;
                    case 3:
                        actualizarCliente(sc);
                        break;
                    case 4:
                        borrarCliente(sc);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } catch (SQLException exception) {
                exception.printStackTrace(); //imprime el fallo
            }
        } while (accion != 5);
    }

    public static void crearCliente(Scanner sc) throws SQLException {
        BancoDTO cliente = new BancoDTO();
        System.out.flush();
        System.out.println("\nCREAR CLIENTE");
        System.out.print("Nombre: ");
        cliente.setNombre(sc.nextLine());
        System.out.print("Apellido: ");
        cliente.setApellido(sc.nextLine());
        System.out.print("Dirección: ");
        cliente.setDireccion(sc.nextLine());
        System.out.print("Teléfono: ");
        cliente.setTelefono(sc.nextLine());
        boolean exito = ClientesModelo.crear(cliente);
        if (exito) {
            System.out.println("Cliente creado correctamente.");
        } else {
            System.out.println("Cliente no creado.");
        }
    }

    public static void buscarCliente(Scanner sc) throws SQLException {
        System.out.flush();
        System.out.println("\nBUSCAR CLIENTE");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        BancoDTO cliente = ClientesModelo.buscar(id);
        if (cliente != null) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("Número de cuenta: " + cliente.getNumeroCuenta());
            System.out.println("Saldo: " + cliente.getSaldo());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void actualizarCliente(Scanner sc) throws SQLException {
        BancoDTO cliente = new BancoDTO();
        String input;
        System.out.flush();
        System.out.println("\nACTUALIZAR CLIENTE");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        cliente.setId(id);
        sc.nextLine();
        System.out.print("Nombre: ");
        input = sc.nextLine();
        cliente.setNombre(input);
        System.out.print("Apellido: ");
        input = sc.nextLine();
        cliente.setApellido(input);
        System.out.print("Dirección: ");
        input = sc.nextLine();
        cliente.setDireccion(input);
        System.out.print("Teléfono: ");
        input = sc.nextLine();
        cliente.setTelefono(input);
        boolean exito = ClientesModelo.actualizar(cliente);
        if (exito) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("Cliente no actualizado.");
        }
    }

    public static void borrarCliente(Scanner sc) throws SQLException {
        System.out.flush();
        System.out.println("\nBORRAR CLIENTE");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean exito = ClientesModelo.borrar(id);
        if (exito) {
            System.out.println("Cliente borrado correctamente.");
        } else {
            System.out.println("Cliente no borrado.");
        }
    }
}
