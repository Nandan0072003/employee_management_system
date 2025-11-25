package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "javauser";
    private static final String PASSWORD = "java123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}