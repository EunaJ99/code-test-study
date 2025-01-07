package org.baekjoon;

import java.util.*;

public class BKJ8976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();

        HashMap<Integer, Integer> gold = new HashMap<Integer, Integer>(count);
        HashMap<Integer, Integer> silver = new HashMap<Integer, Integer>(count);
        HashMap<Integer, Integer> bronze = new HashMap<Integer, Integer>(count);

        for (int i = 0; i < count; i++) {
            int key = sc.nextInt();
            int goldnum = sc.nextInt();
            int silvernum = sc.nextInt();
            int bronzenum = sc.nextInt();
            gold.put(key, goldnum);
            silver.put(key, silvernum);
            bronze.put(key, bronzenum);
            sc.nextLine();
        }

        int targetG = gold.get(target);
        int targetS = silver.get(target);
        int targetB = bronze.get(target);

        int answer = 1;

        for (int i = 1; i <= count; i++) {
            if (gold.get(i) > targetG) { answer++; }
            if (gold.get(i) == targetG && silver.get(i) > targetS) { answer++; }
            if (gold.get(i) == targetG && silver.get(i) == targetS && bronze.get(i) > targetB) { answer++; }
        }
        System.out.println(answer);
    }
}
