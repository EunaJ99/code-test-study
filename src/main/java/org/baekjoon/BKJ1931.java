package org.baekjoon;

import java.util.*;

public class BKJ1931 { // 회의실 배정
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] conference = new int[size][2];
        for (int i = 0; i < size; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            conference[i][0] = end;
            conference[i][1] = start;
        }

        Arrays.sort(conference, (o1, o2) -> o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);

        int endings = -1;
        int answer = 0;

        for (int i = 0; i < size; i++) {
            if (conference[i][1] >= endings) {
                answer++;
                endings = conference[i][0];
            }
        }

        System.out.println(answer);
    }
}
