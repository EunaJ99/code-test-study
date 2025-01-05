package org.baekjoon;

import java.util.*;

public class BKJ1747 {
    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalind(int n) {
        String k = Integer.toString(n);
        int cnt = k.length();
        for (int i = 0; i <= cnt / 2; i++) {
            if (k.charAt(i) != k.charAt(cnt -i -1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1){
            System.out.println(2);
            System.exit(0);
        }
        for (int i = n; ; i++){
            if (isPalind(i) && isPrime(i)){
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}