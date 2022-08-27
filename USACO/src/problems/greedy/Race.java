package problems.greedy;

public class Race {
    public static void main(String[] args) {
        int N = 10; int k = 5;
        int[] nums = new int[]{1,2,3,4,5};
        for (int i=0; i<nums.length; i++){
            shortestTime(N, nums[i]);
        }
    }

    private static void shortestTime(int length, int limit){
        int currSpeed = 0;
        int currLength = 0;
        int time = 0;
//        while(currLength < length){
//            int temp = maxNextSpeed()
//        }
    }
}
