package com.nal.problems.graph;

/**
 * Created by nishant on 28/02/20.
 * Time complexity is O(V+E)
 */
public class DetectCycleInGraphDFS {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addUndirectedEdge(1, 0);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(3, 4);
        DetectCycleInGraphDFS cycle = new DetectCycleInGraphDFS();
        System.out.println("Has Cycle: " + cycle.hasCycle(graph));
    }

    private boolean hasCycle(Graph graph) {
        boolean[] visited = new boolean[graph.nodeCount];

        for(int i = 0; i < graph.nodeCount; i++) {
            if(!visited[i]) {
                if(hasCycleUtil(graph, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(Graph graph, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for(int neighbor : graph.adjList.get(node)) {
            if(!visited[neighbor]) {
                if(hasCycleUtil(graph, neighbor, node, visited))
                    return true;
            } else if(neighbor != parent)
                return true;
        }
        return false;
    }
}
