package org.example;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);
    static char userSymbol;
    static char computerSymbol;
    static String currentPlayer;

    // UC1: Initialize and Print board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = '-';
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("\nTic-Tac-Toe Board:");
        for (char[] row : board) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    // UC2: Toss and assign symbols
    public static void tossAndAssign() {
        Random rand = new Random();
        int toss = rand.nextInt(2);
        userSymbol = (toss == 0) ? 'X' : 'O';
        computerSymbol = (toss == 0) ? 'O' : 'X';
        currentPlayer = (toss == 0) ? "User" : "Computer";
        System.out.println("\nFirst Turn: " + currentPlayer + " (" + (currentPlayer.equals("User") ? userSymbol : computerSymbol) + ")");
    }

    // UC3, 4, 5: Input, Convert, and Validate
    public static int getUserInput() {
        System.out.print("\nEnter a slot number (1-9): ");
        return scanner.nextInt();
    }

    public static int[] convertSlotToIndex(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC6: Place Move on Board
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        tossAndAssign();
        printBoard(board);

        // Logic for UC3 - UC6
        int row, col;
        while (true) {
            int slot = getUserInput();
            int[] position = convertSlotToIndex(slot);
            row = position[0];
            col = position[1];

            if (isValidMove(board, row, col)) {
                char symbol = currentPlayer.equals("User") ? userSymbol : computerSymbol;
                placeMove(board, row, col, symbol); // UC6 Execution
                System.out.println("Move placed successfully!");
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard(board); // Show updated state
    }
}