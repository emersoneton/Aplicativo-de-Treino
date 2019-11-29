package com.example.apptreino.modelo;

import com.example.apptreino.Aluno;

public class aluno {

  //  private String id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;
    private static String  nomeProfessor = "0";
    private String nomedoprofessor;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static String getNomeProfessor() {
        return nomeProfessor;
    }

    public static void setNomeProfessor(String nomeProfessor) {
        aluno.nomeProfessor = nomeProfessor;
    }

    public String getNomedoprofessor() {
        return nomedoprofessor;
    }

    public void setNomedoprofessor(String nomedoprofessor) {
        this.nomedoprofessor = nomedoprofessor;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void cadprofessor(){
        nomeProfessor = nomedoprofessor;
    }
    public void limpaprofessor(){
        nomeProfessor = "0";
    }
}
