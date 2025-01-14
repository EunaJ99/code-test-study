package org.baekjoon;

import java.util.*;

public class BKJ2178 { // 미로 탐색
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] answer = new int[3];

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] here = queue.poll();
            if (here[0] < 0 || here[1] < 0 || here[0] >= n || here[1] >= m) { continue; }
            if (visited[here[0]][here[1]]) { continue; }
            if (map[here[0]][here[1]] == 0) { continue; }
            if (here[0] == n-1 && here[1] == m-1) {
                answer = here;
                break;
            }
            visited[here[0]][here[1]] = true;
            queue.offer(new int[]{here[0]+1, here[1], here[2]+1});
            queue.offer(new int[]{here[0]-1, here[1], here[2]+1});
            queue.offer(new int[]{here[0], here[1]+1, here[2]+1});
            queue.offer(new int[]{here[0], here[1]-1, here[2]+1});
        }

        System.out.println(answer[2]);
    }
}
