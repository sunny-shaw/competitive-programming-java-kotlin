package problems.graph.kotlin

fun main() {
    val graph = Graph().create()
    val noOfVertex = graph.size - 1
    Traversal().bfs(noOfVertex, graph)
    Traversal().dfs(noOfVertex, graph)
}
