package Problems;

import java.util.ArrayList;
import java.util.List;

public class Program4 {

    public static void main(String[] args){
        printArrayList();
    }


    public static void printArrayList(){
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");

        System.out.println(myList.toString()); // Print Value at this step : ["A", "B"]

        modifyA(myList);
        System.out.println(myList.toString()); // Print Value at this step : ["A", "B", "C"]

        modifyB(myList);
        System.out.println(myList.toString()); // Print Value at this step : null pointer expection

        modifyC(myList);
        System.out.println(myList.toString()); // Print Value at this step :
    }

    private static void modifyA(List<String> myList){
        myList.add("C");
    }

    private static void modifyB(List<String> myList){
        myList = null;
    }

    private static void modifyC(List<String> myList){
        myList.clear(); // null pointer expection
    }
}
