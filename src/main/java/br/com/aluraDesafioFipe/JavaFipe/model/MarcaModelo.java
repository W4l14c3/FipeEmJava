package br.com.aluraDesafioFipe.JavaFipe.model;

public class MarcaModelo {
    private int codigo;
    private String nome;
    private String codigoAno;
    private int ano;

    public MarcaModelo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public MarcaModelo(String codigoAno, int ano) {
        this.codigoAno = codigoAno;
        this.ano = ano;
    }

    public String getCodigoAno() {
        return codigoAno;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Cod: " + codigo + " Descrição: " + nome;
    }


}
