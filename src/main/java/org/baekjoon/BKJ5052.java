package org.baekjoon;

import java.io.*;
import java.util.*;

public class BKJ5052 { // 전화번호 목록=
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) { check(); }
    }

    static void check() throws IOException {
        int n = Integer.parseInt(bf.readLine());
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = bf.readLine();
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n-1; i++) {
            if (numbers[i+1].startsWith(numbers[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
