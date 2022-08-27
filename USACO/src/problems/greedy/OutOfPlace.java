package problems.greedy;

import java.util.Arrays;

public class OutOfPlace {
    public static void main(String[] args) {
        int[] input = new int[]{6 ,2 ,4 ,7 ,7 ,9 ,3};
        int[] sort = new int[input.length];
        for (int i= 0; i<input.length; i++){
            sort[i] = input[i];
        }
        Arrays.sort(sort);
        int count = 0;
        for (int i= 0; i<input.length; i++){
            if(input[i]!= sort[i]){
                count++;
            }
        }
        System.out.println(count-1);
    }
}
