package pl.edu.agh.hangman;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckLettersTest {

    @Test
    public void testCheckLetters() {
        CheckLetters koń = new CheckLetters("koń");
//        Assert.assertTrue(char[] = {k, o, ń},)
        koń.containsLetter('k');
        assertEquals(1, koń.getGameStatus());

        koń.containsLetter('2');
        assertEquals(2, koń.getGameStatus());


        System.out.println(koń.getShowingWord());

    }
}
