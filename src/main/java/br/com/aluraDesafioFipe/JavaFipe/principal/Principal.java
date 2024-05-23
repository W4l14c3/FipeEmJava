package br.com.aluraDesafioFipe.JavaFipe.principal;

import br.com.aluraDesafioFipe.JavaFipe.model.DadosMM;
import br.com.aluraDesafioFipe.JavaFipe.model.MarcaModelo;
import br.com.aluraDesafioFipe.JavaFipe.model.Modelos;
import br.com.aluraDesafioFipe.JavaFipe.service.ConsumindoApi;
import br.com.aluraDesafioFipe.JavaFipe.service.Conversor;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner buscar = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final ConsumindoApi consumindoApi = new ConsumindoApi();
    private final Conversor conversor = new Conversor();
    String endereco;

    public void exibeMenu(){
        System.out.println("Bem vindo ao aplicativo JavaFipe para busca de veiculos");
        System.out.println("""
                Digite o tipo de veiculo que deseja consultar:
                ***OPÇOES DISPONIVEIS***
                Carros
                Motos
                Caminhoes
                """);
        String buscaTipoVeiculo = buscar.nextLine().toLowerCase();

        if(buscaTipoVeiculo.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
            System.out.println("Certo! Buscando...\n");
        } else if(buscaTipoVeiculo.toLowerCase().contains("mo")){
            endereco = URL_BASE + "motos/marcas";
            System.out.println("Certo! Buscando...\n");
        }
        else if(buscaTipoVeiculo.toLowerCase().contains("cam")){
            endereco = URL_BASE + "caminhao/marcas";
            System.out.println("Certo! Buscando...\n");
        }
        else {
            System.out.println("Veiculo invalido!");
        }



        var json = consumindoApi.buscarDados(endereco);
        // System.out.println(json);


        var marca = conversor.obterLista(json, DadosMM.class);
        marca.stream()
                .sorted(Comparator.comparing(DadosMM::codigo))
                .map(d -> new MarcaModelo(d.codigo(), d.nome()))
                .forEach(System.out::println);

        boolean marcaExiste = false;
        Modelos modelosEncontrados;
        while (!marcaExiste){
            System.out.println("Agora digite o codigo da marca que deseja consultar: ");
            int buscandoMarca = buscar.nextInt();
            var verificandoMarca = marca.stream()
                    .filter(m -> m.codigo() == buscandoMarca)
                    .findFirst();

            if (verificandoMarca.isPresent()){
                marcaExiste = true;
                endereco = endereco + "/" + buscandoMarca + "/modelos";
                json = consumindoApi.buscarDados(endereco);
                System.out.println("Modelos: ");
                modelosEncontrados = conversor.obterDados(json, Modelos.class);
                modelosEncontrados.modelos().stream()
                        .sorted(Comparator.comparing(DadosMM::codigo))
                        .map(d -> new MarcaModelo(d.codigo(), d.nome()))
                        .forEach(System.out::println);

            }
            else {
                System.out.println("A Marca digitada não foi encontrada na lista de Marcas.");
                System.out.println("Por favor! tente novamente.:\n");
            }
        }

        System.out.println("Digite um trecho do veiculo que deseja filtrar:\n");
        String filtrarPor = buscar.next().toUpperCase();

        modelosEncontrados = conversor.obterDados(json, Modelos.class);
        modelosEncontrados.modelos().stream()
                .sorted(Comparator.comparing(DadosMM::codigo))
                .filter(m -> m.nome().contains(filtrarPor))
                .map(m -> new MarcaModelo(m.codigo(),
                m.nome()))
                .forEach(System.out::println);

        System.out.println("Digite o codigo do modelo");


    }

}


