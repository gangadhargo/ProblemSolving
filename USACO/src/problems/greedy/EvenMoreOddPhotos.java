package problems.greedy;

import java.util.ArrayList;

public class EvenMoreOddPhotos {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 13};
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                even.add(arr[i]);
            }else{
                odd.add(arr[i]);
            }
        }
        int evenSize = even.size();
        int oddSize = odd.size();
        int answer = 1;
        if(oddSize == 0){
            System.out.println(answer);
        }else{
            if(evenSize > oddSize){
                System.out.println(oddSize*2 + 1);
            }
            if(oddSize > evenSize){
                answer = evenSize * 2;
                oddSize = oddSize - evenSize;
                if(oddSize % 3 == 0){
                    answer = answer + (oddSize/3)*2;
                    System.out.println(answer);
                }else if(oddSize % 3 == 1){
                    answer = answer + (oddSize - 1)/3 * 2;
                    answer = answer  - 1;
                    System.out.println(answer);
                }else{
                    answer = answer + (oddSize - 2)/3 * 2;
                    System.out.println(answer+1);
                }
            }
        }
    }
}
