package org.baekjoon;

import java.util.*;

public class BKJ1449 { // 수리공 항승
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] leak = new int[n];
        for (int i = 0; i < n; i++) {
            leak[i] = sc.nextInt();
        }
        Arrays.sort(leak);
        double end = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (leak[i] + 0.5 <= end) { continue; }
            answer++;
            end = leak[i] - 0.5 + l;
        }
        System.out.println(answer);
    }
}
