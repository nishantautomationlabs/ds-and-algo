package com.nal.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 27/01/20.
 */
public class WeightedGraph {

    int nodeCount;
    List<List<GraphNode>> adjList;

    public WeightedGraph(int nodeCount) {
        this.nodeCount = nodeCount;
        adjList = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int fromNode, int toNode, int cost) {
        adjList.get(fromNode).add(new GraphNode(toNode, cost));
    }
}
