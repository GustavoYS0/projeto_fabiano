public class ContaCorrente extends Conta {

     private double limite;

     public ContaCorrente(double saldo, Integer numero, Cliente cliente, double limite) {
          super(saldo, numero, cliente);
     }
     
}
