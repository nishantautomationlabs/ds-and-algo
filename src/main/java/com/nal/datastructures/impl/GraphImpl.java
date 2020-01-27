package com.nal.datastructures.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by nishant on 27/01/20.
 */
public class GraphImpl {

    private LinkedList<Integer> adjListArray[];

    public GraphImpl(int verticesCount) {
        adjListArray = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++)
            adjListArray[i] = new LinkedList<>();
    }

    public void addEdge(int fromVertex, int toVertex) {
        adjListArray[fromVertex].add(toVertex);
        adjListArray[toVertex].add(fromVertex);
    }

    public void print() {
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

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.print();
        graph.printDFS(2);
    }
}
