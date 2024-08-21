package br.com.aluraDesafioFipe.JavaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAno(@JsonAlias("codigo") String codigoAno, @JsonAlias("nome") int ano) {}
