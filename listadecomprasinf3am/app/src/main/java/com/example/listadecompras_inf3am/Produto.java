package com.example.listadecompras_inf3am;

public class Produto {
    public boolean checked;
    String nome;
    double valor;
    boolean isChecked;

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
        isChecked = false;
    }
}
