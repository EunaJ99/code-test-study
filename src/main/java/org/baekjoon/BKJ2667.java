package org.baekjoon;

import java.util.*;

public class BKJ2667 { // 단지번호붙이기
    static int[][] map;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        ArrayList<Integer> apt = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int size = BFS(i, j);
                    if (size != 0) {
                        answer++;
                        apt.add(size);
                    }
                }
            }
        }

        System.out.println(answer);
        Collections.sort(apt);
        for (Integer a : apt) { System.out.println(a); }
    }

    public static int BFS(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) { return 0; }
        if (visited[i][j]) { return 0; }
        visited[i][j] = true;
        if (map[i][j] == 0) { return 0; }
        return BFS( i+1, j) + BFS(i-1, j) + BFS(i, j+1) + BFS(i, j-1) + 1;
    }
}
