package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String servidor = "jdbc:mysql://localhost:3306/bancos";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(servidor, user, password);
    }
}
