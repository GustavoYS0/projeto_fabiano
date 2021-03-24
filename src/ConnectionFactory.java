

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

     private final String DRIVER = "com.mysql.jdbc.Driver";
     private final String URL = "jdbc:mysql://localhost:3306/banco_trabalho";
     private final String USER = "root"; // ver o de vcs
     private final String PASS = "164087"; // ver o de vcs

     public Connection getConnection(){

          try {
               Class.forName(DRIVER);

               return DriverManager.getConnection(URL, USER, PASS);
          }
          catch (SQLException | ClassNotFoundException e) {
               e.getMessage();

          }
          return null;// apenas para sumir erro
     
     }
}
