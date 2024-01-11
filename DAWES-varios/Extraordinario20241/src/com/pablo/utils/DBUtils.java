package com.pablo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtils {
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String servidor = "jdbc:mysql://localhost:3306/cliente_facturas";
        String user = "root";
        String password = "PracticaRoot";
        return DriverManager.getConnection(servidor, user, password);
    }
}

