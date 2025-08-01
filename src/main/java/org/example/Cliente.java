package org.example;

public class Cliente {
    public int id;
    public String nome;
    public String loja;

    public Cliente(int id, String nome, String loja){
        this.id = id;
        this.nome = nome;
        this.loja = loja;
    }

    public Cliente(int id, String nome){
        this.id = id;
        this.nome = nome;
        this.loja = null;
    }

    public void exibirInfos(){
        System.out.println("Nome: " + nome + ", Loja: " + loja);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
