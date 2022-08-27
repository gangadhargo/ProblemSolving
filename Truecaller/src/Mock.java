import java.util.ArrayList;
import java.util.Arrays;

public class Mock {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(intervals[0]);
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            int[] oldInterval = list.get(list.size()-1);
            int[] newInterval = intervals[i];
            if(newInterval[0] < oldInterval[1]){
                list.remove(list.size()-1);
                count++;
                if(newInterval[1] < oldInterval[1]){
                    list.add(newInterval);
                }else{
                    list.add(oldInterval);
                }
            }else{
                list.add(newInterval);
            }
        }
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)[0]+","+list.get(i)[1]);
            System.out.println("----------------------");
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[5][5];
        intervals[0][0] = 0;
        intervals[0][1] = 2;
        intervals[1][0] = 1;
        intervals[1][1] = 3;
        intervals[2][0] = 2;
        intervals[2][1] = 4;
        intervals[3][0] = 3;
        intervals[3][1] = 5;
        intervals[4][0] = 4;
        intervals[4][1] = 6;
        eraseOverlapIntervals(intervals);
    }
}
