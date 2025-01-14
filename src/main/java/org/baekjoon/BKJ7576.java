package org.baekjoon;

import java.util.*;

public class BKJ7576 { // 토마토
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] correctX = {0, 0, +1, -1};
        int[] correctY = {+1, -1, 0, 0};
        int tomatoes = m*n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    int[] startP = {i, j};
                    queue.offer(startP);
                }
                if (grid[i][j] == -1) { tomatoes--; }
            }
        }

        if (tomatoes == queue.size()) {
            System.out.println(0);
            System.exit(0);
        }

        int answer = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infection = false;
            for (int i = 0; i < size; i++) {
                int[] here = queue.poll();
                if (here[0] < 0 || here[1] < 0 || here[0] >= n || here[1] >= m) { continue; }
                if (visited[here[0]][here[1]]) { continue; }
                visited[here[0]][here[1]] = true;
                if (grid[here[0]][here[1]] < 0) { continue; }
                grid[here[0]][here[1]] = 1;
                infection = true;
                for (int j = 0; j < 4; j++) {
                    int[] next = {here[0] + correctX[j], here[1] + correctY[j]};
                    if (next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= m) { continue; }
                    if (visited[next[0]][next[1]]) { continue; }
                    queue.offer(next);
                }
            }
            if (!infection) { break; }
            answer++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(answer);
    }
}
