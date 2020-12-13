package leetcode.allduplicates;
/*
442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Problem Link : https://leetcode.com/problems/find-all-duplicates-in-an-array/
* */

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class AllDuplicatesInJava {
    public static void main(String[] args) {
        int []inputArr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(inputArr));
    }

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int element : nums){
            int index = abs(element) - 1;
            if (nums[index] < 0) result.add(index + 1);
            nums[index] = -nums[index];
        }

        return result;
    }
}
