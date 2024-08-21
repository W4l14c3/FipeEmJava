package br.com.aluraDesafioFipe.JavaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

public record DadosVeiculo(@JsonAlias("TipoVeiculo")int  tipoVeiculo,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") String anoModelo,
                           @JsonAlias("Combustivel") String combustivel,
                           @JsonAlias("CodigoFipe") String codigoFipe,
                           @JsonAlias("MesReferencia") String mesReferencia,
                           @JsonAlias("SiglaCombustivel") String siglaCombustivel) {
    @Override
    public String toString() {
        return """
                Tipo Veiculo: %d
                Valor: %s
                Marca: %s
                Modelo: %s
                AnoModelo %s
                Combustivel %s
                CodigoFipe %s
                MesReferenncia %s
                SiglaCombustivel %s
                """.formatted(tipoVeiculo, valor, marca, modelo, anoModelo, combustivel, codigoFipe, mesReferencia, siglaCombustivel);
    }
}