package leetcode.majorityElement;

/*
229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?
Problem link: https://leetcode.com/problems/majority-element-ii/
* */

import java.util.ArrayList;
import java.util.List;

class MajorityElement2InJava {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2,3,3,3};

        List<Integer> majorityElement = majorityElement2(arr);

        System.out.println(majorityElement);
    }

    static List<Integer> majorityElement2(int[] nums) {
        var num1 = Integer.MIN_VALUE;
        var num2 = Integer.MIN_VALUE + 1;
        var c1 = 0;
        var c2 = 0;

        for (int element : nums) {
            if (element == num1) c1++;
            else if (element == num2) c2++;
            else if (c1 == 0) {
                num1 = element;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = element;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        var majorityElements = new ArrayList<Integer>();
        c1 = 0;
        c2 = 0;
        for (int element : nums) {
            if(element == num1) c1++;
            else if(element == num2) c2++;
        }

        if (c1 > nums.length / 3)
            majorityElements.add(num1);
        if (c2 > nums.length / 3)
            majorityElements.add(num2);

        return majorityElements;
    }
}
