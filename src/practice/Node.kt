package practice

data class Node(val value: Int, var next: Node? = null, var random: Node? = null) {
//    var node: Node? = null
//    var random: Node? = null
}

class Solution {
    fun copyRandomList(node: Node?): Node? {


        return null
    }
}

class LinkedList {
    fun insert(head: Node?, data: Int): Node {
        if(head == null)
            return Node(data)
        else {
            var tmp = head

            while (tmp!!.next != null)
                tmp = tmp.next

            tmp.next = Node(data)
        }

        return head
    }
}

fun main() {
    var head: Node? = null
    val values = listOf(7, 13, 10, 1)

    values.forEach {
        head = LinkedList().insert(head, it)
    }

//    printList(head)

    val linkedListWithRandomPointers = createLinkedListWithRandomPointers()

    printList(linkedListWithRandomPointers)
}

private fun printList(head: Node?) {
    var head1 = head
    while (head1 != null) {
        println("${head1.value} ${head1.random?.value}")
        head1 = head1.next
    }
}

fun createLinkedListWithRandomPointers(): Node {
    val node7 = Node(7)
    val node13 = Node(13)
    val node11 = Node(11)
    val node10 = Node(10)
    val node1 = Node(1)

    node7.next = node13
    node7.random = null

    node13.next = node11
    node13.random = Node(0)

    node11.next = node10
    node11.random = Node(4)

    node10.next = node1
    node10.random = Node(2)

    node1.next = null
    node1.random = Node(0)

    return node7
}