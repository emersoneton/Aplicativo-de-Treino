package com.example.apptreino.modelo;

public class treinos_e_dietas {

    private String treinos;
    private String dietas;
    private String nomebusca;

    public String getTreinos() {
        return treinos;
    }

    public void setTreinos(String treinos) {
        this.treinos = treinos;
    }

    public String getDietas() {
        return dietas;
    }

    public void setDietas(String dietas) {
        this.dietas = dietas;
    }

    public String getNomebusca() {
        return nomebusca;
    }

    public void setNomebusca(String nomebusca) {
        this.nomebusca = nomebusca;
    }

    @Override
    public String toString() {
        return treinos;
    }
}
