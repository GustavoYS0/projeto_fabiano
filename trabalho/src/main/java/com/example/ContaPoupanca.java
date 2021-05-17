package com.example;

public class ContaPoupanca extends Conta{
    private String dataAniversario;

    public ContaPoupanca(double saldo, int numero, int cliente, String dataAniversario) {
        super(saldo, numero, cliente);
        this.dataAniversario = dataAniversario;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
}
