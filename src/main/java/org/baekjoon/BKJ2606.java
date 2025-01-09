package org.baekjoon;

import java.util.*;

public class BKJ2606 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        BKJ2606 m = new BKJ2606();
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        visited = new boolean[nodeCount + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        m.DFS(1);
        int answer = 0;
        for (boolean infected : visited) {
            if (infected) { answer++; }
        }

        System.out.println(answer - 1);
    }

    void DFS(int n) {
        visited[n] = true;
        ArrayList<Integer> temp = graph.get(n);
        for (int i : temp) {
            if (visited[i]) { continue; }
            DFS(i);
        }
    }
}
