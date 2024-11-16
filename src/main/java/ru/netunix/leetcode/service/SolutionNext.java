package ru.netunix.leetcode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SolutionNext {
    class MyType {
        MyType(Boolean isPalindrome, char[] resultStr) {
            this.isPalindrome = isPalindrome;
            this.resultStr = resultStr;
        }

        Boolean isPalindrome;
        char[] resultStr;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String ss = "aaadffghjkaaaff";
        SolutionNext s = new SolutionNext();
        String s1 = s.shortestPalindromeNext(ss);
        System.out.println("MAIN s1= " + s1);
        String sss = "23";
        List<String> strings = s.letterCombinations(sss);
        System.out.println("MAIN = " + strings);
    }

    public String shortestPalindromeNext(String s) throws InterruptedException, ExecutionException {

        String result = "";
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] inputArray = s.toCharArray();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Callable<MyType>> callableTasks = new ArrayList<>();


        for (int i = 0; i < inputArray.length; i++) {
            char[] combinedResult = combinedResult(inputArray, i);
            result = new String(combinedResult);
//            System.out.println("Test example: " + result);
            Callable<MyType> callableTask = () -> {

                return new MyType(isPalindrome(combinedResult), combinedResult);
            };
            callableTasks.add(callableTask);
//            Future<MyType> future =
//                    executorService.submit(callableTask);


        }
//        List<Future<MyType>> futures = executorService.invokeAll(callableTasks);
//        executorService.shutdown();
//        for (Future<MyType> future : futures) {
//            result =new String(future.get().resultStr);
//            Boolean isPalindrome = future.get().isPalindrome;
//            System.out.println(" isPalindrome "+isPalindrome+" result "+result);
//        }
        MyType future = executorService.invokeAny(callableTasks);

        result = new String(future.resultStr);
        Boolean isPalindrome = future.isPalindrome;
        System.out.println(" isPalindrome " + isPalindrome + " result " + result);
        executorService.shutdown();

        return result;
    }

    public char[] combinedResult(char[] inputArray, int indexFromEnding) {
        char[] resultArray = new char[inputArray.length + indexFromEnding];
        for (int i = 0; i < indexFromEnding; i++) {
            resultArray[i] = inputArray[inputArray.length - 1 - i];
        }
        for (int i = 0; i < inputArray.length; i++) {
            resultArray[i + indexFromEnding] = inputArray[i];
        }
        return resultArray;
    }


    public boolean isPalindrome(char[] charArray) {


        int arrayLength = charArray.length;
        int i = 0;
        int j = arrayLength - 1;
        while (i < j && charArray[i] == charArray[j]) {
            i = i + 1;
            j = j - 1;
        }
        if (charArray[i] == charArray[j]) {
            return true;
        }
        throw new RuntimeException("Not a palindrome");

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<String, String[]> mapping = new HashMap<>() {
            {
                put("2", "abc".split(""));
                put("3", "def".split(""));
                put("4", "ghi".split(""));
                put("5", "jkl".split(""));
                put("6", "mno".split(""));
                put("7", "pqrs".split(""));
                put("8", "tuv".split(""));
                put("9", "wxyz".split(""));

            }

        };
        if (digits.length() == 0) return result;
        if (digits.length() == 1) return List.of(mapping.get(digits));
        String[] digitsKeys = digits.split("");
        String[] left = mapping.get(digitsKeys[0]);
        for (int i = 1; i < digitsKeys.length; i++) {
            String[] right = mapping.get(digitsKeys[i]);
            List<String> combinedStringArrays = combineStringArrays(left, right);
            left =combinedStringArrays.toArray(String[]::new);
        }

        result = Arrays.stream(left).toList();


        return result;
    }

    List<String> combineStringArrays(String[] left, String[] right) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                result.add(new String(left[i] + right[j]));
            }
        }
        return result;
    }


}
