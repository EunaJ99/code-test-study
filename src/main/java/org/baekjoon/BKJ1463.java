package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BKJ1463 { // 1로 만들기
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        dfs(num, 0);
        System.out.println(answer);
    }

    static void dfs(int num, int count) {
        if (num == 1) {
            if (answer == 0) {
                answer = count;
                return;
            }
            answer = Math.min(count, answer);
            return;
        }
        if (count > answer && answer != 0) { return; }
        if (num % 3 == 0) { dfs(num/3, count+1); }
        if (num % 2 == 0) { dfs(num/2, count+1); }
        if (num - 1 > 0) { dfs(num-1, count+1); }
    }
}
