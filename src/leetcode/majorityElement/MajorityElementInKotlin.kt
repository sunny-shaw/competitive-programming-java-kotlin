package leetcode.majorityElement

fun main() {
    val arr = intArrayOf(2, 2, 3, 7, 3, 3, 2, 2, 2)

    val majorityElement = majorityElement(arr)

    println(majorityElement)
}

fun majorityElement(nums: IntArray): Int {
    var majorityElement = 0
    var count = 0
    for (element in nums) {
        when {
            count == 0 -> {
                majorityElement = element
                count = 1
            }
            element == majorityElement -> count++
            else -> count--
        }
    }
    return majorityElement
}