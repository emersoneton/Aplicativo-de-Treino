package com.example.apptreino.modelo;

public class login {

    private String tipo;
    private String nome;
    private static String nomedabusca = "0";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getNomedabusca() {
        return nomedabusca;
    }

    public static void setNomedabusca(String nomedabusca) {
        login.nomedabusca = nomedabusca;
    }

    public void funcao(){
        nomedabusca = nome;
    }

    public void funcao2(){
        nomedabusca = "0";
    }
    @Override
    public String toString() {
        return "login{" +
                "tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
