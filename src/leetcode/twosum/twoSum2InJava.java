package leetcode.twosum;

/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Problem link:https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
* */


public class twoSum2InJava {
    public static void main(String[] args) {
        int [] inputArray = new int[] {2,7,11,15};
        int target = 9;

        int[] result = twoSum(inputArray, target);

        for (int element: result) {
            System.out.println(element);
        }
    }

    private static int[] twoSum(int[] numbers, int target) {
        var ptr1 = 0;
        var ptr2 = numbers.length - 1;

        while (ptr1 < ptr2) {
            if (numbers[ptr1] + numbers[ptr2] < target)
                ptr1++;
            else if (numbers[ptr1] + numbers[ptr2] > target)
                ptr2--;
            else break;
        }

        return new int[] {ptr1 + 1, ptr2 + 1};
    }
}


