package problems.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinProblem {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5,10,20,50,100,200};
        int target = 93;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(coins);
        for (int i=coins.length-1; i>=0; i--){
            while(coins[i] <= target){
                target -=coins[i];
                list.add(coins[i]);
            }
        }
        System.out.println(list);
    }
}
