package com.example;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(double saldo, int numero, int cliente, double limite) {
        super(saldo, numero, cliente);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
}
