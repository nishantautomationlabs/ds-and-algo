package com.nal.datastructures.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by nishant on 27/01/20.
 * <p>
 * Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. The only catch here is,
 * unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once,
 * we use a boolean visited array.
 * DFS Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 * BFS Time Complexity: Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 */
public class DiGraphImpl {

    private LinkedList<Integer> adjListArray[];

    public DiGraphImpl(int verticesCount) {
        adjListArray = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++)
            adjListArray[i] = new LinkedList<>();
    }

    public void addEdge(int fromVertex, int toVertex) {
        adjListArray[fromVertex].add(toVertex);
    }

    public void printAdjList() {
        printAdjList(adjListArray);
    }

    public void printAdjList(LinkedList<Integer> adjListArray[]) {
        for (int i = 0; i < adjListArray.length; i++) {
            LinkedList<Integer> curr = adjListArray[i];
            System.out.print("head");
            Iterator<Integer> iterator = curr.iterator();
            while (iterator.hasNext()) {
                System.out.print(" --> " + iterator.next());
            }
            System.out.println();
        }
    }

    public void printDFS(int v) {
        boolean visited[] = new boolean[adjListArray.length];
        System.out.println("Depth First Search Traversal of Graph is: ");
        DFSUtil(v, visited);
        System.out.println();
    }

    public void printDFSForDisconnectedGraph() {
        boolean visited[] = new boolean[adjListArray.length];
        System.out.println("Depth First Search Traversal of Graph is: ");
        for (int i = 0; i < adjListArray.length; i++) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
        System.out.println();
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " --> ");
        ListIterator<Integer> iterator = adjListArray[v].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next])
                DFSUtil(next, visited);
        }
    }

    public void printBFS(int v) {
        System.out.println("BFS Traversal of Graph is ");
        boolean visited[] = new boolean[adjListArray.length];
        BFSUtil(v, visited);
        System.out.println();
    }

    private void BFSUtil(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next + " --> ");
            Iterator<Integer> iterator = adjListArray[next].iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public void printBFSForDisconnectedGraph() {
        System.out.println("BFS Traversal of Graph is ");
        boolean visited[] = new boolean[adjListArray.length];
        for (int i = 0; i < adjListArray.length; i++) {
            if (!visited[i]) {
                BFSUtil(i, visited);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DiGraphImpl graph = new DiGraphImpl(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(5, 6);
        graph.printAdjList();
        graph.printDFS(2);
        graph.printDFSForDisconnectedGraph();
        graph.printBFS(2);
        graph.printBFSForDisconnectedGraph();
    }
}
