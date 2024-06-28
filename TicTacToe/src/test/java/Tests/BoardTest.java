package Tests;

import org.example.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsCellEmpty_Positive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace_Positive() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertEquals('X', board.cells[1][1]);
    }

    @Test
    public void testPlace_Negative() {
        Board board = new Board();
        board.place(1, 1, 'X');
        board.place(1, 1, 'O');
        assertEquals('X', board.cells[1][1]);
    }

    @Test
    public void testIsFull_Positive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFull_Negative() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void testClear_Positive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClear_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(1, 1)); // Ensure other cells are also empty
    }

    @Test
    public void testPrint_Positive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    public void testPrint_Negative() {
        Board board = new Board();
        assertDoesNotThrow(() -> board.print()); // Ensure it does not throw even if the board is empty
    }

    @Test
    public void testPlaceWithInvalidCoordinates_Low() {
        Board board = new Board();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.place(-1, 0, 'X');
        });
        assertEquals("Coordinates must be between 0 and 2", exception.getMessage());
    }

    @Test
    public void testPlaceWithInvalidCoordinates_High() {
        Board board = new Board();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.place(0, 3, 'X');
        });
        assertEquals("Coordinates must be between 0 and 2", exception.getMessage());
    }
}
