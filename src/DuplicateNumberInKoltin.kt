// Problem no. 287 : Find the duplicate number from the given array of numbers. Numbers will be from 1 to n. Assume there will be exactly one duplicate number.

//NOTE :  All the integers in nums appear only once except for precisely one integer which appears two or more times.

fun main() {
    val arr = intArrayOf(2,5,9,6,9,3,8,9,7,1)

    println(findDuplicate(arr))
}

fun findDuplicate(arr: IntArray): Int {
    var slow = arr[0]
    var fast = arr[0]

    do {
        slow = arr[slow]
        fast = arr[arr[fast]]
    } while (slow != fast)

    fast = arr[0]

    while (slow != fast) {
        slow = arr[slow]
        fast = arr[fast]
    }

    return slow
}