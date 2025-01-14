package org.baekjoon;

import java.util.*;

public class BKJ10819 { // 차이를 최대로
    static int n;
    static int[] arr;
    static int[] cal;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        cal = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(cal[i] - cal[i+1]);
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cal[depth] = arr[i];
                visited[i] = true;
                DFS(depth+1);
                visited[i] = false;
            }
        }
    }
}
