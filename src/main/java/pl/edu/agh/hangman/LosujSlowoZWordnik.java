package pl.edu.agh.hangman;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LosujSlowoZWordnik implements LosujSlowo {
    private String path;
    private int dlugoscSlowa;
    private static final String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    public LosujSlowoZWordnik(String path, int dlugoscSlowa) {
        this.path = path;
        this.dlugoscSlowa = dlugoscSlowa;
    }

    @Override
    public String losujSlowo() throws IOException, InterruptedException {

            String url = "https://api.wordnik.com/v4/words.json/randomWords"
                    + "?hasDictionaryDef=true"
                    + "&minCorpusCount=0"
                    + "&minLength=" + dlugoscSlowa
                    + "&maxLength=" + dlugoscSlowa
                    + "&limit=1"
                    + "&api_key=" + API_KEY;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            String word = body.split("\"word\":\"")[1].split("\"")[0];

            return word;
        }
    }


