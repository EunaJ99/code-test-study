package org.baekjoon;

import java.util.*;

public class BKJ2309 { // 일곱 난쟁이

    public static void main(String[] args) {
        int[] dwarf = new int[9];
        int sum = 0;
        int a = 0, b = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
            sum += dwarf[i];
        }

        Arrays.sort(dwarf);
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (a != i && b != i) { System.out.println(dwarf[i]); }
        }
    }
}
