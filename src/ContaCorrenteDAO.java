import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaCorrenteDAO {

     public void create(ContaCorrente contaC){

         Connection con = ConnectionFactory.getConnection();
         
         PreparedStatement stmt = null;


         try {

               stmt = con.prepareStatement(""); //script sql

               stmt.setDouble(1, contaC.getSaldo());

               stmt.setInt(2, contaC.getNumero());

               stmt.setString(3, contaC.getCliente().getNome());

               stmt.executeUpdate();

               System.out.println("Salvo com Sucesso!");

          } 
          catch (SQLException e) {

               System.out.println("Erro ao salvar...");

               e.printStackTrace();

          }
          finally{

               ConnectionFactory.closeConnection(con, stmt);

          }
 
          }
     
}
