package com.vendas.conversor.model;


@Entity
public class Usuario {
    
    private int id;

    private String nome, senha;

    public Usuario(){

    }

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public int getId(){
        return id;
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;
    }

}
