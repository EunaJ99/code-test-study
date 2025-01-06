package org.baekjoon;

import java.util.*;

public class BKJ1652 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int x = 0;
        int y = 0;
        char[][] room = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (room[i][j] == '.' && room[i][j-1] == room[i][j]) {
                    x++;
                    while (j < n && room[i][j] == '.') { j++; }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (room[j][i] == '.' && room[j-1][i] == room[j][i]) {
                    y++;
                    while (j < n && room[j][i] == '.') { j++; }
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
