package org.baekjoon;

import java.util.*;

public class BKJ7562 { // 나이트의 이동
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            test();
        }
    }

    public static void test() {
        int size = sc.nextInt();
        int[][] board = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();
        board[targetX][targetY] = 1;

        while (!queue.isEmpty()) {
            int[] here = queue.poll();
            if (here[0] < 0 || here[1] < 0 || here[0] >= size || here[1] >= size) { continue; }
            if (visited[here[0]][here[1]]) { continue; }
            visited[here[0]][here[1]] = true;
            if (board[here[0]][here[1]] == 1) {
                System.out.println(here[2]);
                return;
            }
            queue.offer(new int[]{here[0]+2, here[1]+1, here[2]+1});
            queue.offer(new int[]{here[0]+2, here[1]-1, here[2]+1});
            queue.offer(new int[]{here[0]-2, here[1]+1, here[2]+1});
            queue.offer(new int[]{here[0]-2, here[1]-1, here[2]+1});
            queue.offer(new int[]{here[0]+1, here[1]+2, here[2]+1});
            queue.offer(new int[]{here[0]+1, here[1]-2, here[2]+1});
            queue.offer(new int[]{here[0]-1, here[1]+2, here[2]+1});
            queue.offer(new int[]{here[0]-1, here[1]-2, here[2]+1});
        }
    }
}
