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

    private String plikPath = "src/main/resources/slowa.txt";

    private int whichCase = 1;
    private int whichTableAnimation = 1;

    private int mindlugoscSlowa = 1;
    private int maxdlugoscSlowa = 15;

    public LosujSlowo getCase() {
        switch (whichCase) {
            case 2 -> {
                return new LosujSlowoZWordnik(mindlugoscSlowa, maxdlugoscSlowa);
            }
            default -> {
                return new LosujSlowoZPliku(plikPath, mindlugoscSlowa, maxdlugoscSlowa);
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

    public void setMinDlugoscSlowa(int nowaMinDlugosc) {
         this.mindlugoscSlowa = nowaMinDlugosc;
    }

    public void setMaxdlugoscSlowa(int nowaMaxDlugosc) {
        this.mindlugoscSlowa = nowaMaxDlugosc;
    }


    public void setWhichCase(int whichCase) {
        this.whichCase = whichCase;
    }

    public void setWhichTableAnimation(int whichTableAnimation) {
        this.whichTableAnimation = whichTableAnimation;
    }

    public void setPlikPath(String path) {
        this.plikPath = path;
    }

}
