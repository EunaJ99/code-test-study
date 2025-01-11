package org.baekjoon;

import java.util.*;

public class BKJ1012 { // 유기농 배추
    static Scanner sc;
    static BKJ1012 mn = new BKJ1012();
    static int[][] field;
    static boolean[][] visited;
    static int m;
    static int n;
    static int k;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; i++) {
            mn.test();
        }
    }

    void test() {
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        field = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            field[first][second] = 1;
        }
        int answer = 0;
        while (k > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int correction = BFS(i, j);
                        k -= correction;
                        if (correction > 0) { answer++; }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    int BFS(int i, int j) {
        if (i < 0 || j < 0 || i >= field.length || j >= field[0].length) { return 0; }
        if (visited[i][j] || field[i][j] == 0) { return 0; }
        visited[i][j] = true;
        return BFS(i, j+1) + BFS(i+1, j) + BFS(i-1, j) + BFS(i, j-1) + 1;
    }
}