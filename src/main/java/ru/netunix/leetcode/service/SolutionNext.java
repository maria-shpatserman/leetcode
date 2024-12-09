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
import java.util.concurrent.Future;
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
        List<ListNode> listOfListNodes1 = new ArrayList<>();

        ListNode l4 = new ListNode(5);

        ListNode l3 = new ListNode(4);
        l3.setNext(l4);
        ListNode l2 = new ListNode(1);
        l2.setNext(l3);
        ListNode l1 = new ListNode(-2);
        l1.setNext(l2);

        ListNode r3 = new ListNode(6);

        ListNode r2 = new ListNode(5);
        r2.setNext(r3);
        ListNode r1 = new ListNode(-2);
        r1.setNext(r2);

        listOfListNodes1.add(l1);
        listOfListNodes1.add(r1);
        ListNode l22 = new ListNode(0);
        ListNode l12 = new ListNode(-2);
        l12.setNext(l22);
        listOfListNodes1.add(l12);
        LocalTime myObj = LocalTime.now();
        System.out.println("Time before mergeSortedListsIntoOne " + myObj);
        ListNode nodes = s.mergeSortedListsIntoOne(listOfListNodes1);
        myObj = LocalTime.now();
        System.out.println("Time after mergeSortedListsIntoOne " + myObj);
        while (nodes.getNext() != null) {
            System.out.println(String.format("%s result element = %d", Thread.currentThread().getName(), nodes.getVal()));
            nodes = nodes.getNext();
        }
        System.out.println(String.format("%s end result element = %d", Thread.currentThread().getName(), nodes.getVal()));
//----------------------------
        List<ListNode> listOfListNodes2 = new ArrayList<>();


        //------
        ListNode l33 = new ListNode(-2);
        ListNode l23 = new ListNode(-3);
        l23.setNext(l33);
        ListNode l13 = new ListNode(-3);
        l13.setNext(l23);
        ListNode r43 = new ListNode(-2);
        ListNode r33 = new ListNode(-2);
        r33.setNext(r43);
        ListNode r23 = new ListNode(-3);
        r23.setNext(r33);
        ListNode r13 = new ListNode(-3);
        r13.setNext(r23);
        listOfListNodes2.add(l13);
        listOfListNodes2.add(r13);

        LocalTime myObj2 = LocalTime.now();
        System.out.println("Time before mergeSortedListsIntoOne2 " + myObj2);
        ListNode nodes2 = s.mergeSortedListsIntoOne(listOfListNodes2);
        myObj2 = LocalTime.now();
        System.out.println("Time after mergeSortedListsIntoOne2 " + myObj2);
        while (nodes2.getNext() != null) {
            System.out.println(String.format("%s result element = %d", Thread.currentThread().getName(), nodes2.getVal()));
            nodes2 = nodes2.getNext();
        }
        System.out.println(String.format("%s end result element = %d", Thread.currentThread().getName(), nodes2.getVal()));
//-------------------------------
        List<ListNode> listOfListNodes3 = new ArrayList<>();

        ListNode pl1 = new ListNode(-3);

        ListNode pr4 = new ListNode(-1);
        ListNode pr3 = new ListNode(-1);
        pr3.setNext(pr4);
        ListNode pr2 = new ListNode(-2);
        pr2.setNext(pr3);
        ListNode pr1 = new ListNode(-2);
        pr1.setNext(pr2);
        listOfListNodes3.add(pl1);
        listOfListNodes3.add(pr1);

        LocalTime myObj3 = LocalTime.now();
        System.out.println("Time before mergeSortedListsIntoOne3 " + myObj3);
        ListNode nodes3 = s.mergeSortedListsIntoOne(listOfListNodes3);
        myObj3 = LocalTime.now();
        System.out.println("Time after mergeSortedListsIntoOne3 " + myObj3);
        while (nodes3.getNext() != null) {
            System.out.println(String.format("%s result element = %d", Thread.currentThread().getName(), nodes3.getVal()));
            nodes3 = nodes3.getNext();
        }
        System.out.println(String.format("%s end result element = %d", Thread.currentThread().getName(), nodes3.getVal()));
//-----------------------------------------
        ListNode sp5 = new ListNode(5);
        ListNode sp4 = new ListNode(4);
        sp4.setNext(sp5);
        ListNode sp3 = new ListNode(3);
        sp3.setNext(sp4);
        ListNode sp2 = new ListNode(2);
        sp2.setNext(sp3);
        ListNode sp1 = new ListNode(1);
        sp1.setNext(sp2);
        ListNode swapped = s.swapPairs(sp1);
        while (swapped != null) {
            System.out.println(String.format("%s swapped element = %d", Thread.currentThread().getName(), swapped.getVal()));
            swapped = swapped.getNext();
        }


    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.getNext() == null) return head;
        ListNode left = head;

        head = left.getNext();
        ListNode previous = null;
        while (left != null && left.getNext() != null) {
            ListNode right = left.getNext();
            System.out.println(String.format(" left = %d right = %d",
                    left.getVal(), right.getVal()));
            ListNode temp;
            left.setNext(right.getNext());
            right.setNext(left);
            if(previous!=null) previous.setNext(right);
            previous = left;
            left = left.getNext();

        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0) return result;
        try {
            result = mergeSortedListsIntoOne(new ArrayList<>(Arrays.asList(lists)));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    ListNode mergeSortedListsIntoOne(List<ListNode> listOfListNodes) throws ExecutionException, InterruptedException {
        if (listOfListNodes.size() == 1) return listOfListNodes.get(0);
        System.out.println("start size = " + listOfListNodes.size());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<ListNode> result = mergeSortedListsWithService(listOfListNodes, executorService);

        while (result.size() > 1) {
            System.out.println("result size = " + result.size());
            result = mergeSortedListsWithService(result, executorService);
        }
        //if list of listnodes is 1
        executorService.shutdown();
        return result.get(0);

    }

    List<ListNode> mergeSortedListsWithService(List<ListNode> listOfListNodes, ExecutorService executorService) throws InterruptedException, ExecutionException {


        List<Callable<ListNode>> callableTasks = new ArrayList<>();
        //odd //even size of array
        for (int i = 0; i < listOfListNodes.size() - 1; i = i + 2) {

            int j = i + 1;
            System.out.println(String.format("i=%d j=%d", i, j));
            ListNode left = listOfListNodes.get(i);
            ListNode right = listOfListNodes.get(j);
            Callable<ListNode> callableTask = () -> {
                return mergeSortedLists(left, right);

            };

            callableTasks.add(callableTask);


        }
        List<Future<ListNode>> futures = executorService.invokeAll(callableTasks);


        List<ListNode> result = new ArrayList<>();
        //add odd last element
        if (listOfListNodes.size() % 2 != 0) {
            result.add(listOfListNodes.getLast());
        }
        for (int i = 0; i < futures.size(); i++) {
            result.add(futures.get(i).get());

        }
        return result;
    }


    ListNode mergeSortedLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode current = right;
        ListNode merged = left;
        ListNode previous = null;
        while (current.getNext() != null) {
            System.out.println(String.format("%s right element = %d", Thread.currentThread().getName(), current.getVal()));
            System.out.println(String.format("%s left element = %d", Thread.currentThread().getName(), merged.getVal()));

            while ((merged.getVal() < current.getVal()) && merged.getNext() != null) {
                previous = merged;
                merged = merged.getNext();

            }
            //insert between
            ListNode newNode = new ListNode(current.getVal());
            //new head
            if (merged.getVal() <= newNode.getVal()) {
                newNode.setNext(merged.getNext());
                merged.setNext(newNode);
                previous = newNode;

            } else if (previous == null) {
                left = newNode;
                newNode.setNext(merged);
                merged = left;

            } else {
                previous.setNext(newNode);
                newNode.setNext(merged);
                previous = newNode;
            }


            current = current.getNext();

        }
        System.out.println(String.format("%s end right element = %d ", Thread.currentThread().getName(), current.getVal()));
        while ((merged.getVal() <= current.getVal()) && merged.getNext() != null) {
            previous = merged;
            merged = merged.getNext();

        }
        //insert between
        ListNode newNode = new ListNode(current.getVal());
        //new end
        if (newNode.getVal() > merged.getVal()) {
            merged.setNext(newNode);
        } else {
            if (previous != null) {
                previous.setNext(newNode);
            }

            if (previous == null) {
                left = newNode;

            }
            newNode.setNext(merged);


        }

        return left;
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
        int i = 1;
        while (current.getNext() != null) {
            current = current.getNext();

            if (i > n) {
                elementBeforeRemoved = elementBeforeRemoved.getNext();
                elementToRemove = elementToRemove.getNext();
            }
            if (i == n) {
                elementToRemove = elementBeforeRemoved.getNext();
            }
            i++;

        }

        //if element to remove is the head
        if (elementToRemove == head) {
            result = elementToRemove.getNext();
            elementToRemove.setNext(null);
        } else {
            ListNode temp = elementToRemove.getNext();
            elementToRemove.setNext(null);
            elementBeforeRemoved.setNext(temp);
        }


        return result;

    }

    public List<String> generateParenthesis(int n) {

        return generateByteCode(n * 2, n);
    }


    List<String> generateByteCode(int len, int n) {
        List<String> result = new ArrayList<>();
        int maxValue = (int) Math.pow(2, len);
        for (int i = 0; i < maxValue; i++) {
            String binaryString = String.format("%" + len + "s", Integer.toBinaryString(i)).replace(' ', '0');
            long count = binaryString.chars().filter(ch -> ch == '0').count();

            if (count == n) {
                Boolean needToAdd = true;
                int leftParentheses = 2;
                int rightParentheses = 2;
                String resultString = "";
                for (String c : binaryString.split("")) {
                    if (c.equals("0")) {
                        leftParentheses--;
                        resultString = resultString + "(";

                    } else {
                        rightParentheses--;
                        resultString = resultString + ")";
                    }
                    if (leftParentheses > rightParentheses) {
                        needToAdd = false;
                    }

                }
                if (needToAdd) result.add(resultString);
            }


        }
        return result;
    }

}
