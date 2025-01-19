package org.baekjoon;

import java.util.*;

public class BKJ3649 { // 로봇 프로젝트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            while (sc.hasNext()) {
                int x = sc.nextInt();
                x *= 10000000;
                int n = sc.nextInt();
                int[] legos = new int[n];
                String ans = "";

                for (int i = 0; i < n; i++) {
                    legos[i] = sc.nextInt();
                }
                Arrays.sort(legos);
                int fin = 0;
                for (int i = 0; i < n; i++) {
                    int rest = x - legos[i];
                    int left = i + 1;
                    int right = n - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (legos[mid] < rest) left = mid + 1;
                        else if (legos[mid] > rest) right = mid - 1;
                        else {
                            fin = 1;
                            ans = "yes " + legos[i] + " " + rest;
                            break;
                        }
                    }
                    if (fin == 1) break;
                }
                if (fin == 1) {
                    System.out.println(ans);
                } else System.out.println("danger");
            }
        }
    }
} // 재공부 필요