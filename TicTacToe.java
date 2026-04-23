package org.example;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

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

    // UC2: Toss
    public static void tossAndAssign() {
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            System.out.println("User plays first with X");
        } else {
            System.out.println("Computer plays first with X");
        }
    }

    // UC3: Get user slot input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        initializeBoard(board);
        printBoard(board);
        tossAndAssign();

        // UC3 Execution
        int userSlot = getUserInput();
        System.out.println("You selected slot: " + userSlot);
    }
}