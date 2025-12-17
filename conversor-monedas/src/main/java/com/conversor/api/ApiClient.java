package com.conversor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.conversor.modelo.RespuestaTasaCambio;
import com.conversor.servicio.ConversionException;
import com.google.gson.Gson;

public class ApiClient implements ClienteTasas {
    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    
    
    @Override
    public RespuestaTasaCambio obtenerTasas(String codigoBase) {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("La variable de entorno EXCHANGE_API_KEY no está configurada");
        }
        String url = BASE_URL + API_KEY + "/latest/" + codigoBase;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), RespuestaTasaCambio.class);
        } catch (IOException | InterruptedException e) {
            throw new ConversionException("Error al comunicarse con la API", e);
        }
    }

}
