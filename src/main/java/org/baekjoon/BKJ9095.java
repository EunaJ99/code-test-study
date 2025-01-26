package org.baekjoon;

import java.util.*;

public class BKJ9095 { // 1, 2, 3 더하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int tmp = sc.nextInt();
            System.out.println(dp[tmp]);
        }
    }
}
