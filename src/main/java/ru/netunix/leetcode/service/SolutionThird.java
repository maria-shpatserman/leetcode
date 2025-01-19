package ru.netunix.leetcode.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionThird {
    public static void main(String[] args) {
        SolutionThird s = new SolutionThird();

        char[][] testBoard = {{'3', '1', '9', '7', '4', '8', '6', '5', '2'},
                {'7', '4', '3', '6', '5', '2', '1', '8', '9'},
                {'6', '2', '5', '1', '3', '9', '8', '7', '4'},
                {'5', '3', '7', '9', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                {'9', '7', '1', '8', '6', '3', '4', '2', '5'},
                {'8', '5', '2', '4', '9', '1', '7', '3', '6'},
                {'4', '8', '6', '2', '7', '5', '9', '1', '3'}};
//        boolean validSudoku = s.isValidSudoku(testBoard);
//        System.out.println("validSudoku =" + validSudoku);


        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
       /* char[][] board ={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};*/

//        boolean validSudoku = s.isValidSudoku(board);
//        System.out.println("RESULT = " + validSudoku);
        System.out.println("INCOMING = " + Arrays.deepToString(board));
//        s.solveSudoku(board);

//        int[] nums = {20, 1, 0, 10, -2, 2, 7, 3, 4, 1, 5, 2};
        int[] nums = {100000, 3, 4000, 2, 15, 1, 99999};
        System.out.println("INCOMING NUMS = " + Arrays.toString(nums));
        int result = s.firstMissingPositive(nums);
        System.out.println("RESULT FIRST MISSING POSITIVE = " + result);
        String s1 = "aa";
        String p1 = "a*B";
        boolean match = s.isMatch(s1, p1);
        System.out.println("RESULT isMatch ---->>>>> " + match);

        int divided = s.divide(-2147483648, -1);
        System.out.println("RESULT divided ---->>>>> " + divided);

//        System.out.println("RESULT of MULTIPLY ->>>>>> " + s.multiply("3866762897776739956", "15975363164662"));
        System.out.println("RESULT of MULTIPLY ->>>>>> " + s.multiply("123456789", "987654321"));
//        System.out.println("RESULT of MULTIPLY ->>>>>> " + s.multiply("123", "98"));
//121932631112635269 - expected
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
            if (board[i][columnNumber] != '.' && !set.add(board[i][columnNumber])) return false;
        }
        return result;
    }

    public boolean isValidSquare(int lineNumber, int columnNumber, char[][] board) {
        boolean result = true;
        Set<Character> set = new HashSet<>();
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                System.out.println(String.format("board[%d][%d] = %c", i, j, board[i][j]));
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }

        }
        return result;
    }


    public void solveSudoku(char[][] board) {
        List<PairIndex> listNotFulFilledSquares = getSquaresNotFulfilled(board);
        int notFilledCellsCountPrevious = 9 * 9;
        int notFilledCellsCount = getNotFilledCellsCount(board);
        while (listNotFulFilledSquares.size() > 0 && notFilledCellsCount < notFilledCellsCountPrevious) {
            for (int i = 0; i < listNotFulFilledSquares.size(); i++) {
                board = solveSquare(listNotFulFilledSquares.get(i).i, listNotFulFilledSquares.get(i).j, board);

            }

            listNotFulFilledSquares = getSquaresNotFulfilled(board);
            notFilledCellsCountPrevious = notFilledCellsCount;
            notFilledCellsCount = getNotFilledCellsCount(board);

        }
        if (notFilledCellsCount > 0) {
            List<PairIndex> listNotFulFilledCells = getNotFilledCells(board);
            char[][] boardSolved = solveWithRecursion(0, listNotFulFilledCells.size() - 1, listNotFulFilledCells, board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = boardSolved[i][j];

                }
            }
        }


        System.out.println(Arrays.deepToString(board));

    }

    public char[][] solveWithRecursion(int indexCurrent, int indexLast, List<PairIndex> listNotFulFilledCells, char[][] board) {
        PairIndex pairIndex = listNotFulFilledCells.get(indexCurrent);
        List<Character> notFulFilledChars = getNotFulFilledCharsInLine(board, pairIndex.i);
        PairIndex squareByCell = getSquareByCell(pairIndex);
        List<Character> fullFilledCharsForSquare = getFullFilledCharsForSquare(squareByCell.i, squareByCell.j, board);
        notFulFilledChars.removeAll(fullFilledCharsForSquare);
        for (int i = 0; i < notFulFilledChars.size(); i++) {
            Character tempChar = notFulFilledChars.get(i);
            if (isCharCanBeFilled(pairIndex, tempChar, board)) {
                if (indexCurrent == indexLast) {
                    System.out.println("LAST STEP HOORAY!");
                    board[pairIndex.i][pairIndex.j] = tempChar;
                    return board;
                } else {
                    char[][] tempBoard = copyOfBoard(board);
                    tempBoard[pairIndex.i][pairIndex.j] = notFulFilledChars.get(i);
                    tempBoard = solveWithRecursion(indexCurrent + 1, indexLast, listNotFulFilledCells, tempBoard);
                    if (tempBoard != null) return tempBoard;
                }
            }
        }
        return null;
    }

    public PairIndex getSquareByCell(PairIndex cellIndex) {
        PairIndex result = new PairIndex(0, 0);
        result.i = switch (cellIndex.i) {
            case 0, 1, 2 -> 0;
            case 3, 4, 5 -> 3;
            default -> 6;

        };
        result.j = switch (cellIndex.j) {
            case 0, 1, 2 -> 0;
            case 3, 4, 5 -> 3;
            default -> 6;

        };
        return result;

    }

    public List<Character> getNotFulFilledCharsInLine(char[][] board, int lineNumber) {
        List<Character> notFulFilledChars = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        List<Character> fulFilledChars = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[lineNumber][i] != '.') {
                fulFilledChars.add(board[lineNumber][i]);
            }

        }
        notFulFilledChars.removeAll(fulFilledChars);

        return notFulFilledChars;
    }


    private int getNotFilledCellsCount(char[][] board) {
        int result = 0;
        for (int i = 0; i < 9; i = i + 1) {
            for (int j = 0; j < 9; j = j + 1) {
                if (board[i][j] == '.') {
                    result = result + 1;
                }
            }
        }
        return result;
    }

    public List<PairIndex> getNotFilledCells(char[][] board) {
        List<PairIndex> result = new ArrayList<>();
        for (int i = 0; i < 9; i = i + 1) {
            for (int j = 0; j < 9; j = j + 1) {
                if (board[i][j] == '.') {
                    result.add(new PairIndex(i, j));
                }
            }
        }
        return result;
    }

    public List<PairIndex> getSquaresNotFulfilled(char[][] board) {
        List<PairIndex> result = new ArrayList<>();
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isSquareFulfilled(i, j, board)) {
                    result.add(new PairIndex(i, j));
                }
            }
        }

        return result;
    }

    class PairIndex {
        int i;
        int j;

        PairIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public boolean isSquareFulfilled(int lineNumber, int columnNumber, char[][] board) {
        boolean result = true;
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                if (board[i][j] == '.') return false;
            }

        }
        return result;
    }

    public char[][] solveSquare(int lineNumber, int columnNumber, char[][] board) {
        List<PairIndex> notFulFilledCells = getNotFullFilledCellsForSquare(lineNumber, columnNumber, board);
        List<Character> notFulFilledChars = getNotFullFilledCharsForSquare(lineNumber, columnNumber, board);
        if (notFulFilledChars.size() == 1) {
            int indexLine = notFulFilledCells.get(0).i;
            int indexColumn = notFulFilledCells.get(0).j;
            board[indexLine][indexColumn] = notFulFilledChars.get(0);
            return board;
        }
        for (int i = 0; i < notFulFilledChars.size(); i++) {
            Character c = notFulFilledChars.get(i);
            List<Integer> applicableIndexes = new ArrayList<>();
            for (int j = 0; j < notFulFilledCells.size(); j++) {
                if (isCharCanBeFilled(notFulFilledCells.get(j), c, board)) {
                    applicableIndexes.add(j);
                }
            }
            //if cell can be filled - set to board
            //remove pair from  notFulFilledCells
            if (applicableIndexes.size() == 1) {
                int indexLine = notFulFilledCells.get(applicableIndexes.get(0)).i;
                int indexColumn = notFulFilledCells.get(applicableIndexes.get(0)).j;
                board[indexLine][indexColumn] = c;
                notFulFilledCells.remove(applicableIndexes.get(0));

            }

        }


        return board;
    }

    public List<PairIndex> getNotFullFilledCellsForSquare(int lineNumber, int columnNumber, char[][] board) {
        List<PairIndex> result = new ArrayList<>();
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                if (board[i][j] == '.') {
                    result.add(new PairIndex(i, j));

                }
            }
        }
        return result;
    }

    public List<Character> getNotFullFilledCharsForSquare(int lineNumber, int columnNumber, char[][] board) {
        List<Character> result = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        List<Character> fulFilledChars = new ArrayList<>();
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                if (board[i][j] != '.') {
                    fulFilledChars.add(board[i][j]);

                }
            }
        }
        result.removeAll(fulFilledChars);
        return result;
    }

    public List<Character> getFullFilledCharsForSquare(int lineNumber, int columnNumber, char[][] board) {
        List<Character> result = new ArrayList<>();
        for (int i = lineNumber; i < 3 + lineNumber; i++) {
            for (int j = columnNumber; j < 3 + columnNumber; j++) {
                if (board[i][j] != '.') {
                    result.add(board[i][j]);

                }
            }
        }
        return result;
    }

    boolean isCharCanBeFilled(PairIndex pairIndex, Character character, char[][] board) {
        boolean result = true;
        //check line
        int lineNumber = pairIndex.i;
        for (int i = 0; i < 9; i++) {
            if (board[lineNumber][i] == character) return false;

        }
        //check column
        int columnNumber = pairIndex.j;
        for (int i = 0; i < 9; i++) {
            if (board[i][columnNumber] == character) return false;

        }

        return result;
    }

    public char[][] copyOfBoard(char[][] board) {
        char[][] result = new char[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                result[i][j] = board[i][j];
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        nums = sortCycle(nums);
        System.out.println("SORTED NUMS = " + Arrays.toString(nums));

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                return result;
            } else {
                result = result + 1;
            }
        }

        return result;

    }

    public int[] sortCycle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && !isOnCorrectIndex(i, nums[i]) && isAvailableToSwap(nums[i], nums)) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;

            }
            System.out.println("INDEX [" + i + "] CURRENT NUMS = " + Arrays.toString(nums));
        }
        return nums;
    }

    public boolean isOnCorrectIndex(int indexNumber, int value) {
        if (value == (indexNumber + 1)) return true;
        return false;

    }

    public boolean isAvailableToSwap(int value, int[] nums) {
        if (value > nums.length) return false;
        if (value != nums[value - 1]) return true;
        return false;

    }

    public boolean isMatch(String s, String p) {
        boolean result = false;
        if (p.length() == 0) return false;
//        if (p.length() > s.length()) return false;
//        Pattern pattern = Pattern.compile(p);
//        Matcher m = pattern.matcher(s);
//        result= m.matches();


        return result;

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return nums.length;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if ((dividend == -2147483648) && (divisor == -1)) return 2147483647;
        if (divisor == 1) return dividend;
        if (divisor == -1) return changeSignOfNumber(dividend);
        boolean isNegativeResult = isNegativeResult(dividend, divisor);
        int negativeDividend = (dividend > 0) ? changeSignOfNumber(dividend) : dividend;
        int negativeDivisor = (divisor > 0) ? changeSignOfNumber(divisor) : divisor;
        int result = getQuotient(negativeDividend, negativeDivisor);
        if (isNegativeResult) {
            result = changeSignOfNumber(result);
        }
        return result;

    }

    int changeSignOfNumber(int number) {
        return 0 - number;
    }

    int getQuotient(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            dividend = dividend - divisor;
            result = result + 1;

        }
        return result;
    }


    boolean isNegativeResult(int dividend, int divisor) {
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) return true;
        return false;
    }

    //   return new StringBuilder(intToStr).reverse().toString();
    public String multiply(String num1, String num2) {
        String result = "";
        if(num1.equals("0") ||num2.equals("0")){
            return "0";
        }
        List<String> listTemp = new ArrayList<>();
        String reversedNum2 = new StringBuilder(num2).reverse().toString();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < reversedNum2.length(); i++) {
            String temp2 =getStringMultipliedByInt(num1, getIntFromChar(reversedNum2.substring(i, i + 1)), postfix.toString());
            listTemp.add(temp2);
            postfix.append("0");
        }
        int[][] matrix = getMatrix(listTemp);
        result = getMultipliedFromMatrix(matrix);
        return result;

    }

    public String getMultipliedFromMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        String result = "";


        int summary = 0;
        for (int j = m - 1; j >= 0; j--) {

            for (int i = 0; i < n; i++) {
                summary = summary + matrix[i][j];
            }
            int mod = summary % 10;
            result = String.valueOf(mod) + result;
            summary = summary / 10;

        }
        if(summary>0) {
            result = String.valueOf(summary) + result;
        }
        return result;

    }
    public String getStringMultipliedByInt(String num, int number,String postfix){
        String result =postfix;
        String reversedNum2 = new StringBuilder(num).reverse().toString();
        int nextTens=0;
        for (int i = 0; i < reversedNum2.length(); i++) {
            int temp = number*getIntFromChar(reversedNum2.substring(i, i + 1))+nextTens;
            int mod = (temp) % 10;
            result = String.valueOf(mod) + result;
            nextTens = (temp) / 10;
        }
        if(nextTens>0) {
            result = String.valueOf(nextTens) + result;
        }
       return result;
    }

    public int[][] getMatrix(List<String> multiplies) {

        int n = multiplies.size();
        int m = multiplies.get(multiplies.size() - 1).length();
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            String value = multiplies.get(i);
            int k = value.length() - 1;
            for (int j = m - 1; j >= 0; j--) {

                    if (k >= 0) {
                        int sf = getIntFromChar(value.substring(k, k + 1));
                        result[i][j] = sf;
                        k = k - 1;
                    } else {
                        result[i][j] = 0;
                    }
                }

            }


        return result;
    }



    int getIntFromChar(String num) {
        return switch (num) {
            case "0" -> 0;
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            default -> throw new RuntimeException("Incorrect symbol");

        };

    }
}
