package org.baekjoon;

import java.util.*;

public class BKJ10026 { // 적록색약
    static char[][] grid;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp.charAt(j);
            }
        }

        int standardAns = 0;
        int blindAns = 0;

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    standardBFS(i, j, i, j);
                    standardAns++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    blindBFS(i, j, i, j);
                    blindAns++;
                }
            }
        }

        System.out.println(standardAns + " " + blindAns);
    }

    public static int standardBFS(int i, int j, int x, int y) {
        if (i < 0 || j < 0 || i >= n || j >= n) { return 0; }
        if (visited[i][j] || grid[x][y] != grid[i][j]) { return 0; }
        visited[i][j] = true;
        return standardBFS(i-1, j, i, j) + standardBFS(i, j-1, i, j) + standardBFS(i+1, j, i, j) + standardBFS(i, j+1, i, j) + 1;
    }

    public static int blindBFS(int i, int j, int x, int y) {
        if (i < 0 || j < 0 || i >= n || j >= n) { return 0; }
        if (visited[i][j]) { return 0; }
        if (grid[x][y] != 'B' && grid[i][j] == 'B') { return 0; }
        if (grid[x][y] == 'B' && grid[i][j] != 'B') { return 0; }
        visited[i][j] = true;
        return blindBFS(i-1, j, i, j) + blindBFS(i, j-1, i, j) + blindBFS(i+1, j, i, j) + blindBFS(i, j+1, i, j) + 1;
    }
}
