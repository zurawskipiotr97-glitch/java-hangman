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

    private final String plikPath = "src/main/resources/slowa.txt";
    private final String wordnikPath= "https://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&minCorpusCount=0&minLength=5&maxLength=15&limit=1&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    private int whichCase = 1;
    private int whichTableAnimation = 1;

    private int dlugoscSlowa = 15;

    public LosujSlowo getCase() {
        switch (whichCase) {
            case 2 -> {
                return new LosujSlowoZWordnik(wordnikPath, dlugoscSlowa);
            }
            default -> {
                return new LosujSlowoZPliku(plikPath, dlugoscSlowa);
            }
        }
    }

    public String[] getTable() {
        switch (whichTableAnimation) {
            case 2 -> {
                return Hangman.HANGMANPICS;
            }
            default -> {
                return Hangman.HANGMANPICS;
            }
        }
    }

    public void setDlugoscSlowa(int nowaDlugosc) {
         this.dlugoscSlowa = nowaDlugosc;
    }

    public void setWhichCase(int whichCase) {
        this.whichCase = whichCase;
    }

    public void setWhichTableAnimation(int whichTableAnimation) {
        this.whichTableAnimation = whichTableAnimation;
    }

}
