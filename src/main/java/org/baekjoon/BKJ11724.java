package org.baekjoon;

import java.util.*;

public class BKJ11724 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        BKJ11724 m = new BKJ11724();
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int answer = 0;
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[nodeCount+1];
        for (int i = 0; i < edgeCount; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for (int n = 1; n <= nodeCount; n++) {
            if (visited[n]) { continue; }
            m.DFS(n);
            answer++;
        }

        System.out.println(answer);
    }

    void DFS(int n) {
        visited[n] = true;
        for (int j: graph.get(n)) {
            if (visited[j]) { continue; }
            DFS(j);
        }
    }
}
