package topcoder.dp;

public class BadNeighbors {
    public static int wateringPlants(int[] plants, int capacity) {
        int localCapcity = capacity;
        int steps = 0;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] < localCapcity) {
                //System.out.println(localCapcity);
                localCapcity -= plants[i];
                steps++;
            } else {
                //System.out.println(i);
                steps += i;
                localCapcity = capacity;
                steps += i;
                localCapcity -= plants[i];
                steps ++;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,4,2,3 };
        System.out.println(wateringPlants(arr, 5));
//        int n = arr.length;
//        int[] dp = new int[n+1];
//        dp[1] = arr[0];
//        for(int i=1; i<dp.length-1; i++){
//           dp[i+1] = Math.max(dp[i], dp[i-1] + arr[i]);
//        }
 //       System.out.println(dp[n]);
    }
}
