package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteMap = new HashMap<>();

        char[] noteArray = ransomNote.toCharArray();
        for (char c : noteArray) {
            if (noteMap.containsKey(c)) {
                noteMap.put(c, noteMap.get(c) + 1);
            } else {
                noteMap.put(c, 1);
            }
        }

        char[] magArray = magazine.toCharArray();
        for (char c : magArray) {
            if (noteMap.containsKey(c)) {
                noteMap.put(c, noteMap.get(c) - 1);
                if (noteMap.get(c) == 0) {
                    noteMap.remove(c);
                }
            }
        }
        return noteMap.isEmpty();
    }
}
