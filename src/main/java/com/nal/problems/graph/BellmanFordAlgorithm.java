package com.nal.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 29/01/20.
 */
public class BellmanFordAlgorithm {

    class Graph {
        class Edge {
            int source;
            int dest;
            int weight;

            public Edge(int source, int dest, int weight) {
                this.source = source;
                this.dest = dest;
                this.weight = weight;
            }
        }

        List<Edge> edgeList;
        int verticesCount;
        int edgeCount;

        public Graph(int verticesCount, int edgeCount) {
            this.verticesCount = verticesCount;
            this.edgeCount = edgeCount;
            edgeList = new ArrayList<>(edgeCount);
        }

        public void addEdge(int source, int dest, int weight) {
            edgeList.add(new Edge(source, dest, weight));
        }
    }

    public int[] findShortestDistance(Graph graph, int source) {
        int[] dist = new int[graph.verticesCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < graph.verticesCount - 1; i++) {
            for (int j = 0; j < graph.edgeCount; j++) {
                if (dist[graph.edgeList.get(j).source] + graph.edgeList.get(j).weight < dist[graph.edgeList.get(j).dest])
                    dist[graph.edgeList.get(j).dest] = dist[graph.edgeList.get(j).source] + graph.edgeList.get(j).weight;
            }
        }
        return dist;
    }

    public boolean hasNegativeWeightCycle(Graph graph, int source) {
        int[] dist = new int[graph.verticesCount];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        for (int i = 0; i < graph.verticesCount - 1; i++) {
            for (int j = 0; j < graph.edgeCount; j++) {
                if (dist[graph.edgeList.get(j).source] + graph.edgeList.get(j).weight < dist[graph.edgeList.get(j).dest])
                    dist[graph.edgeList.get(j).dest] = dist[graph.edgeList.get(j).source] + graph.edgeList.get(j).weight;
            }
        }
        for (int j = 0; j < graph.edgeCount; j++) {
            if (dist[graph.edgeList.get(j).source] + graph.edgeList.get(j).weight < dist[graph.edgeList.get(j).dest])
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm bellmanFord = new BellmanFordAlgorithm();
        Graph graph = bellmanFord.new Graph(5, 8);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);
//        graph.addEdge(4, 0, -2); //Add negative weight cycle

        int[] dist = bellmanFord.findShortestDistance(graph, 0);

        for (int i = 0; i < dist.length; i++)
            System.out.println("Shortest path of vertex " + i + " from 0 is " + dist[i]);

        System.out.println("Has Cycle " + bellmanFord.hasNegativeWeightCycle(graph, 0));
    }
}
