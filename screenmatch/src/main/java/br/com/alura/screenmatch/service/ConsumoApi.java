package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco){

        // Criação de um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criação de uma requisição HTTP com o endereço fornecido
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        // Declaração de uma variável para armazenar a resposta da requisição
        HttpResponse<String> response = null;
        try {
            // Envio da requisição e obtenção da resposta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Obtém o corpo da resposta (geralmente um JSON)
        String json = response.body();

        // Retorna o conteúdo da resposta (JSON)
        return json;
    }

}
