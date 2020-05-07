package com.nal.graph;

/**
 * Created by nishant on 28/02/20.
 * Time Complexity O(V + E)
 */
public class DetectCycleInDirectedGraphDFS {
    public static final int WHITE = 0;
    public static final int GREY = 1;
    public static final int BLACK = 2;

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);
        DetectCycleInDirectedGraphDFS cycleInDirectedGraph = new DetectCycleInDirectedGraphDFS();

        boolean hasCycle = false;
        int[] color = new int[graph.nodeCount];
        for (int i = 0; i < graph.nodeCount; i++) {
            if (color[i] == WHITE && cycleInDirectedGraph.isCyclic(graph, i, color)) {
                hasCycle = true;
                break;
            }
        }
        System.out.println("Has Cycle: " + hasCycle);
    }

    private boolean isCyclic(Graph graph, int node, int[] color) {
        color[node] = GREY;
        for (Integer child : graph.adjList.get(node)) {
            if (color[child] == GREY) {
                return true;
            }
            if (color[child] == WHITE && isCyclic(graph, child, color)) {
                return true;
            }
        }
        color[node] = BLACK;
        return false;
    }

}
