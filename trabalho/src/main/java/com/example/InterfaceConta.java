package com.example;

import java.util.List;

public interface InterfaceConta {
    void sacar(int num, double valor);
    void depositar(int num, double valor);
    double getSaldo(int num);
}
