import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;

public class ConnectionFactory {
     
     private final String DRIVER = "com.mysql.jdbc.Driver";
     private final String URL = "jdbc:mysql://localhost:3306/banco_trabalho";
     private final String USER = "root"; // ver o de vcs
     private final String PASS = "164087"; // ver o de vcs

     public Connection getConnection(){

          try {
               
          } catch (Exception e) {
               e.getMessage();
          }
}