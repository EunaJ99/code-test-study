package org.baekjoon;

import java.util.*;

public class BKJ1697 { // 숨바꼭질

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<int[]> queue = new LinkedList<>();
        int ind = Math.max(n, k);
        boolean[] visited = new boolean[ind+2];

        int[] start = {n, 0};
        queue.offer(start);
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] i = queue.poll();
            if (i[0] > ind+1 || i[0] < 0 || visited[i[0]]) { continue; }
            visited[i[0]] = true;
            if (i[0] == k) {
                answer = i[1];
                queue.clear();
                break;
            }
            int[] plus = {i[0]+1, i[1]+1};
            int[] minus = {i[0]-1, i[1]+1};
            int[] multiply = {i[0]*2, i[1]+1};
            queue.offer(plus);
            queue.offer(minus);
            queue.offer(multiply);
        }

        System.out.println(answer);
    }
}
