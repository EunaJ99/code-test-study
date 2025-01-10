package org.baekjoon;

import java.util.*;

public class BKJ2606 { // 바이러스
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) {
        BKJ2606 m = new BKJ2606();
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        visited = new boolean[nodeCount + 1];
        graph = new int[nodeCount+1][nodeCount+1];

        for (int i = 0; i < edgeCount; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            graph[firstNode][secondNode] = 1;
            graph[secondNode][firstNode] = 1;
        }

        m.DFS(1);
        int answer = 0;
        for (boolean infected : visited) {
            if (infected) { answer++; }
        }

        System.out.println(answer - 1);
    }

    void DFS(int n) {
        if (visited[n]) { return; }
        visited[n] = true;
        for (int i = 1; i < visited.length; i++) {
            if (graph[n][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
}
