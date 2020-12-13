package leetcode.allduplicates

import kotlin.math.abs

/*
442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Problem Link : https://leetcode.com/problems/find-all-duplicates-in-an-array/
* */

fun main() {
    val inputArr = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)

    println(findDuplicates(inputArr))
}

fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()

    nums.forEach { element ->
        val index = abs(element) - 1
        if (nums[index] < 0) result.add(index + 1)
        nums[index] = -nums[index]
    }

    return result
}
