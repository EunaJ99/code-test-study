package org.baekjoon;

import java.util.*;

public class BKJ11399 { // ATM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer += p[i];
                continue;
            }
            p[i] += p[i-1];
            answer += p[i];
        }
        System.out.println(answer);
    }
}
