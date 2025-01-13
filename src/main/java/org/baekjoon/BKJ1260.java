package org.baekjoon;

import java.util.*;

public class BKJ1260 { // DFS와 BFS
    static int[][] graph;
    static boolean[] visited;
    static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        v = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        DFS(v);
        System.out.println();
        BFS(v, n);
    }

    public static void DFS(int n) {
        if (visited[n]) { return; }
        visited[n] = true;
        System.out.print(n + " ");
        for (int i = 0; i < visited.length; i++) {
            if (graph[n][i] != 0) {
                DFS(i);
            }
        }
    }

    public static void BFS(int n, int count) {
        visited = new boolean[count+1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (graph[v][i] != 0) {
                int[] tmp = { v, i };
                queue.offer(tmp);
            }
        } // 큐 세팅

        System.out.print(v + " ");
        visited[v] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int destination = tmp[1];
            if (visited[destination]) { continue; }
            visited[destination] = true;
            System.out.print(destination + " ");
            for (int i = 0; i < visited.length; i++) {
                if (graph[destination][i] != 0 && !visited[i]) {
                    int[] offer = {destination, i};
                    queue.offer(offer);
                }
            }
        }
    }
}
