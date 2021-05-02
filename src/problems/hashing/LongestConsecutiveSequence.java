package problems.hashing;

/*
 * Problem  link: https://leetcode.com/problems/longest-consecutive-sequence/submissions/
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = new int[]{100,4,200,1,3,2};

        System.out.println(longestConsecutiveSequence(nums));
    }

    // Time complexity (Insertion into hash set + linear traversal + Linear increment for longest consecutive sequence)
    // O(N) + O(N) + O(N) => O(3N), space complexity O(N)
    private static int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int result = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int currentSequence = num;

                while (set.contains(currentSequence + 1)) {
                    count++;
                    currentSequence++;
                }

                if (result < count) result = count;
            }
        }

        return result;
    }
}
