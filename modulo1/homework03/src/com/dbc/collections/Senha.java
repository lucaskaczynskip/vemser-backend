package com.dbc.collections;

class Senha {
    private int senha;
    public static int quantidadeSenhas = 0;

    public Senha(int senha) {
        this.setSenha(senha);
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return String.format("%d", this.getSenha());
    }
}