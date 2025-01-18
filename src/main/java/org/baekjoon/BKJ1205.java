package org.baekjoon;

import java.util.*;

public class BKJ1205 { // 등수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tScore = sc.nextInt();
        int p = sc.nextInt();

        ArrayList<Integer> board = new ArrayList<>();

        if (n == 0) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            board.add(sc.nextInt());
        }

        board.sort(Collections.reverseOrder());

        if (board.size() == p) {
            if (board.getLast() >= tScore) {
                System.out.println(-1);
                System.exit(0);
            }
            board.removeLast();
            board.add(tScore);
        } else { board.add(tScore); }

        board.sort(Collections.reverseOrder());
        int answer = 0;
        for (Integer integer : board) {
            answer++;
            if (integer == tScore) {
                break;
            }
        }

        System.out.println(answer);
    }
}
