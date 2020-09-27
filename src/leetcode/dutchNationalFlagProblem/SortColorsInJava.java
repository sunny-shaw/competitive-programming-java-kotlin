package leetcode.dutchNationalFlagProblem;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

* */

class SortColorsInJava {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2, 0, 2};

        sort(nums);

        printArray(nums);
    }

    private static void sort(int[] nums) {
        var low = 0;
        var mid = 0;
        var high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0: {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(nums, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


