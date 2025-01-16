package org.baekjoon;

import java.util.*;

public class BKJ1700 { // 멀티탭 스케줄링
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> sequence = new ArrayList<>();
        ArrayList<Integer> multiTab = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sequence.add(sc.nextInt());
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            int cord = sequence.get(i);
            if (multiTab.contains(cord)) { continue; }
            if (multiTab.size() < n && multiTab.add(cord)) { continue; }
            int idx = -1, max = -1;
            for (int s : multiTab) {
                int tmp = 0;
                List<Integer> sub = sequence.subList(i+1, k);
                if (!sub.contains(s)) {
                    idx = s;
                    break;
                } else {
                    tmp = sub.indexOf(s);
                    if (tmp > max) {
                        max = tmp;
                        idx = s;
                    }
                }
            }
            multiTab.remove((Integer) idx);
            multiTab.add(cord);
            answer++;
        }

        System.out.println(answer);
    }
}
