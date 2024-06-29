package org.example;


public class Main {
    public static void main(String[] args) {
        boolean isCIBuild = System.getenv("CI") != null;

        if (isCIBuild) {
            System.out.println("Running in CI mode. Skipping interactive part.");
            // Add non-interactive logic here
        } else {
            // Original interactive game logic
            TicTacToe game = new TicTacToe();
            game.start();
        }
    }
}

