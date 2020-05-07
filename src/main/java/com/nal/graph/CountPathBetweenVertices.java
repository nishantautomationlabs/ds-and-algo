package com.nal.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by nishant on 27/01/20.
 */
public class CountPathBetweenVertices {

    int verticesCount;
    LinkedList<Integer> adjListArray[];

    public CountPathBetweenVertices(int verticesCount) {
        this.verticesCount = verticesCount;
        adjListArray = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjListArray[sourceVertex].add(destinationVertex);
    }

    private int countPathBetween(int source, int destination) {
        boolean visited[] = new boolean[verticesCount];
        return countPathBetween(source, destination, visited, 0);
    }

    private int countPathBetween(int source, int destination, boolean[] visited, int count) {
        visited[source] = true;
        if (source == destination)
            count++;
        else {
            Iterator<Integer> iterator = adjListArray[source].iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    count = countPathBetween(next, destination, visited, count);
                }
            }
        }
        visited[source] = false;
        return count;
    }

    public static void main(String[] args) {
        CountPathBetweenVertices graph = new CountPathBetweenVertices(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        System.out.println("Count of path from 2 to 3 is : " + graph.countPathBetween(2, 3));
    }

}
