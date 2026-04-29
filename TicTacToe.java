package org.example;

public class TicTacToe {

    static char[][] board = new char[3][3];

    /**
     * UC9 checks all possible winning patterns for the given symbol.
     * Logic: 3 Rows, 3 Columns, and 2 Diagonals.
     */
    public static boolean hasWon(char symbol) {
        // Check Rows and Columns
        for (int i = 0; i < 3; i++) {
            // Row check: horizontal match
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            // Column check: vertical match
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        // Diagonal checks
        // Main diagonal: top-left to bottom-right
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        // Anti-diagonal: top-right to bottom-left
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Mocking a winning state for testing
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = 'X';

        System.out.println("Has 'X' won? " + hasWon('X')); // Should print true
        System.out.println("Has 'O' won? " + hasWon('O')); // Should print false
    }
}