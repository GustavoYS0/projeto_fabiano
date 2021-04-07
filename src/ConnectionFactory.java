

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

     private static final String DRIVER = "com.mysql.jdbc.Driver";
     private static final String URL = "jdbc:mysql://localhost:3306/banco_trabalho";
     private static final String USER = "root"; // ver o de vcs
     private static final String PASS = "164087"; // ver o de vcs

     public static Connection getConnection(){

          try {
               Class.forName(DRIVER);

               return DriverManager.getConnection(URL, USER, PASS);
          }
          catch (SQLException | ClassNotFoundException e) {
               throw new RuntimeException("Erro na conexão: ", e);

          }
     
     }

     public static void closeConnection(Connection con){

          try {

               if(con != null){

                    con.close();
     
               }

          } catch (SQLException e) {

               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,e);

          }

     }

     public static void closeConnection(Connection con, PreparedStatement stmt){

          closeConnection(con);

          try {

               if(stmt != null){

                    stmt.close();
                    
     
               }

          } catch (SQLException e) {

               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,e);
               
          }

     }

     public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){

          closeConnection(con, stmt);

          try {

               if(rs != null){

                    rs.close();
     
               }

          } catch (SQLException e) {

               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,e);
               
          }

     }
}
