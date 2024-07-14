package ru.netunix.leetcode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
