package com.example;

public abstract class Conta{
    private double saldo;
    private int numero;
    private int Cliente;
    protected Conta(double saldo, int numero, int cliente) {
        this.saldo = saldo;
        this.numero = numero;
        Cliente = cliente;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCliente() {
        return Cliente;
    }
    public void setCliente(int cliente) {
        Cliente = cliente;
    }
}
