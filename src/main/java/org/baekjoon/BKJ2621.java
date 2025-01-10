package org.baekjoon;

import java.util.*;

public class BKJ2621 { // 카드게임
    public static boolean isColorSame(char[] color) {
        for (int i = 1; i < 5; i++) {
            if (color[i] != color[i-1]) { return false; }
        }
        return true;
    }

    public static boolean isNumberInRow(char[] number) {
        for (int i = 1; i < 5; i++) {
            if (number[i] != number[i-1] + 1) { return false; }
        }
        return true;
    }

    public static int[] isPartialSame(char[] number) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] result = {0, 0};
        boolean twoPair = false;
        boolean threePair = false;
        for (char n : number) { map.merge(n, 1, Integer::sum); }
        for (char k : map.keySet()) {
            if (map.get(k) == 4) {
                result[0] = Character.getNumericValue(k);
                result[1] = 8;
                return result;
            }
            if (map.get(k) == 3) {
                threePair = true;
                result[0] = Character.getNumericValue(k);
                if (twoPair) {
                    result[1] = 7;
                    return result;
                }
            }
            if (map.get(k) == 2) {
                if (threePair) {
                    result[1] = 7;
                    return result;
                } else if (twoPair) { result[1] = 3; }
                twoPair = true;
                result[0] = Math.max(Character.getNumericValue(k), result[0]);
            }
        }
        if (threePair) {
            result[1] = Math.max(4, result[1]);
        } else if (twoPair) {
            result[1] = Math.max(2, result[1]);
        } else {
            result[0] = Character.getNumericValue(number[4]);
            result[1] = Math.max(1, result[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        char[] number = new char[5];
        char[] color = new char[5];
        for (int i = 0; i < 5; i++) {
            input = sc.nextLine();
            number[i] = input.charAt(2);
            color[i] = input.charAt(0);
        }

        int score = 0;
        Arrays.sort(number);
        boolean numberRow = isNumberInRow(number);
        boolean colorSame = isColorSame(color);
        if (numberRow && colorSame) {
            score = 900 + Character.getNumericValue(number[4]);
        } else if (colorSame) {
            score = 600 + Character.getNumericValue(number[4]);
        } else if (numberRow) {
            score = 500 + Character.getNumericValue(number[4]);
        } else {
            int[] condition = isPartialSame(number);
            if (condition[1] == 2 || condition[1] == 4 || condition[0] == 8) {
                score = condition[0];
            } else if (condition[1] == 3) {
                score = condition[0] * 10 + Character.getNumericValue(number[1]);
            } else if (condition[1] == 7) {
                score = condition[0] * 10;
                int n = Character.getNumericValue(number[1]);
                if (condition[0] == n) { score += Character.getNumericValue(number[4]); }
                else { score += n; }
            } else { score += condition[0]; }
            score += condition[1] * 100;
        }

        System.out.println(score);
    }
}
