package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netunix.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
