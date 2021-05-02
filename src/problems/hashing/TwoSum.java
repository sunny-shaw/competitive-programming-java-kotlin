package problems.hashing;

/*
 * Problem  link: https://leetcode.com/problems/two-sum/
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

//        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSumUsingHashMap(nums, target)).forEach(System.out::println);
    }

    // Time complexity O(N^2), space complexity O(1)
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // Time complexity O(N), space complexity O(N)
    private static int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int index = 0; index < nums.length; index++) {
            if (!map.containsKey(target - nums[index])) map.put(nums[index], index);
            else {
                result[0] = map.get(target - nums[index]);
                result[1] = index;
                return result;
            }
        }
        return result;
    }
}
