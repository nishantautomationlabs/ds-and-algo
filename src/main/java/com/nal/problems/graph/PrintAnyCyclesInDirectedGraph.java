package com.nal.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 28/02/20.
 * Time Complexity O(V + E)
 */
public class PrintAnyCyclesInDirectedGraph {
    public static final int WHITE = 0;
    public static final int GREY = 1;
    public static final int BLACK = 2;

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 7);
        graph.addDirectedEdge(3, 1);
        PrintAnyCyclesInDirectedGraph cycleInDirectedGraph = new PrintAnyCyclesInDirectedGraph();

        List<Integer>  result = new ArrayList<>();
        cycleInDirectedGraph.getAllCycles(graph, result);
        result.stream().forEach(s -> System.out.print(s));
        System.out.println();
    }

    private void getAllCycles(Graph graph, List<Integer> result) {
        int[] color = new int[graph.nodeCount];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.nodeCount; i++) {
            if (color[i] == WHITE) {
                stack.clear();
                detectCycleDFS(graph, i, color, result, stack);
            }
        }
    }

    private boolean detectCycleDFS(Graph graph, int node, int[] color, List<Integer> result, Stack<Integer> stack) {
        color[node] = GREY;
        stack.add(node);
        for (Integer child : graph.adjList.get(node)) {
            if (color[child] == GREY) {
                Stack<Integer> temp = (Stack<Integer>)stack.clone();
                while (!temp.isEmpty() && temp.peek() != child) {
                    result.add(temp.pop());
                }
                result.add(child);
                return true;
            }
            if (color[child] == WHITE) {
                if(detectCycleDFS(graph, child, color, result, stack))
                    return true;
            }
        }
        stack.remove(stack.size()-1);
        color[node] = BLACK;
        return false;
    }

}
