package org.baekjoon;

import java.util.*;

public class BKJ2579 { // 계단 오르기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        dp[1] = stairs[1];
        if (n >= 2) { dp[2] = stairs[1] + stairs[2]; }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }
        System.out.println(dp[n]);
    }

}
