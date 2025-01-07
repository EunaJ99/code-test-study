package org.baekjoon;

import java.util.*;

public class BKJ2816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] channels = new String[n];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            channels[i] = sc.nextLine();
        } // 입력완료

        int kbs1 = 0;
        int kbs2 = 0;

        for (int i = 0; i < n; i++) {
            if (channels[i].equals("KBS1")) { kbs1 = i; }
            if (channels[i].equals("KBS2")) { kbs2 = i; }
        }

        if (kbs1 > kbs2) { kbs2++; }

        for (int i = 0; i < kbs1; i++) {
            answer.append("1");
        }
        for (int i = 0; i < kbs1; i++) {
            answer.append("4");
        }
        for (int i = 0; i < kbs2; i++) {
            answer.append("1");
        }
        for (int i = 1; i < kbs2; i++) {
            answer.append("4");
        }

        System.out.println(answer);
    }
}
