package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netunix.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return current.getNext() == null;
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
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        Solution s = new Solution();
        boolean nearbyDuplicate = s.containsNearbyDuplicate(nums, k);
        log.info("result = {}", nearbyDuplicate);
    }

    public double[] convertTemperature(double celsius) {
        List<Double> result = new ArrayList<>();
        var kelvinTemp = getKelvinTemp(celsius);
        result.add(kelvinTemp);
        var fahrenheitTemp = getFahrenheitTemp(celsius);
        result.add(fahrenheitTemp);
        return result.stream().mapToDouble(i->i).toArray();
    }

    private double getFahrenheitTemp(double celsius) {
        return celsius * 1.8 + 32.0;
    }

    private double getKelvinTemp(double celsius) {
        return celsius + 273.15;
    }


}
