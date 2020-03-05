package com.nal.problems.graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nishant on 27/02/20.
 */
public class TopologicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addDirectedEdge(5, 2);
        graph.addDirectedEdge(5, 0);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);
        TopologicalSort sort = new TopologicalSort();
        sort.printTopologicalSortedOrder(graph);
    }

    private void printTopologicalSortedOrder(Graph graph) {
        boolean[] visited = new boolean[graph.nodeCount];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < graph.nodeCount; i++) {
            if(!visited[i])
                topologicalUtil(graph, i, visited, stack);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
            if(stack.size() > 0)
                System.out.print("--");
        }
        System.out.println();
    }

    private void topologicalUtil(Graph graph, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        Iterator<Integer> iterator = graph.adjList.get(node).iterator();
        while(iterator.hasNext()) {
            int child = iterator.next();
            if(!visited[child])
                topologicalUtil(graph, child, visited, stack);
        }
        stack.push(node);
    }

}
