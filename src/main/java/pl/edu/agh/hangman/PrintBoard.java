package pl.edu.agh.hangman;

public class PrintBoard {
    int stanGry;
    char[]  openWord;
    String[] tablica;
    char[] showWord;
    int wynik;

    public PrintBoard(String[] tablica, char[]  openWord) {
        this.stanGry = 1;
        this.tablica = tablica;
        this.openWord = openWord;
        this.showWord = new char[openWord.length];
        this.wynik = wynik;

    }

    public void printBoard(CheckLetters gra) {
        if (tablica.length != gra.getGameStatus()) {
            System.out.println(tablica[gra.getGameStatus()]);
            showWord = changeWord(gra.getShowingWord());
            System.out.println(showWord);
        } else {
            switch(wynik) {
                case 0 -> {
                    {
                        System.out.println("LOOSER");
                    }
                    return;
                }

                case 1 -> {
                    System.out.println("WINNER");
                    return;
                }
            }
        }







    }

    public char [] changeWord(char[] showingWord) {
        wynik = 1;
        for (int i = 0; i < showingWord.length; i++) {
            if (showingWord[i] == '\u0000' ) {
                showWord[i] = '_';
                wynik = 0;
            } else {
                showWord[i] = showingWord[i];
            }
        }
        return showWord;
    }
}
