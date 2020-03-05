package com.nal.problems.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 27/02/20.
 */
public class Graph {

    int nodeCount;
    List<List<Integer>> adjList;

    public Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        this.adjList = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addDirectedEdge(int fromNode, int toNode) {
        adjList.get(fromNode).add(toNode);
    }

    public void addUndirectedEdge(int fromNode, int toNode) {
        adjList.get(fromNode).add(toNode);
        adjList.get(toNode).add(fromNode);
    }
}
