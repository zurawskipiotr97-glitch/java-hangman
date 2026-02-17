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
    private String ownPath;

    private int whichCase = 0;
    private int whichTableAnimation = 1;

    private int mindlugoscSlowa = 1;
    private int maxdlugoscSlowa = 15;

    public LosujSlowo getCase() {
        switch (whichCase) {
            case 1 -> {
                return new LosujSlowoZPliku(ownPath, mindlugoscSlowa, maxdlugoscSlowa);
            }
            case 2 -> {
                return new LosujSlowoZWordnik(mindlugoscSlowa, maxdlugoscSlowa);
            }
            default -> {
                return new LosujSlowoZPliku(plikPath, mindlugoscSlowa, maxdlugoscSlowa);
            }
        }
    }

    public String getCaseName() {
        switch (whichCase) {
            case 1 -> {
                return "Own File";            }
            case 2 -> {
                return "Wordnik";            }
            default -> {
                return "Default File";
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

    public String getTableName() {
        switch (whichTableAnimation) {
            case 2 -> {
                return "HANGMANPICS-New";
            }
            default -> {
                return "HANGMANPICS-Default";
            }
        }
    }

    public void setMinDlugoscSlowa(int nowaMinDlugosc) {
         this.mindlugoscSlowa = nowaMinDlugosc;
    }

    public void setMaxdlugoscSlowa(int nowaMaxDlugosc) {
        this.maxdlugoscSlowa = nowaMaxDlugosc;
    }


    public void setWhichRandomWordCase(int whichCase) {
        this.whichCase = whichCase;
    }

    public void setWhichTableAnimation(int whichTableAnimation) {
        this.whichTableAnimation = whichTableAnimation;
    }

    public void setPlikPath(String path) {
        this.plikPath = path;
    }

    public void setOwnPath(String path) {
        this.ownPath = path;
    }

    public int getMindlugoscSlowa() {
        return mindlugoscSlowa;
    }

    public int getMaxdlugoscSlowa() {
        return maxdlugoscSlowa;
    }
}
