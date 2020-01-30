package com.nal.problems.graph;

import java.util.*;

/**
 * Created by nishant on 27/01/20.
 * The time complexity of the above code/algorithm looks O(V^2) as there are two nested while loops.
 * If we take a closer look, we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS).
 * The inner loop has decreaseKey() operation which takes O(LogV) time. So overall time complexity is O(E+V)*O(LogV)
 * which is O((E+V)*LogV) = O(ELogV)
 */
public class DijkstrasAlgorithm {

    private int[] calShortestDistFromVertex(int source, int verticesCount, List<List<GraphNode>> adjList) {
        int[] dist = new int[verticesCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<GraphNode> nodePriorityQueue = new PriorityQueue<>(verticesCount, Comparator.comparingInt(s -> s.cost));
        nodePriorityQueue.add(new GraphNode(source, 0));
        dist[source] = 0;
        while (visited.size() != verticesCount) {
            GraphNode sourceNode = nodePriorityQueue.poll();
            visited.add(sourceNode.nodeNumber);

            Iterator<GraphNode> graphNodeIterator = adjList.get(sourceNode.nodeNumber).iterator();
            while (graphNodeIterator.hasNext()) {
                GraphNode graphNode = graphNodeIterator.next();
                if (!visited.contains(graphNode.nodeNumber)) {
                    if (dist[sourceNode.nodeNumber] + graphNode.cost < dist[graphNode.nodeNumber]) {
                        dist[graphNode.nodeNumber] = dist[sourceNode.nodeNumber] + graphNode.cost;
                        nodePriorityQueue.add(new GraphNode(graphNode.nodeNumber, dist[graphNode.nodeNumber]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 11);
        graph.addEdge(0, 4, 3);

        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        DijkstrasAlgorithm algorithm = new DijkstrasAlgorithm();
        int[] dist = algorithm.calShortestDistFromVertex(0, graph.nodeCount, graph.adjList);

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Shorted path from 0 to " + i + " is " + dist[i]);
        }
    }
}
