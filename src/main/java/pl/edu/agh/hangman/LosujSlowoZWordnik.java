package pl.edu.agh.hangman;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LosujSlowoZWordnik implements LosujSlowo {
    private final int minDlugoscSlowa;
    private final int maxDlugoscSlowa;
    private static final String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    private static final Pattern WORD_PATTERN = Pattern.compile("\"word\"\\s*:\\s*\"([^\"]+)\"");

    private final HttpClient client = HttpClient.newHttpClient();

    public LosujSlowoZWordnik(int minDlugoscSlowa, int maxDlugoscSlowa) {
        if (minDlugoscSlowa <= 0 || maxDlugoscSlowa <= 0) {
            throw new IllegalArgumentException("Długości muszą być > 0");
        }
        if (minDlugoscSlowa > maxDlugoscSlowa) {
            throw new IllegalArgumentException("minDlugoscSlowa nie może być większe niż maxDlugoscSlowa");
        }
        this.minDlugoscSlowa = minDlugoscSlowa;
        this.maxDlugoscSlowa = maxDlugoscSlowa;
    }

    @Override
    public String losujSlowo() throws IOException, InterruptedException {

        String url = "https://api.wordnik.com/v4/words.json/randomWords"
                + "?hasDictionaryDef=true"
                + "&minCorpusCount=0"
                + "&minLength=" + minDlugoscSlowa
                + "&maxLength=" + maxDlugoscSlowa
                + "&limit=1"
                + "&api_key=" + API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IOException("Wordnik HTTP " + response.statusCode() + ": " + response.body());
        }

        String body = response.body();

        Matcher m = WORD_PATTERN.matcher(body);
        if (!m.find()) {
            throw new IOException("Nie udało się znaleźć pola \"word\" " +
                    "o zadanych parametrzach długości (" + minDlugoscSlowa + ", " + maxDlugoscSlowa + ") " +
                    "w odpowiedzi: " + body);
        }

        return m.group(1).toUpperCase();
    }
}
