package leetcode.majorityElement

/*
229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?
Problem link: https://leetcode.com/problems/majority-element-ii/
* */

fun main() {
    val arr = intArrayOf(1,1,1,2,2,2,3,3)

    val majorityElement = majorityElement2(arr)

    println(majorityElement)
}

fun majorityElement2(nums: IntArray): List<Int> {
    var num1 = Int.MIN_VALUE
    var num2 = Int.MIN_VALUE + 1
    var c1 = 0
    var c2 = 0
    val majorityElements = mutableListOf<Int>()

    for (element in nums) {
        when {
            element == num1 -> c1++
            element == num2 -> c2++
            c1 == 0 -> {
                num1 = element
                c1 = 1
            }
            c2 == 0 -> {
                num2 = element
                c2 = 1
            }
            else -> {
                c1--
                c2--
            }
        }
    }

    c1 = 0
    c2 = 0
    for(element in nums){
        when (element) {
            num1 -> c1++
            num2 -> c2++
        }
    }

    if(c1 > nums.size / 3)
        majorityElements.add(num1)
    if(c2 > nums.size / 3)
        majorityElements.add(num2)

    return majorityElements
}