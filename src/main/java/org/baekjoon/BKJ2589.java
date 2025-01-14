package org.baekjoon;

import java.util.*;

public class BKJ2589 { // 보물섬
    static int answer = 0;
    static int n;
    static int m;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                BFS(i, j);
            }
        }

        System.out.println(answer);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[n][m];
        while(!queue.isEmpty()) {
            int[] here = queue.poll();
            if (here[0] < 0 || here[1] < 0 || here[0] >= n || here[1] >= m) { continue; }
            if (visited[here[0]][here[1]]) { continue; }
            if (map[here[0]][here[1]] == 'W') { continue; }
            visited[here[0]][here[1]] = true;
            queue.offer(new int[]{here[0]+1, here[1], here[2]+1});
            queue.offer(new int[]{here[0]-1, here[1], here[2]+1});
            queue.offer(new int[]{here[0], here[1]+1, here[2]+1});
            queue.offer(new int[]{here[0], here[1]-1, here[2]+1});
            answer = Math.max(answer, here[2]);
        }
    }
}
