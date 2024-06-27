package org.example;


import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
        while (!board.isFull() && !hasWinner()) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            int x = getUserInput("row (0-2): ");
            int y = getUserInput("column (0-2): ");
            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    return;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty!");
            }
        }
        board.print();
        if (board.isFull() && !hasWinner()) {
            System.out.println("The game is a draw!");
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        // Check rows, columns, and diagonals for a winner
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[i][0] == currentPlayer.getMarker() &&
                    board.cells[i][1] == currentPlayer.getMarker() &&
                    board.cells[i][2] == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[0][i] == currentPlayer.getMarker() &&
                    board.cells[1][i] == currentPlayer.getMarker() &&
                    board.cells[2][i] == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if ((board.cells[0][0] == currentPlayer.getMarker() &&
                board.cells[1][1] == currentPlayer.getMarker() &&
                board.cells[2][2] == currentPlayer.getMarker()) ||
                (board.cells[0][2] == currentPlayer.getMarker() &&
                        board.cells[1][1] == currentPlayer.getMarker() &&
                        board.cells[2][0] == currentPlayer.getMarker())) {
            return true;
        }
        return false;
    }

    private int getUserInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}

