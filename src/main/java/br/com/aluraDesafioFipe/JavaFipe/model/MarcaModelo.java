package br.com.aluraDesafioFipe.JavaFipe.model;

public class MarcaModelo {
    private int codigo;
    private String nome;

    public MarcaModelo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cod: " + codigo + " Descrição: " + nome;
    }
}
