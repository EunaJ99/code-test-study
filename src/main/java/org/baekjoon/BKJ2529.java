package org.baekjoon;

import java.util.*;

public class BKJ2529 { // 부등호
    static int k;
    static char[] ineq;
    static ArrayList<String> num = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        ineq = new char[k];
        for (int i = 0; i < k; i++) {
            ineq[i] = sc.next().charAt(0);
        }

        DFS(0, "");
        System.out.println(num.get(num.size()-1));
        System.out.println(num.get(0));
    }

    static void DFS(int count, String here) {
        if (count == k+1) {
            num.add(here);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) { continue; }
            if (count == 0 || check(ineq[count-1], Character.getNumericValue(here.charAt(here.length() - 1)), i)) {
                visited[i] = true;
                DFS(count+1, here+i);
                visited[i] = false;
            }
        }
    }

    static boolean check(char c, int i, int j) {
        if (c == '<' && i < j) { return true; }
        if (c == '>' && i > j) { return true; }
        return false;
    }
}
