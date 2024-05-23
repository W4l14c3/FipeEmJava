package br.com.aluraDesafioFipe.JavaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<DadosMM> modelos) {}
