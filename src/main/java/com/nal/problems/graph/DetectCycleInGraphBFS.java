package com.nal.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 28/02/20.
 * Time complexity is O(V+E)
 */
public class DetectCycleInGraphBFS {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addUndirectedEdge(1, 0);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(3, 4);
        DetectCycleInGraphBFS cycle = new DetectCycleInGraphBFS();
        System.out.println("Has Cycle: " + cycle.hasCycle(graph));
    }

    private boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.nodeCount];
        for (int i = 0; i < graph.nodeCount; i++) {
            if (!visited[i] && hasCycleUtil(graph, i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(Graph graph, int node, boolean[] visited) {
        int[] parent = new int[graph.nodeCount];
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        parent[node] = -1;
        queue.add(node);

        while (!queue.isEmpty()) {
            int child = queue.poll();
            for (int neighbor : graph.adjList.get(child)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = child;
                } else if (neighbor != parent[child])
                    return true;
            }
        }
        return false;
    }
}
