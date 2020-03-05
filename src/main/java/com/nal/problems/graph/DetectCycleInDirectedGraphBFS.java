package com.nal.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 28/02/20.
 * Time Complexity O(V + E)
 */
public class DetectCycleInDirectedGraphBFS {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);
        DetectCycleInDirectedGraphBFS cycleInDirectedGraph = new DetectCycleInDirectedGraphBFS();
        System.out.println("Has Cycle: " + cycleInDirectedGraph.isCyclic(graph));
    }

    private boolean isCyclic(Graph graph) {
        int[] indegree = new int[graph.nodeCount];
        for(int i = 0; i < graph.adjList.size(); i++) {
            for(int neighbor : graph.adjList.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for(int neighbor : graph.adjList.get(node)) {
                if(--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return count != graph.nodeCount;
    }

}
