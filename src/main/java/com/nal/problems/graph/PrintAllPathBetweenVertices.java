package com.nal.problems.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nishant on 27/01/20.
 */
public class PrintAllPathBetweenVertices {

    int verticesCount;
    LinkedList<Integer> adjListArray[];

    public PrintAllPathBetweenVertices(int verticesCount) {
        this.verticesCount = verticesCount;
        adjListArray = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjListArray[sourceVertex].add(destinationVertex);
    }

    private void printAllPaths(int source, int destination) {
        boolean visited[] = new boolean[verticesCount];
        List<Integer> paths = new ArrayList<>();
        paths.add(source);
        printAllPaths(source, destination, visited, paths);
    }

    private void printAllPaths(int source, int destination, boolean[] visited, List<Integer> paths) {
        visited[source] = true;
        if (source == destination) {
            paths.stream().forEach(s -> System.out.print(s + " --> "));
            System.out.println();
        } else {
            Iterator<Integer> iterator = adjListArray[source].iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    paths.add(next);
                    printAllPaths(next, destination, visited, paths);
                    paths.remove((Integer) next);
                }
            }
        }
        visited[source] = false;
    }

    public static void main(String[] args) {
        PrintAllPathBetweenVertices graph = new PrintAllPathBetweenVertices(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        System.out.println("All paths between 2 and 3 are:");
        graph.printAllPaths(2, 3);
    }

}
