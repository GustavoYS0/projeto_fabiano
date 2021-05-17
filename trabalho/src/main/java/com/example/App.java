package com.example;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);
        int valor=1;
        while(valor!=8){
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar Cliente");
            System.out.println("2 - Criar Conta Corrente");
            System.out.println("3 - Criar Conta Poupança");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");
            System.out.println("6 - Ver o saldo");
            System.out.println("7 - Listar contas");
            System.out.println("8 Sair");
            System.out.print("\nOPÇÃO: ");
            valor=scanner.nextInt();
            if(valor==1){
                String nome, dataNascimento;
                System.out.println("Digite o nome:");
                nome=scanner.nextLine();
                nome=scanner.nextLine();
                System.out.println("Digite data de nascimento:");
                dataNascimento=scanner.nextLine();
                Cliente c = new Cliente(nome,dataNascimento);
                ContaDAO dao=new ContaDAO();
                dao.inserir_cliente(c);
            }else if(valor==2){
                double saldo;
                int numero,cliente;
                double limite;
                System.out.println("Digite o saldo:");
                saldo=scanner.nextDouble();
                System.out.println("Digite o número da conta:");
                numero=scanner.nextInt();
                System.out.println("Digite o ID do cliente:");
                cliente=scanner.nextInt();
                System.out.println("Digite o limite da conta:");
                limite=scanner.nextDouble();
                ContaCorrente conta=new ContaCorrente(saldo, numero, cliente, limite);
                ContaDAO dao=new ContaDAO();
                dao.inserir_conta_corrente(conta);
            }else if(valor==3){
                double saldo;
                int numero,cliente;
                String dataAniversario;
                System.out.println("Digite o saldo:");
                saldo=scanner.nextDouble();
                System.out.println("Digite o número da conta:");
                numero=scanner.nextInt();
                System.out.println("Digite o ID do cliente:");
                cliente=scanner.nextInt();
                System.out.println("Digite o limite da conta:");
                dataAniversario=scanner.nextLine();
                dataAniversario=scanner.nextLine();
                ContaPoupanca conta=new ContaPoupanca(saldo, numero, cliente, dataAniversario);
                ContaDAO dao=new ContaDAO();
                dao.inserir_conta_poupanca(conta);
            }else if(valor==4){
                int numero;
                double valo;
                System.out.println("Digite o número da conta:");
                numero=scanner.nextInt();
                System.out.println("Digite o valor do saque:");
                valo=scanner.nextDouble();
                ContaDAO dao=new ContaDAO();
                dao.sacar(numero, valo);
            }else if(valor==5){
                int numero;
                double valo;
                System.out.println("Digite o número da conta:");
                numero=scanner.nextInt();
                System.out.println("Digite o valor do saque:");
                valo=scanner.nextDouble();
                ContaDAO dao=new ContaDAO();
                dao.depositar(numero, valo);
            }else if(valor==6){
                int numero;
                System.out.println("Digite o número da conta:");
                numero=scanner.nextInt();
                ContaDAO dao=new ContaDAO();
                System.out.println("Saldo: "+dao.getSaldo(numero));
            }else if(valor==7){
                String saida="\n\nCONTAS POUPANÇAS:\n\n";
                ContaDAO dao= new ContaDAO();
                List<ContaPoupanca> lista=dao.listar_poupanca();
        for(ContaPoupanca cont: lista){
            saida=saida+cont.getCliente()+" "+cont.getNumero()+" R$"+cont.getSaldo()+ " "+cont.getDataAniversario()+"\n";
        }
        saida=saida+"\n\nCONTAS CORRENTE:\n\n";
        List<ContaCorrente> lista_c=dao.listar_corrente();
        for(ContaCorrente cont_c: lista_c){
            saida=saida+cont_c.getCliente()+" "+cont_c.getNumero()+" R$"+cont_c.getSaldo()+ " "+cont_c.getLimite()+"\n";
        }
        JOptionPane.showMessageDialog(null, saida);
            }
        }
    }
}
