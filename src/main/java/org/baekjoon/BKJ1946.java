package org.baekjoon;

import java.io.*;
import java.util.*;

public class BKJ1946 { // 신입사원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                score[j][0] = Integer.parseInt(str[0]);
                score[j][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(score, (a, b) -> {
                return a[0] - b[0];
            });

            int cut = score[0][1];
            int answer = 1;
            for (int j = 1; j < n; j++) {
                if (cut < score[j][1]) { continue; }
                answer++;
                cut = score[j][1];
            }

            System.out.println(answer);
        }
    }
}
