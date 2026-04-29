package org.example;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static char userSymbol, computerSymbol;
    static String currentPlayer;
    static char[][] board = new char[3][3];
    static boolean gameOver = false;

    // UC1 - UC7 Utility Methods (Simplified for brevity)
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = '-';
        }
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC8: The Turn-Based Game Loop
    public static void main(String[] args) {
        initializeBoard();
        
        // Toss logic from UC2
        userSymbol = 'X'; 
        computerSymbol = 'O';
        currentPlayer = (random.nextInt(2) == 0) ? "User" : "Computer";
        
        System.out.println("Game Start! First Turn: " + currentPlayer);

        while (!gameOver) {
            printBoard();
            if (currentPlayer.equals("User")) {
                userTurn();
                currentPlayer = "Computer"; // Switch turn
            } else {
                computerTurn();
                currentPlayer = "User"; // Switch turn
            }

            // Placeholder for UC9/UC10 (Win/Draw checks)
            // If win or draw detected, gameOver = true;
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            }
        }
    }

    public static void userTurn() {
        System.out.print("\nUser's turn (1-9): ");
        int slot = scanner.nextInt();
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        if (isValidMove(row, col)) {
            board[row][col] = userSymbol;
        } else {
            System.out.println("Invalid move! Try again.");
            userTurn(); // Repeat until valid
        }
    }

    public static void computerTurn() {
        System.out.println("\nComputer is moving...");
        while (true) {
            int slot = random.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;
            if (isValidMove(row, col)) {
                board[row][col] = computerSymbol;
                break;
            }
        }
    }

    public static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) if (cell == '-') return false;
        }
        return true;
    }
}