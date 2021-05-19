package problems.graph.kotlin

import java.util.*

fun main(args: Array<String>) {
    val graph = Graph().create()
    println(graph)
}

class Graph {
    fun create(): ArrayList<ArrayList<Int>> {
        val adjacencyList = ArrayList<ArrayList<Int>>()
        for (i in 1..8) {
            adjacencyList.add(ArrayList())
        }
        adjacencyList[1].addAll(listOf(2, 4))
        adjacencyList[2].addAll(listOf(1, 3))
        adjacencyList[3].addAll(listOf(2, 4))
        adjacencyList[4].addAll(listOf(1, 3, 5))
        adjacencyList[5].addAll(listOf(4))
        adjacencyList[6].addAll(listOf(7))
        adjacencyList[7].addAll(listOf(6))

        return adjacencyList
    }

    fun createWithoutCycle(): ArrayList<ArrayList<Int>> {
        val adjacencyList = ArrayList<ArrayList<Int>>()
        for (i in 1..8) {
            adjacencyList.add(ArrayList())
        }
        adjacencyList[1].addAll(listOf(2))
        adjacencyList[2].addAll(listOf(1, 3))
        adjacencyList[3].addAll(listOf(2))

        adjacencyList[6].addAll(listOf(7))
        adjacencyList[7].addAll(listOf(6))

        return adjacencyList
    }
}