package org.baekjoon;

import java.util.*;

public class BKJ1987 { // 알파벳
    static int r;
    static int c;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;
    static HashSet<Character> alphabet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String tmp = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        DFS(0, 0, 1);
        System.out.println(answer);
    }

    static void DFS(int i, int j, int depth) {
        answer = Math.max(answer, depth);
        alphabet.add(board[i][j]);
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < r && y < c) {
                if (!alphabet.contains(board[x][y])) { DFS(x, y, depth+1); }
            }
        }
        alphabet.remove(board[i][j]);
    }
}
