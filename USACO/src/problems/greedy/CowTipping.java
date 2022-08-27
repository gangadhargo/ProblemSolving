package problems.greedy;

public class CowTipping {
    public static void main(String[] args) {
        char[][] a = new char[3][3];
        a[0][0] = '0';
        a[0][1] = '0';
        a[0][2] = '1';
        a[1][0] = '1';
        a[1][1] = '1';
        a[1][2] = '1';
        a[2][0] = '1';
        a[2][1] = '1';
        a[2][2] = '1';

        int tips = 0;
        for(int i=2; i>=0; i--){
            for(int j=2; j>=0; j--){
                if(a[i][j] == '1'){
                    tips++;
                    for(int k=i; k>=0; k--){
                        for(int l=j; l>=0; l--){
                            if(a[k][l] == '1'){
                                a[k][l] = '0';
                            }else{
                                a[k][l] = '1';
                            }
                        }
                    }
                }
            }
        }
        System.out.println(tips);
    }
}
