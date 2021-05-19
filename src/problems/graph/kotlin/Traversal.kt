package problems.graph.kotlin

import java.util.*

class Traversal {
    fun bfs(noOfVertex: Int, graph: ArrayList<ArrayList<Int>>) {
        val bfsTraversal = mutableListOf<Int>()
        val visited = BooleanArray(8) { false }
        var connectedComponent = 0

        for (vertex in 1..noOfVertex) {
            if (!visited[vertex]) {
                connectedComponent++
                val queue = LinkedList<Int>()
                queue.add(vertex)
                visited[vertex] = true

                while (!queue.isEmpty()) {
                    val traversedVertex = queue.poll()!!
                    bfsTraversal.add(traversedVertex)

                    for (adjVertex in graph[traversedVertex]) {
                        if(!visited[adjVertex]) {
                            visited[adjVertex] = true
                            queue.add(adjVertex)
                        }
                    }
                }
            }
        }

        println("BFS traversal")
        println(bfsTraversal)

        println("Connected components")
        println(connectedComponent)
    }

    fun dfs(noOfVertex: Int, graph: ArrayList<ArrayList<Int>>) {
        val dfsTraversal = mutableListOf<Int>()
        val visited = BooleanArray(8) { false }

        for (vertex in 1..noOfVertex) {
            if(!visited[vertex]) dfsOfEachVertex(vertex, visited, graph, dfsTraversal)
        }

        println("DFS traversal")
        println(dfsTraversal)
    }

    private fun  dfsOfEachVertex(
        vertex: Int,
        visited: BooleanArray,
        graph: ArrayList<ArrayList<Int>>,
        dfsTraversal: MutableList<Int>
    ) {
        dfsTraversal.add(vertex)
        visited[vertex] = true

        for(adjVertex in graph[vertex]) {
            if(!visited[adjVertex]) dfsOfEachVertex(adjVertex, visited, graph, dfsTraversal)
        }
    }
}