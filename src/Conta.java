public class Conta {
     private double saldo;
     private Integer numero;
     private Cliente cliente;

     public Conta(double saldo, Integer numero, Cliente cliente){

     }

     public double getSaldo() {
          return saldo;
     }

     public void setSaldo(double saldo) {
          this.saldo = saldo;
     }

     public Integer getNumero() {
          return numero;
     }

     public void setNumero(Integer numero) {
          this.numero = numero;
     }

     public Cliente getCliente() {
          return cliente;
     }

     public void setCliente(Cliente cliente) {
          this.cliente = cliente;
     }

     
}
