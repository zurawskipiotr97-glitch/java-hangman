package pl.edu.agh.hangman;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LosujSlowoZWordnik implements LosujSlowo {
    private final int maxdlugoscSlowa;
    private final int mindlugoscSlowa;
    private static final String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    public LosujSlowoZWordnik(int minDlugoscSlowa, int maxDlugoscSlowa) {
        this.mindlugoscSlowa = minDlugoscSlowa;
        this.maxdlugoscSlowa = maxDlugoscSlowa;
    }

    @Override
    public String losujSlowo() throws IOException, InterruptedException {

            String url = "https://api.wordnik.com/v4/words.json/randomWords"
                    + "?hasDictionaryDef=true"
                    + "&minCorpusCount=0"
                    + "&minLength=" + mindlugoscSlowa
                    + "&maxLength=" + maxdlugoscSlowa
                    + "&limit=1"
                    + "&api_key=" + API_KEY;

        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }

        String body = response.body();

        return body.split("\"word\":\"")[1].split("\"")[0];
        }
    }


