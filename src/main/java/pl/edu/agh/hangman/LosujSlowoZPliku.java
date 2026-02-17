package pl.edu.agh.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LosujSlowoZPliku implements LosujSlowo {
    private final String path;
    private final int minDlugoscSlowa;
    private final int maxDlugoscSlowa;

    public LosujSlowoZPliku(String path, int minDlugoscSlowa, int maxDlugoscSlowa) {
        this.path = path;
        this.minDlugoscSlowa = minDlugoscSlowa;
        this.maxDlugoscSlowa = maxDlugoscSlowa;
    }

    @Override
    public String losujSlowo() throws IOException {
        List<String> slowa;
        Random random = new Random();

        slowa = Files.readAllLines(Path.of(path));

        slowa.replaceAll(s -> s
                .replace('\u00A0', ' ')
                .trim());

        slowa.replaceAll(s -> s
                .toUpperCase(Locale.forLanguageTag("pl")));

            slowa.removeIf(String::isBlank);

        if (minDlugoscSlowa > 0 && maxDlugoscSlowa > 0) {
            slowa.removeIf(s -> s.length() < minDlugoscSlowa || s.length() > maxDlugoscSlowa);
        }

        if (slowa.isEmpty()) {
            throw new IllegalStateException("Brak słów w pliku!");

        } else {
            return slowa.get(random.nextInt(slowa.size()));
        }
    }
}
