package com.ice.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Finds Anagrams
 * 
 * Write a program that accepts a block of text (English words), and outputs the groups of
 * words that are anagrams of each other. For example, "apt", "tap" and "pat" are anagrams
 * of each other.
 * 
 * Assumptions:
 *    1. Text contains only English Words.
 *    2. Returns all results in lowercase string. 
 *    3. Returns empty array in case of empty string or null text.
 * 
 * @author Pritam Banerjee
 * @version 15 June, 2019
 */
public class FindAnagrams {

    /**
     * Finds the group of Anagram Strings.
     * Time Complexity: O(n)   Space Complexity: O(1) (ignoring result list)
     * 
     * @param text String text.
     * @return result Groups of anagrams.Empty list in case if the text is null or blank. 
     */
    public List<List<String>> groupOfAnagramStrings(String text) {

        List<List<String>> result = new ArrayList<List<String>>();
        if (text == null || text.length() == 0) {
            // Return empty list in case of blank string or null
            return result;
        }

        // Converts the entire string to lowercase
        text = text.trim();
        if (text.equals(" ")) {
            return result;
        }
        text = text.toLowerCase();
        String[] strs = text.split("\\s+");

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        // Time Complexity: O(n)
        for (String str : strs) {

            // Space complexity: O(1)
            char[] arr = new char[26];

            // Add to the fixed char array.
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);

            // If the string are same add to result.
            // Time Complexity: O(1)
            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }
        result.addAll(map.values());
        return result;
    }

    /**
     * Used for testing.
     * 
     * @param args arguments.
     */
    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
        String text1 = "Test sest  pnny ynnp NNyp nyp YnP";
        String text2 = "";
        String text3 = null;
        String text4 = " Test etst ";
        String text5 = " T t ";
        String text6 = "  ";

        List<List<String>> result1 = fa.groupOfAnagramStrings(text1);
        System.out.println(result1);

        List<List<String>> result2 = fa.groupOfAnagramStrings(text2);
        System.out.println(result2);

        List<List<String>> result3 = fa.groupOfAnagramStrings(text3);
        System.out.println(result3);

        List<List<String>> result4 = fa.groupOfAnagramStrings(text4);
        System.out.println(result4);

        List<List<String>> result5 = fa.groupOfAnagramStrings(text5);
        System.out.println(result5);

        List<List<String>> result6 = fa.groupOfAnagramStrings(text6);
        System.out.println(result6);
    }
}
