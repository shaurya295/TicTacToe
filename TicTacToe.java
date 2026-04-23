package org.example;

import java.util.Random;

public class TicTacToe {

    // Initialize board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2: Toss logic
    public static void tossAndAssign() {
        Random rand = new Random();

        int toss = rand.nextInt(2); // 0 or 1

        char userSymbol;
        char computerSymbol;
        String currentPlayer;

        if (toss == 0) {
            userSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "User";
        } else {
            userSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        System.out.println("Toss Result:");
        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        initializeBoard(board);
        printBoard(board);

        // UC2 Execution
        tossAndAssign();
    }
}