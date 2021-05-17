package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost/cadastro";
            String usuario = "root";
            String senha = "12345";
            return DriverManager.getConnection(url,usuario,senha);   
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
}
