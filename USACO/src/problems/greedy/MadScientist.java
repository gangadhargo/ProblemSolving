package problems.greedy;

public class MadScientist {

    public static void main(String[] args) {
        int n = 7;
        String s1 = "GHHHGHH";
        char[] a = s1.toCharArray();
        String s2 = "HHGGGHH";
        char[] b = s2.toCharArray();

        int count = 0;
        while(!new String(a).equals(new String(b))){
            count++;
            int lhs = 0;
            while(a[lhs] == b[lhs]) lhs++;
            System.out.println(lhs);
            int rhs = n-1;
            while(a[rhs] == b[rhs]) rhs--;
            for(int i = lhs; i<=rhs; i++){
                if(a[i] == 'G'){
                    a[i] = 'H';
                }else {
                    a[i] = 'G';
                }
            }
            System.out.println(rhs);
        }
        System.out.println(count);
    }
}
