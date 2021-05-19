package problems.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public static void main(String[] args) {
        var graph = create();

        System.out.println(graph);
    }

    private static ArrayList<ArrayList<Integer>> create() {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(1).addAll(Arrays.asList(2,3));
        adjacencyList.get(2).addAll(Arrays.asList(1,3));
        adjacencyList.get(3).addAll(Arrays.asList(2,4));
        adjacencyList.get(4).addAll(Arrays.asList(1,3,5));
        adjacencyList.get(5).addAll(Arrays.asList(4));
        adjacencyList.get(6).addAll(Arrays.asList(7));
        adjacencyList.get(7).addAll(Arrays.asList(6));

        return adjacencyList;
    }
}
