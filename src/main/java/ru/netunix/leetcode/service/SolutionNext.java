package ru.netunix.leetcode.service;

import ru.netunix.leetcode.util.ListNode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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
        SolutionNext s = new SolutionNext();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l4.setNext(l5);
        ListNode l3 = new ListNode(3);
        l3.setNext(l4);
        ListNode l2 = new ListNode(2);
        l2.setNext(l3);
        ListNode l1 = new ListNode(1);
        l1.setNext(l2);
        ListNode l0 = new ListNode(0);
        l0.setNext(l1);
        s.removeNthFromEnd(l0, 1);


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
            left = combinedStringArrays.toArray(String[]::new);
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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;


        Arrays.sort(nums);
        Map<Integer, Integer> keyAmount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer i1 = keyAmount.containsKey(nums[i]) ?
                    keyAmount.put(nums[i], keyAmount.get(nums[i]) + 1) : keyAmount.put(nums[i], 1);

        }
        if (keyAmount.size() == 1 && keyAmount.containsKey(0)) {
            result.add(List.of(0, 0, 0));
            return result;
        }

        HashMap<String, List<Integer>> mapResult = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int[] r = new int[3];
                r[0] = nums[i];
                r[1] = nums[j];
                int leftvalue = (int) (0 - r[0] - r[1]);
                r[2] = leftvalue;

                if (keyAmount.keySet().contains(leftvalue)) {
                    if (r[2] == 0 && r[2] == r[0] && keyAmount.get(r[2]) > 2) {
                        Arrays.sort(r);
                        List<Integer> list = Arrays.stream(r).boxed().toList();
                        String key = "" + r[0] + "" + r[1] + "" + r[2];
                        mapResult.put(key, list);
                    }
                    if (r[2] != 0 && (r[2] == r[1] || r[2] == r[0]) && keyAmount.get(r[2]) > 1) {
                        Arrays.sort(r);
                        List<Integer> list = Arrays.stream(r).boxed().toList();
                        String key = "" + r[0] + "" + r[1] + "" + r[2];
                        mapResult.put(key, list);
                    }
                    if (r[2] != r[1] && r[2] != r[0]) {
                        Arrays.sort(r);
                        List<Integer> list = Arrays.stream(r).boxed().toList();
                        String key = "" + r[0] + "" + r[1] + "" + r[2];
                        mapResult.put(key, list);
                    }
                }
            }
        }
        result = new ArrayList<>(mapResult.values());
        return result;


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Set<Integer> mySet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (mySet.size() == 1) {
            if ((Long.valueOf(nums[0] + nums[1]) + nums[2]) == Long.valueOf(target) - nums[0]) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[0]);
                list.add(nums[0]);
                list.add(nums[0]);
                result.add(list);
                return result;
            } else return result;
        }
        HashMap<String, List<Integer>> mapResult = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int p = k + 1; p < nums.length; p++) {
                        if ((Long.valueOf(nums[i] + nums[j]) + nums[k]) == Long.valueOf(target) - nums[p]) {

                            int[] r = new int[4];
                            r[0] = nums[i];
                            r[1] = nums[j];
                            r[2] = nums[k];
                            r[3] = nums[p];
                            Arrays.sort(r);
                            List<Integer> list = Arrays.stream(r).boxed().toList();
                            String key = "" + r[0] + "" + r[1] + "" + r[2] + "" + r[3];
                            mapResult.put(key, list);
                        }
                    }
                }
            }
        }
        result = new ArrayList<>(mapResult.values());
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) return result;
        int currentDifference = (target - result) < 0 ? (target - result) * (-1) : (target - result);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int middleResult = nums[i] + nums[j] + nums[k];
                    int middleDifference = (target - middleResult) < 0 ? (target - middleResult) * (-1) : (target - middleResult);
                    if (middleDifference < currentDifference) {
                        currentDifference = middleDifference;
                        result = middleResult;
                    }
                }
            }
        }

        return result;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode current = head;
        ListNode elementToRemove = head;
        ListNode elementBeforeRemoved = head;
        int i =1;
        while(current.getNext()!=null){
            current = current.getNext();

            if(i>n){
                elementBeforeRemoved = elementBeforeRemoved.getNext();
                elementToRemove = elementToRemove.getNext();
            }
            if(i == n){
                elementToRemove = elementBeforeRemoved.getNext();
            }
            i++;

        }

        //if element to remove is the head
        if(elementToRemove == head){
            result = elementToRemove.getNext();
            elementToRemove.setNext(null);
        }
        else {
            ListNode temp = elementToRemove.getNext();
            elementToRemove.setNext(null);
            elementBeforeRemoved.setNext(temp);
        }



        return result;

    }


}
