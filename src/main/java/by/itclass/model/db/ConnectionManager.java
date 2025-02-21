package by.itclass.model.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String URL = "jdbc:mysql://localhost:3306/po_2402";

    private static Connection cn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (cn == null) {
            return DriverManager.getConnection(URL, "root", "");
        }
        return cn;
    }
}
