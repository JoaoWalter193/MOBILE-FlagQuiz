package com.example.flagquiz;

public class NomeUsuario {
    private static NomeUsuario instance;
    private String dadoDaActivity1;

    private NomeUsuario() {}

    public static NomeUsuario getInstance() {
        if (instance == null) {
            instance = new NomeUsuario();
        }
        return instance;
    }

    public void setDado(String dado) {
        this.dadoDaActivity1 = dado;
    }

    public String getDado() {
        return dadoDaActivity1;
    }
}