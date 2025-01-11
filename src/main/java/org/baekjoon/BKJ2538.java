package org.baekjoon;

import java.util.*;

public class BKJ2538 { // 영역 구하기
    static int n;
    static int m;
    static int k;
    static int[][] table;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        table = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            int lowX = sc.nextInt();
            int lowY = sc.nextInt();
            int highX = sc.nextInt();
            int highY = sc.nextInt();

            for (int j = lowX; j < highX; j++) {
                for (int l = lowY; l < highY; l++) {
                    table[j][l] = 1;
                }
            }
        }

        ArrayList<Integer> areas = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && table[i][j] == 0) {
                    areas.add(BFS(i, j));
                    answer++;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(areas);
        for (Integer area : areas) {
            System.out.print(area + " ");
        }
    }

    public static int BFS(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) { return 0; }
        if (visited[i][j] || table[i][j] == 1) { return 0; }
        visited[i][j] = true;
        return BFS(i-1, j) + BFS(i, j-1) + BFS(i+1, j) + BFS(i, j+1) + 1;
    }
}
