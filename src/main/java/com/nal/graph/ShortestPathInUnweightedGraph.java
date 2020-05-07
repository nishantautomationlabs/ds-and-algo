package com.nal.graph;

import java.util.*;

/**
 * Created by nishant on 28/01/20.
 * One solution is to solve in O(VE) time using Bellman–Ford. If there are no negative weight cycles,
 * then we can solve in O(E + VLogV) time using Dijkstra’s algorithm.
 * Since the graph is unweighted, we can solve this problem in O(V + E) time.
 * The idea is to use a modified version of Breadth-first search in which we keep storing the predecessor of a
 * given vertex while doing the breadth first search.
 */
public class ShortestPathInUnweightedGraph {
    int verticesCount;
    LinkedList<Integer> adjList[];

    public ShortestPathInUnweightedGraph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjList = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int source, int dest) {
        adjList[source].add(dest);
    }


    private void printShortestPath(int source, int dest) {

        int[] dist = new int[verticesCount];
        int[] predecessor = new int[verticesCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        boolean pathFound = calculateShortestPath(source, dest, dist, predecessor);
        if(!pathFound) {
            System.out.println("No path exists from source to destination");
            return;
        }
        System.out.println("Shortest path length is: " + dist[dest]);
        System.out.println("And the shortest path is: " + dist[dest]);
        int value = dest;
        Stack<Integer> stack = new Stack<>();
        while (value != -1) {
            stack.push(value);
            value = predecessor[value];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " --> ");
        }
        System.out.println();
    }

    private boolean calculateShortestPath(int source, int dest, int[] dist, int[] predecessor) {
        boolean[] visited = new boolean[verticesCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        dist[source] = 0;
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            Iterator<Integer> iterator = adjList[node].iterator();
            while (iterator.hasNext()) {
                int children = iterator.next();
                if (!visited[children]) {
                    visited[children] = true;
                    queue.add(children);
                    predecessor[children] = node;
                    dist[children] = dist[node] + 1;
                }
                if (children == dest) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ShortestPathInUnweightedGraph graph = new ShortestPathInUnweightedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        int source = 0, dest = 7;
        graph.printShortestPath(source, dest);
    }

}
