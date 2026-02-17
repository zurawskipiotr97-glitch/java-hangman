package pl.edu.agh.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LosujSlowoZPliku implements LosujSlowo {
    private String path;
    private int dlugoscSlowa;

    public LosujSlowoZPliku(String path, int dlugoscSlowa) {
        this.path = path;
        this.dlugoscSlowa = dlugoscSlowa;
    }

    @Override
    public String losujSlowo() throws IOException {
        List<String> slowa;
        Random random = new Random();

            slowa = Files.readAllLines(Path.of(path));

            for (int i = 0; i < slowa.size(); i++) {
                slowa.set(i, slowa.get(i)
                        .replace('\u00A0', ' ')
                        .trim());
            }

            for (int i = 0; i < slowa.size(); i++) {
                slowa.set(i, slowa.get(i)
                        .toUpperCase(Locale.forLanguageTag("pl")));
            }

            slowa.removeIf(String::isBlank);

        if (dlugoscSlowa != 0) {
            slowa.removeIf(s -> s.length() != dlugoscSlowa);
        }

        if (slowa.isEmpty()) {
            throw new IllegalStateException("Brak słów w pliku!");

        } else {
            return slowa.get(random.nextInt(slowa.size()));
        }
    }
}
