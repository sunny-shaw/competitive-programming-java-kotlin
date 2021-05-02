package problems.hashing;

/*
 * Problem  link: https://leetcode.com/problems/4sum/submissions/
 */

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int[] nums = new int[]{2,2,2,2,2};
        int target = 0;
//        int target = 8;

        System.out.println(fourSum(nums, target));
    }

    // Time complexity O(N^3 LogN), space complexity O(1)
    private static ArrayList<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> result = new ArrayList<>();
        int numsLength = nums.length;

        for (int i = 0; i <= numsLength - 4; i++) {
            for (int j = i + 1; j <= numsLength - 3; j++) {
                int low = j + 1, high = numsLength - 1;

                while (low < high) {
                int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum < target) low++;
                    else if (sum > target) high--;
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        result.add(temp);
                        while(low < high && nums[low] == temp.get(2)) low++; //avoid duplicates
                        while(low < high && nums[high] == temp.get(3)) high--; //avoid duplicates
                    }
                }

                while(i + 1 < numsLength && nums[i] == nums[i + 1]) i++;
                while(j + 1 < numsLength && nums[j] == nums[j + 1]) j++;
            }
        }
        return result;
    }
}
