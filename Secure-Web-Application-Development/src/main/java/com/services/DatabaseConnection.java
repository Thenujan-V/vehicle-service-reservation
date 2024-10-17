package com.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        //  set properties in the code
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/is_assessment");
        properties.setProperty("db.username", "root");
        properties.setProperty("db.password", "Thenujan#");
        properties.setProperty("db.driver", "com.mysql.cj.jdbc.Driver");
    }


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("db.driver"));
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
    }
}
