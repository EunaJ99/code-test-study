package org.baekjoon;

import java.util.*;

public class BKJ11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int[][] edgelist = new int[edgeCount][2];

        for (int i = 0; i < edgeCount; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            edgelist[i][0] = Math.max(firstNode, secondNode);
            edgelist[i][1] = Math.min(firstNode, secondNode);
        }

        Arrays.sort(edgelist, (Comparator.comparingInt(o -> o[0])));
        ArrayList<ArrayList<Integer>> component = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            if (component.isEmpty()) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edgelist[i][0]);
                tmp.add(edgelist[i][1]);
                component.add(tmp);
                //component.add(new ArrayList<>());
                //component.getLast().add(edgelist[i][0]);
                //component.getLast().add(edgelist[i][1]); 백준에서 이 코드를 사용할 경우 오류가 나는 것을 확인. 주석처리하고 대체 코드로 수정.
                continue;
            }
            boolean treated = false;
            for (ArrayList<Integer> tmp : component) {
                if (tmp.contains(edgelist[i][0]) && tmp.contains(edgelist[i][1])) {
                    treated = true;
                    break;
                }
                if (tmp.contains(edgelist[i][1]) && !tmp.contains(edgelist[i][0])) {
                    treated = true;
                    tmp.add(edgelist[i][0]);
                    break;
                }
                if (tmp.contains(edgelist[i][0]) && !tmp.contains(edgelist[i][1])) {
                    treated = true;
                    tmp.add(edgelist[i][1]);
                    break;
                }
            }
            if (!treated) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edgelist[i][0]);
                tmp.add(edgelist[i][1]);
                component.add(tmp);
//                component.add(new ArrayList<>());
//                component.getLast().add(edgelist[i][0]);
//                component.getLast().add(edgelist[i][1]);
            }
        }

        int answer = component.size();

        for (int i = 1; i <= nodeCount; i++) {
            boolean exist = false;
            for (ArrayList<Integer> tmp : component) {
                if (tmp.contains(i)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) { answer++; }
        }

        System.out.println(answer);
    }
}
