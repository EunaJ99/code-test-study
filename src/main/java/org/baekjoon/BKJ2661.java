package org.baekjoon;

import java.util.*;

public class BKJ2661 { // 좋은 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(0, "", n);

    }

    static void dfs(int index, String num, int n) {
        if (index == n) {
            System.out.println(num);
            System.exit(0);
        }
        for (int i = 1; i < 4; i++) {
            if (check(num+i)) {
                dfs(index+1, num+i, n);
            }
        }
    }

    static Boolean check(String num) {
        int half = num.length() / 2;
        for (int i = 1; i <= half; i++) {
            if (num.substring(num.length() - i).equals(num.substring(num.length() - 2*i, num.length() - i))) { return false; }
        }
        return true;
    }
}
