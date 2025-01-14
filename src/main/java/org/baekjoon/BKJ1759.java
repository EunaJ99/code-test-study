package org.baekjoon;

import java.util.*;

public class BKJ1759 { // 암호 만들기
    static char[] alphabet;
    static int l;
    static int c;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        alphabet = new char[c];
        visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            alphabet[i] = sc.next().charAt(0);
        }
        Arrays.sort(alphabet);
        DFS(0, 0);
    }

    static void DFS(int start, int count) {
        if (count == l) {
            String word = "";
            int a = 0;
            int b = 0;
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    word += alphabet[i];
                    if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i' || alphabet[i] == 'o' || alphabet[i] == 'u') { a++; }
                    else { b++; }
                }
            }
            if (a >= 1 && b >= 2) { System.out.println(word); }
        }
        for (int i = start; i < c; i++) {
            visited[i] = true;
            DFS(i+1, count+1);
            visited[i] = false;
        }
    }
}
