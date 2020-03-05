package com.nal.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 25/02/20.
 * Given a 2d array with size n*m, there's some obstacles placed at some points. A frog trying to jump from the
 * beginning point 0,0 to the bottom right point n-1, m-1. Say if a frog can jump maximum k distance a time,
 * what is the minimum steps needed?
 * Note: the frog can only jump horizontally or vertically, it can't jump diagonally. Obstacles are represented by -1.
 * eg:
 * [0,0,-1,0,0,0,
 * -1,0,0,0,-1,0], maximum step k = 2
 */
public class FrogJump {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, -1, 0, 0, 0}, {-1, 0, 0, 0, -1, 0}};
        int k = 2;
        FrogJump frogJump = new FrogJump();
        int minJump = frogJump.getMinJump(matrix, k);
        System.out.println(minJump);
    }

    private int getMinJump(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0)
            return -1;

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[rows + 1][cols + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.poll();
                if (cell[0] == rows && cell[1] == cols)
                    return res;
                for (int[] dir : dirs) {
                    for (int j = 1; j <= k; j++) {
                        int r = cell[0] + j * dir[0];
                        int c = cell[1] + j * dir[1];
                        if (r < 0 || c < 0 || r > rows || c > cols || visited[r][c])
                            continue;
                        if(matrix[r][c] == -1)
                            break;
                        visited[r][c] = true;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
