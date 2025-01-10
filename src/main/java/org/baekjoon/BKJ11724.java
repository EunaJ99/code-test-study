package org.baekjoon;

import java.util.*;

public class BKJ11724 {
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) {
        BKJ11724 m = new BKJ11724();
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int answer = 0;
        graph = new int[nodeCount+1][nodeCount+1];
        visited = new boolean[nodeCount+1];
        for (int i = 0; i < edgeCount; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            graph[firstNode][secondNode] = 1;
            graph[secondNode][firstNode] = 1;
        }

        for (int n = 1; n <= nodeCount; n++) {
            if (!visited[n]) {
                m.DFS(n);
                answer++; }
        }

        System.out.println(answer);
    }

    void DFS(int n) {
        if (visited[n]) { return; }
        visited[n] = true;
        for (int i = 0; i < visited.length; i++) {
            if (graph[n][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
}
