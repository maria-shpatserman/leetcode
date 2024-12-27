package ru.netunix.leetcode.service;

import java.util.HashSet;
import java.util.Set;

public class SolutionThird {
    public static void main(String[] args) {
        SolutionThird s = new SolutionThird();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = s.isValidSudoku(board);
        System.out.println("RESULT = " + validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        boolean result = true;

        for (int i = 0; i < 9; i++) {
            if (!isValidLine(i, board)) {
                result = false;
                return result;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(i, board)) {
                result = false;
                return result;
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidSquare(i, j, board)) {
                    result = false;
                    return result;
                }
            }

        }
        return result;


    }

    public boolean isValidLine(int lineNumber, char[][] board) {
        boolean result = true;
        System.out.println(String.format("lineNumber = %d", lineNumber));
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            System.out.println(String.format("board[%d][%d] = %c", lineNumber, i, board[lineNumber][i]));
            if (board[lineNumber][i] != '.' && !set.add(board[lineNumber][i])) return false;
        }


        return result;
    }

    public boolean isValidColumn(int columnNumber, char[][] board) {
        boolean result = true;
        System.out.println(String.format("columnNumber = %d", columnNumber));
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            System.out.println(String.format("board[%d][%d] = %c", i, columnNumber, board[i][columnNumber]));
            if (board[i][columnNumber] != '.' &&!set.add(board[i][columnNumber])) return false;
        }
        return result;
    }

    public boolean isValidSquare(int lineNumber, int columnNumber, char[][] board) {
        boolean result = true;
        Set<Character> set = new HashSet<>();
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                System.out.println(String.format("board[%d][%d] = %c", i, j, board[i][j]));
                if (board[i][j] != '.' &&!set.add(board[i][j])) return false;
            }

        }
        return result;
    }
}
