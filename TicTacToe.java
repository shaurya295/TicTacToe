package org.example;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    // Game state variables
    static char userSymbol;
    static char computerSymbol;
    static String currentPlayer;

    // UC1: Initialize board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC1: Print board
    public static void printBoard(char[][] board) {
        System.out.println("\nTic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2: Toss and assign symbols
    public static void tossAndAssign() {
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            userSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "User";
        } else {
            userSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        System.out.println("\n--- Toss Result ---");
        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);
    }

    // UC3: Get user input
    public static int getUserInput() {
        System.out.print("\nEnter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    // UC4: Convert slot to row & column
    public static int[] convertSlotToIndex(int slot) {
        int index = slot - 1;   // Convert to 0-based
        int row = index / 3;
        int col = index % 3;

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1
        initializeBoard(board);
        printBoard(board);

        // UC2
        tossAndAssign();

        // UC3
        int userSlot = getUserInput();

        // UC4
        int[] position = convertSlotToIndex(userSlot);

        System.out.println("\nConverted Position:");
        System.out.println("Row: " + position[0]);
        System.out.println("Column: " + position[1]);
    }
}