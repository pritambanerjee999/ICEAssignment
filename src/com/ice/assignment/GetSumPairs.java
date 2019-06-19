package com.ice.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Write a program that that accepts an array of integers, and prints out the distinct 
 * pairs of these integers that sum to 7. For example, if the input is [1, 2, 3, 4, 5, 6],
 * the output could be (1,6), (2, 5), (3, 4), or (6,1), (5, 2), (4,3). Different 
 * combinations of the same pair of numbers e.g, (1, 6) and (6, 1) are not distinct. 
 * In this case, you should only print (1, 6) or (6, 1) but not both of them.
 *
 * @author Pritam Banerjee
 * @version 15 June, 2019
 */
public class GetSumPairs {

    /**
     * Gets the sum of Pairs.
     * Time Complexity: O(n) and 1 pass. Space Complexity: O(n)
     * 
     * @param nums Array of numbers
     * @param target Target sum (7)
     * @return List of pairs of integers.
     */
    public List<List<Integer>> getSumPairs(int[] nums, int target) {

        // List of pairs.
        List<List<Integer>> result = new ArrayList<>();

        // Handling null and empty arrays.
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Used to remove duplicates.
        Set<Integer> set = new HashSet<>();

        // Remove all duplicates from nums.
        // Time: O(n) Space: O(n)
        for (int i : nums) {
            set.add(i);
        }

        // Convert back to int[] array.
        Integer[] arr = set.toArray(new Integer[0]);

        // Map to store the Integer and position.
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the array and keep adding to the map.
        // Time: O(n) Space:O(n)
        for (int i = 0; i < arr.length; i++) {
            long diff = target - arr[i];

            // Check for edge cases.
            if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                continue;
            }
            if (map.containsKey((int) diff)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[map.get((int) diff)]);
                result.add(pair);
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }

    /**
     * Used for testing.
     * 
     * @param args arguments.
     */
    public static void main(String[] args) {
        GetSumPairs gsp = new GetSumPairs();
        int[] arr1 = { 5, 2, 3, 5, 4, 7, 0, 7, 3, 5, 7 };
        int[] arr2 = {};
        int[] arr3 = { 0 };
        int[] arr4 = { Integer.MAX_VALUE, Integer.MIN_VALUE, 2, 7, 0 };
        int[] arr5 = { Integer.MAX_VALUE, 7 - Integer.MAX_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE + 7, -2, 9 };
        int[] arr6 = null;
        int[] arr7 = {-2, 9, -5, 12, 13, -6};
        System.out.println(gsp.getSumPairs(arr1, 7));
        System.out.println(gsp.getSumPairs(arr2, 7));
        System.out.println(gsp.getSumPairs(arr3, 7));
        System.out.println(gsp.getSumPairs(arr4, 7));
        System.out.println(gsp.getSumPairs(arr5, 7));
        System.out.println(gsp.getSumPairs(arr6, 7));
        System.out.println(gsp.getSumPairs(arr7, 7));
    }
}
