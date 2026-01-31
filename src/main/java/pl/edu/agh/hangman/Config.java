package pl.edu.agh.hangman;

public class Config {
    private static Config instance;

    private Config() {}

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    String plikPath = "src/main/resources/slowa.txt";
    String wordnikPath= "https://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";
    int sourceTypeCase = 0;
    int dlugoscSlowa = 5;

     public LosujSlowo getCase() {
        return new LosujSlowoZPliku(plikPath, dlugoscSlowa);
//        return new LosujSlowoZWordnik(wordnikPath, dlugoscSlowa);
    }
}
