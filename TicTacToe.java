package org.example;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static char userSymbol;
    static char computerSymbol;
    static String currentPlayer;
    static char[][] board = new char[3][3];

    // UC1, UC2, UC6 - Utility Methods
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = '-';
        }
    }

    public static void printBoard() {
        System.out.println("\nTic-Tac-Toe Board:");
        for (char[] row : board) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC4 & UC5: Reuse logic for validation
    public static int[] convertSlotToIndex(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC7: Computer Makes a Random Move
    public static void computerMove() {
        System.out.println("\nComputer is making a move...");
        int row, col;
        while (true) {
            int slot = random.nextInt(9) + 1; // Generate 1-9
            int[] position = convertSlotToIndex(slot);
            row = position[0];
            col = position[1];

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer placed '" + computerSymbol + "' at slot " + slot);
                break;
            }
        }
    }

    public static void main(String[] args) {
        initializeBoard();
        
        // Mocking UC2 for demonstration
        userSymbol = 'X';
        computerSymbol = 'O';
        
        System.out.println("Initial Board:");
        printBoard();

        // Simulate Computer Turn (UC7)
        computerMove();
        
        printBoard();
    }
}