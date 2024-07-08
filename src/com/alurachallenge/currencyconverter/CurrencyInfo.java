package com.alurachallenge.currencyconverter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyInfo {
    public Currency currencyInfo (String currency){

            String apiKey = "05e06b7fad3e07715adc6933";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+currency))
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .setPrettyPrinting()
                        .create();
                return gson.fromJson(response.body(),Currency.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Ingrese un valor válido.");
            }

    }




}
