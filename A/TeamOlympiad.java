package com.practice.A;

import java.util.*;

public class TeamOlympiad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] == 1) {
                ArrayList<Integer> list = map.get(1);
                list.add(i + 1);
                map.put(1, list);
            }
            if (arr[i] == 2) {
                ArrayList<Integer> list = map.get(2);
                list.add(i + 1);
                map.put(2, list);
            }
            if (arr[i] == 3) {
                ArrayList<Integer> list = map.get(3);
                list.add(i + 1);
                map.put(3, list);
            }
        }
        int count = 0;
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(1).size() == 0 || map.get(2).size() == 0 || map.get(3).size() == 0) {
                break;
            }
            output.add(map.get(1).get(0));
            map.get(1).remove(0);
            output.add(map.get(2).get(0));
            map.get(2).remove(0);
            output.add(map.get(3).get(0));
            map.get(3).remove(0);
            count++;
        }
        System.out.println(count);
        if(count>0){
            for(int i=0; i<count;i++){
                System.out.println(output.get(0)+" "+output.get(1)+" "+output.get(2));
                output.remove(0);
                output.remove(0);
                output.remove(0);
            }
        }
    }
}
