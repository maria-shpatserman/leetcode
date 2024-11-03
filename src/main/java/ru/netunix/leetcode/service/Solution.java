package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netunix.leetcode.util.ListNode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class Solution {
    //242. Valid Anagram
    public Boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapInput = getMapWithCharCount(s);
        Map<Character, Integer> mapCompare = getMapWithCharCount(t);
        if (!mapCompare.keySet().equals(mapInput.keySet())) return false;
        for (Character key : mapInput.keySet()) {
            if (!mapInput.get(key).equals(mapCompare.get(key))) return false;
        }
        return true;

    }

    private Map<Character, Integer> getMapWithCharCount(String s) {
        Map<Character, Integer> mapInput = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (mapInput.containsKey(c)) {
                mapInput.put(c, mapInput.get(c) + 1);
            } else {
                mapInput.put(c, 1);
            }
        }
        return mapInput;
    }

    //66 Plus one
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int term = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int resultInt = digits[i] + term;
            if (resultInt > 9) {
                list.add(0);
                term = 1;
            } else {
                list.add(resultInt);
                term = 0;
            }
        }
        if (term == 1) {
            list.add(term);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(list.size() - i - 1);

        }
        return result;
    }

    public int mySqrt(int x) {
        int result = 1;
        while (true) {
            Long twice = getDouble(result);
            if (twice > x) break;
            result = result + 1;
        }
        return result - 1;
    }

    public Long getDouble(long x) {
        return (x * x);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        if (current == null) return head;
        ListNode next = current.getNext();
        if (isLast(current)) return current;
        while (!isLast(current)) {
            ListNode nextPlusOne = next.getNext();
            if (current.getVal() == next.getVal()) {
                current.setNext(nextPlusOne);
                next = nextPlusOne;
            } else {
                current = next;
                next = next.getNext();
            }

        }


        return head;

    }

    boolean isLast(ListNode current) {
        if (current == null) return true;
        return current.next == null;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return false;
        Map<Integer, List<Integer>> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (values.containsKey(nums[i])) {
                values.get(nums[i]).add(i);

            } else {
                values.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        List<Map.Entry<Integer, List<Integer>>> collected = values.entrySet().stream().filter((entry) ->
                entry.getValue().size() > 1
        ).collect(Collectors.toList());
        boolean result = false;
        for (Map.Entry entry : collected) {
            List<Integer> indexes = (List<Integer>) entry.getValue();
            int startIndex = 0;
            int leftIndex = indexes.get(startIndex);
            for (int i = startIndex + 1; i < indexes.size(); i++) {
                result = isAvailableNearbyDuplicate(i, leftIndex, k, indexes);
                if (result) return result;
                else {
                    startIndex = i;
                    leftIndex = indexes.get(startIndex);

                }
            }
        }
        return result;

    }

    boolean isAvailableNearbyDuplicate(int startIndex, int leftIndex, int desiredValue, List<Integer> indexes) {
        boolean result = false;

        for (int i = startIndex; i < indexes.size(); i++) {
            if ((indexes.get(i) - leftIndex <= desiredValue)) {
                return true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = solution.convert(s, 3);
        System.out.println("MAIN result = " + result);
    }

    public double[] convertTemperature(double celsius) {
        List<Double> result = new ArrayList<>();
        var kelvinTemp = getKelvinTemp(celsius);
        result.add(kelvinTemp);
        var fahrenheitTemp = getFahrenheitTemp(celsius);
        result.add(fahrenheitTemp);
        return result.stream().mapToDouble(i -> i).toArray();
    }

    private double getFahrenheitTemp(double celsius) {
        return celsius * 1.8 + 32.0;
    }

    private double getKelvinTemp(double celsius) {
        return celsius + 273.15;
    }

    public int[] twoSum(int[] nums, int target) {


        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;

    }

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();

        int arrayLength = charArray.length;
        if (arrayLength == 0) {
            return 0;
        }
        int result = 0;
        for (int index = 0; index < arrayLength; index++) {
            int currentMaxLen = getMaxLen(index, charArray, arrayLength);
            if (currentMaxLen > result) {
                result = currentMaxLen;
            }
        }

        return result;

    }

    private int getMaxLen(int index, char[] charArray, int arrayLength) {
        Set<Character> set = new HashSet<>();
        int indexStart = index;
        char c = charArray[index];
        while (set.add(c) && index < arrayLength) {

            index = index + 1;
            if (index < arrayLength) c = charArray[index];

        }
        return (index - indexStart);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = l1;
        ListNode current2 = l2;
        int additional = 0;
        ListNode head = new ListNode(0);
        ListNode end = head;
        while (isOneNotLast(current, current2)) {
            int result = additional;
            if (current != null) {
                result = result + current.val;
                current = current.next;
            }
            if (current2 != null) {
                result = result + current2.val;
                current2 = current2.next;
            }
            if (result > 9) {
                result = result - 10;
                end.val = (result);
                additional = 1;
            } else {
                end.val = (result);
                additional = 0;
            }
            ListNode newEnd = (new ListNode(0));
            end.next = newEnd;
            end = newEnd;

        }
        //end value =0

        int result = additional;
        if (current != null) {
            result = result + current.val;

        }
        if (current2 != null) {
            result = result + current2.val;
        }
        if (result > 9) {
            additional = 1;
            result = result - 10;
            end.val = result;
            end.next = (new ListNode(additional));
        } else {
            end.val = (result);
        }
        return head;

    }

    private boolean isOneNotLast(ListNode l1, ListNode l2) {
        if (!isLast(l1)) return true;
        return !isLast(l2);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Integer num1 = getNumber(l1);
        Integer num2 = getNumber(l2);
        Integer sum = num1 + num2;
        StringBuilder temp = new StringBuilder(sum.toString());
        StringBuilder reversed = temp.reverse();
        int[] array = reversed.chars().toArray();
        ListNode current;
        ListNode previous = null;
        ListNode head = null;
        for (int i = 0; i < array.length; i++) {

            int intValue = array[i] - 48;
            current = new ListNode(intValue);
            if (i == 0) {
                head = current;
            }

            if (previous != null) {
                previous.setNext(current);
                previous = current;
            } else {
                previous = current;
            }


        }
        return head;

    }

    Integer getNumber(ListNode listNode) {
        StringBuilder numberL1 = new StringBuilder();

        ListNode current = listNode;
        while (!isLast(current)) {
            numberL1.append(current.getVal());
            current = current.getNext();
        }
        numberL1.append(current.getVal());
        log.info("number1 = " + numberL1);
        Integer result = Integer.valueOf(numberL1.reverse().toString());
        log.info("num1 = " + numberL1);
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;

        int resultLength = nums1.length + nums2.length;
        int indexMedian1;
        int indexMedian2;
        if (resultLength % 2 == 0) {
            indexMedian1 = resultLength / 2;
            indexMedian2 = (resultLength / 2) - 1;
        } else {
            indexMedian2 = (resultLength / 2);
            indexMedian1 = indexMedian2;
        }

        int index1 = 0;
        int index2 = 0;
        int[] resultArray = new int[indexMedian1 + 1];
        for (int i = 0; i <= indexMedian1; i++) {
            if (index2 >= nums2.length || (index1 < nums1.length && nums1[index1] < nums2[index2])) {
                resultArray[i] = nums1[index1];
                index1 = index1 + 1;
            } else {
                resultArray[i] = nums2[index2];
                index2 = index2 + 1;
            }
        }
        result = (resultArray[indexMedian1] + resultArray[indexMedian2]) / 2.0;
        return result;
    }

    public String longestPalindrome(String s) {

        List<String> evenPolindroms = evenPolindroms(s);
        List<String> oddPolindroms = oddPolindroms(s);
        if (evenPolindroms.size() == 0 && oddPolindroms.size() == 0) {
            return s.substring(0, 1);
        }
        String longestEvenPolindrom = s.substring(0, 1);
        String longestOddPolindrom = s.substring(0, 1);
        if (evenPolindroms.size() > 0) {
            longestEvenPolindrom = evenPolindroms.stream().max(Comparator.comparing(x -> x.length())).get();

        }
        if (oddPolindroms.size() > 0) {
            longestOddPolindrom = oddPolindroms.stream().max(Comparator.comparing(x -> x.length())).get();
        }
        if (longestOddPolindrom.length() > longestEvenPolindrom.length()) {
            return longestOddPolindrom;
        } else return longestEvenPolindrom;

    }

    public List<String> oddPolindroms(String s) {
        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();

        int arrayLength = charArray.length;
        for (int i = 0; i < arrayLength; i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < arrayLength && charArray[leftIndex] == charArray[rightIndex]) {
                result.add(s.substring(leftIndex, rightIndex + 1));
                leftIndex--;
                rightIndex++;
            }
        }
        return result;
    }


    public List<String> evenPolindroms(String s) {
        char[] charArray = s.toCharArray();

        int arrayLength = charArray.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            int leftIndex = i;
            int rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < arrayLength && charArray[leftIndex] == charArray[rightIndex]) {
                result.add(s.substring(leftIndex, rightIndex + 1));
                leftIndex--;
                rightIndex++;
            }
        }
        return result;
    }


    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();

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
        return false;

    }

    public int maxArea(int[] height) {
        int currentMaxArea = 0;
        int currentMaxHeight = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > currentMaxHeight) {
                for (int j = i + 1; j < height.length; j++) {
                    int currentHeight = (height[i] < height[j]) ? height[i] : height[j];
                    int currentWidth = j - i;
                    int currentArea = currentHeight * currentWidth;
                    if (currentArea > currentMaxArea) {
                        currentMaxArea = currentArea;
                    }
                }
            }
            currentMaxHeight = (currentMaxHeight < height[i]) ? height[i] : currentMaxHeight;
        }


        return currentMaxArea;

    }

    public String convert(String s, int numRows) {
        String result = "";
        if (numRows == 1) return s;
        Map<String, List<Character>> zigzagMap = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            zigzagMap.put("line" + i, new ArrayList<>());
        }
        char[] charArray = s.toCharArray();
        int iterator = 0;
        while (iterator < charArray.length) {
            for (int j = 0; j < numRows && iterator < charArray.length; j++) {
                zigzagMap.get("line" + j).add(charArray[iterator]);
                iterator++;
            }
            for (int k = numRows - 2; k > 0 && iterator < charArray.length; k--) {
                zigzagMap.get("line" + k).add(charArray[iterator]);
                iterator++;
            }
        }
        for (int i = 0; i < numRows; i++) {
            result = result + zigzagMap.get("line" + i).stream().map(e->e.toString()).collect(Collectors.joining());
        }
        return result;

    }

}
