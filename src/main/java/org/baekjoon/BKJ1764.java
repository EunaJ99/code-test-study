package org.baekjoon;

import java.util.*;

public class BKJ1764 { // 듣보잡
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int notHeard = sc.nextInt();
        int notSeen = sc.nextInt();
        HashSet<String> check = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < notHeard; i++) {
            check.add(sc.next());
        }
        for (int i = 0; i < notSeen; i++) {
            String tmp = sc.next();
            if (check.contains(tmp)) { answer.add(tmp); }
        }

        answer.sort(Comparator.naturalOrder());

        System.out.println(answer.size());
        for (String i : answer) {
            System.out.println(i);
        }
    }
}
