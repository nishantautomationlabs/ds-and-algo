package com.nal.graph;

/**
 * Created by nishant on 05/03/20.
 * Given a set of cities and distance between every pair of cities, the problem is to find the shortest possible route that visits every city exactly once and returns back to the starting point.
 */
public class TravellingSalesmanProblem {

    public static void main(String[] args) {
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                        {10, 0, 35, 25},
                        {15, 35, 0, 30},
                        {20, 25, 30, 0}};

        boolean[] visited = new boolean[n];
        visited[0] = true;
        TravellingSalesmanProblem tsp = new TravellingSalesmanProblem();
        int minCost = tsp.getMinCost(graph, visited, 0, n, 1, 0, Integer.MAX_VALUE);
        System.out.println(minCost);

    }

    private int getMinCost(int[][] graph, boolean[] visited, int currPos, int vertexCount, int count, int currCost, int minCost) {
        if(count == vertexCount && graph[currPos][0] > 0) {
            minCost = Math.min(minCost, currCost + graph[currPos][0]);
            return minCost;
        }

        for(int i = 0; i < vertexCount; i++) {
            if(!visited[i] && graph[currPos][i] > 0) {
                visited[i] = true;
                minCost = getMinCost(graph, visited, i, vertexCount, count + 1, currCost + graph[currPos][i],  minCost);
                visited[i] = false;
            }
        }
        return minCost;
    }
}
