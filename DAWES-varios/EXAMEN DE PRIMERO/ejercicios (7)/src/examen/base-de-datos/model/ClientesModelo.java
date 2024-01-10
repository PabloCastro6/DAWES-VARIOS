package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dtos.BancoDTO;
import utils.BaseDeDatos;

public class ClientesModelo {
    
    public static boolean crear(BancoDTO cliente) throws SQLException {
        try {
            Connection connection = BaseDeDatos.conectar();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO alumnos (nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?)");
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getTelefono());
            int count = statement.executeUpdate();
            connection.close();
            return count > 0;
        } catch (ClassNotFoundException exception) {
            System.err.println(exception.getMessage());
            return false;
        }
    }

    public static BancoDTO buscar(int id) throws SQLException {
        try {
            Connection connection = BaseDeDatos.conectar();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM clientes cl LEFT JOIN cuentas cu ON cl.id_usuario = cu.id_usuario WHERE cl.id_usuario = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            BancoDTO cliente = null;

            if (result.next()) {
                int idUsuario = result.getInt("id_usuario");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String direccion = result.getString("direccion");
                String telefono = result.getString("telefono");
                int numeroCuenta = result.getInt("numero_cuenta");
                float saldo = result.getFloat("saldo");
                cliente = new BancoDTO(idUsuario, nombre, apellido, direccion, telefono, numeroCuenta, saldo);
            }

            connection.close();
            return cliente;
        } catch (ClassNotFoundException exception) {
            System.err.println(exception.getMessage());
            return null;
        }
    }

    public static boolean actualizar(BancoDTO cliente) throws SQLException {
        try {
            Connection connection = BaseDeDatos.conectar();
            PreparedStatement statement = connection.prepareStatement("UPDATE clientes "
            + "SET nombre = CASE WHEN ? = '' THEN nombre ELSE ? END, " // Dos interrogaciones para el mismo campo nombre
            + "apellido = CASE WHEN ? = '' THEN apellido ELSE ? END, " // Dos interrogaciones para el mismo campo apellido
            + "direccion = CASE WHEN ? = '' THEN direccion ELSE ? END, " // Dos interrogaciones para el mismo campo direccion
            + "telefono = CASE WHEN ? = '' THEN telefono ELSE ? END " // Dos interrogaciones para el mismo campo telefono
            + "WHERE id_usuario = ?"); // Interrogación para el identificador del cliente
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, cliente.getDireccion());
            statement.setString(6, cliente.getDireccion());
            statement.setString(7, cliente.getTelefono());
            statement.setString(8, cliente.getTelefono());
            statement.setInt(9, cliente.getId());
            int count = statement.executeUpdate();
            connection.close();
            return count > 0;
        } catch (ClassNotFoundException exception) {
            System.err.println(exception.getMessage());
            return false;
        }
    }
    
    public static boolean borrar(int id) throws SQLException {
        try {
            Connection connection = BaseDeDatos.conectar();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clientes WHERE id_usuario = ?");
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            connection.close();
            return count > 0;
        } catch (ClassNotFoundException exception) {
            System.err.println(exception.getMessage());
            return false;
        }
    }
}
