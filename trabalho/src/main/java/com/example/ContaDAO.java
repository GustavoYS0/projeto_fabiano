package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO implements InterfaceConta{
    private Connection conexao;
    public ContaDAO(){
        this.conexao=new ConnectionFactory().getConnection();
    }
    @Override
    public void sacar(int num, double valor){
        String sql2="select saldo from conta where numero=?;";
        double val=0;
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql2);
            stmt.setInt(1, num);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                val=rs.getDouble("saldo");
            }
            stmt.close();
        String sql = "update conta set saldo=? where numero=?;";
        stmt = this.conexao.prepareStatement(sql);
            stmt.setDouble(1, val-valor);
            stmt.setInt(2, num);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void depositar(int num, double valor) {
        String sql2="select * from conta where numero=?;";
        double val=0;
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql2);
            stmt.setInt(1, num);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                val=rs.getDouble("saldo");
            }
            stmt.close();
        String sql = "update conta set saldo=? where numero=?;";
        stmt = this.conexao.prepareStatement(sql);
            stmt.setDouble(1, val+valor);
            stmt.setInt(2, num);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public double getSaldo(int num) {
        String sql="select * from conta where numero=?;";
        double valor=0;
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, num);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                valor=rs.getDouble("saldo");
            }
            stmt.close();
            return valor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContaPoupanca> listar_poupanca() {
        try {
            List<ContaPoupanca> contas=new ArrayList<ContaPoupanca>();
            PreparedStatement stmt = this.conexao.prepareStatement("select * from conta");
            ResultSet rs = stmt.executeQuery();
            int limite;
            while(rs.next()){
                limite=0;
                if(rs.getDouble("limite")==limite){
                    ContaPoupanca c= new ContaPoupanca(0, 0, 0, "");
                    c.setSaldo(rs.getDouble("saldo"));
                    c.setCliente(rs.getInt("cliente"));
                    c.setNumero(rs.getInt("numero"));
                    c.setDataAniversario(rs.getString("dataAniversario"));
                    contas.add(c);
                }
            }
            rs.close();
            stmt.close();

            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<ContaCorrente> listar_corrente() {
        try {
            List<ContaCorrente> contas=new ArrayList<ContaCorrente>();
            PreparedStatement stmt = this.conexao.prepareStatement("select * from conta");
            ResultSet rs = stmt.executeQuery();
            int limite;
            while(rs.next()){
                limite=0;
                if(rs.getDouble("limite")!=limite){
                    ContaCorrente c= new ContaCorrente(0, 0, 0,0);
                    c.setSaldo(rs.getDouble("saldo"));
                    c.setCliente(rs.getInt("cliente"));
                    c.setNumero(rs.getInt("numero"));
                    c.setLimite(rs.getDouble("limite"));
                    contas.add(c);
                }
            }
            rs.close();
            stmt.close();

            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserir_cliente(Cliente cliente){
        String sql = "insert into cliente (nome,dataNascimento) values (?,?);";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserir_conta_poupanca(ContaPoupanca conta){
        String sql;
        try {
            sql="insert into conta (numero,cliente,saldo,dataAniversario) values (?,?,?,?);";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, conta.getNumero());
            stmt.setInt(2, conta.getCliente());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getDataAniversario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserir_conta_corrente(ContaCorrente conta){
        String sql;
        try {
            sql="insert into conta (numero,cliente,saldo,limite) values (?,?,?,?);";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, conta.getNumero());
            stmt.setInt(2, conta.getCliente());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setDouble(4, conta.getLimite());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
