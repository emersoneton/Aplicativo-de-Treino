package com.example.apptreino.modelo;

public class professor {

    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String nutricionista;
    private String treinador;
    private String tipo;
    private static String tipos = "0";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getNutricionista() {
        return nutricionista;
    }

    public static String getTipos() {
        return tipos;
    }

    public void professor(){
        tipos = tipo;
    }

    public void professor2(){
        tipos = "0";
    }

    public static void setTipos(String tipos) {
        professor.tipos = tipos;
    }

    public void setNutricionista(String nutricionista) {
        this.nutricionista = nutricionista;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
