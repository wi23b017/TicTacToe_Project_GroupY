package Tests;

import org.example.TicTacToe;
import org.example.Player;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testSwitchCurrentPlayer_Positive() {
        TicTacToe game = new TicTacToe();
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testSwitchCurrentPlayer_Negative() {
        TicTacToe game = new TicTacToe();
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testHasWinner_Positive() {
        TicTacToe game = new TicTacToe();
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_Negative() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.hasWinner());
    }

    @Test
    public void testStart_Positive() {
        // Modify the test to skip interactive part
        boolean isCIBuild = System.getenv("CI") != null;

        if (isCIBuild) {
            // Simulate a non-interactive start
            TicTacToe game = new TicTacToe();
            game.getBoard().place(0, 0, 'X');
            game.getBoard().place(1, 1, 'O');
            game.getBoard().place(2, 2, 'X');
            assertDoesNotThrow(() -> game.start());
        } else {
            // Original interactive test
            TicTacToe game = new TicTacToe();
            assertDoesNotThrow(() -> game.start());
        }
    }

    @Test
    public void testStart_Negative() {
        TicTacToe game = new TicTacToe();
        game.start();
        assertFalse(game.getBoard().isFull());
    }
}

