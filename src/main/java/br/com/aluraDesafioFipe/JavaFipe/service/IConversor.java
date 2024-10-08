package br.com.aluraDesafioFipe.JavaFipe.service;

import java.util.List;

public interface IConversor {
    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
