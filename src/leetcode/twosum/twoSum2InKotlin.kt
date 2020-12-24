package leetcode.twosum

/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Problem link:https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
* */

fun main() {
    val inputArray = intArrayOf(2, 7, 11, 15)
    val target = 9

    println(twoSum(inputArray, target).forEach { println(it) })
}

fun twoSum(inputArray: IntArray, target: Int): IntArray {
    var ptr1 = 0
    var ptr2 = inputArray.size - 1

    while (ptr1 < ptr2) {
        if (inputArray[ptr1] + inputArray[ptr2] < target)
            ptr1++
        else if (inputArray[ptr1] + inputArray[ptr2] > target)
            ptr2--
        else break
    }

    return intArrayOf(ptr1 + 1, ptr2 + 1)
}
