package problems.graph.kotlin

import java.util.ArrayList

fun main() {
    val graph = Graph().create()
//    val graph = Graph().createWithoutCycle()
    val noOfVertex = graph.size -  1

    if(CycleDetection().hasCycleUsingDFS(noOfVertex, graph))
        println("Graph has cycle")
    else println("Graph has no cycle")
}

class CycleDetection {
    fun hasCycleUsingDFS(noOfVertex: Int, graph: ArrayList<ArrayList<Int>>): Boolean {
        val visited = BooleanArray(8) { false }
        val parentVertex = -1

        for (vertex in 1..noOfVertex) {
            if(!visited[vertex]) return hasCycleForVertexUsingDFS(vertex, visited, graph, parentVertex)
        }
        return false
    }

    private fun  hasCycleForVertexUsingDFS(
        vertex: Int,
        visited: BooleanArray,
        graph: ArrayList<ArrayList<Int>>,
        parentVertex: Int
    ): Boolean {
        visited[vertex] = true

        for(adjVertex in graph[vertex]) {
            if(!visited[adjVertex]) {
                if(hasCycleForVertexUsingDFS(adjVertex, visited, graph, vertex)) return true
            } else if(adjVertex != parentVertex) return true
        }
        return false
    }
}