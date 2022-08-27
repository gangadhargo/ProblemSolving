public class TickTockToe {
    int[][] board;
    int[] rSum;
    int[] cSum;
    int dSum, rdSum;
    int n;
    int winner;
    public TickTockToe(int n){
        this.n = n;
        board = new int[n][n];
        rSum = new int[n];
        cSum = new int[n];
    }

    public int move(int player, int r, int c){
        player = player == 0 ? -1 : 1;
        board[r][c] = player;
        rSum[r] += player;
        cSum[c] += player;
        if(r == c) {
            dSum+= player;
        }
        if(r == n -1 -c){
            rdSum+= player;
        }
        if(rSum[player] == Math.abs(n) || cSum[player] == Math.abs(n) || dSum == Math.abs(n) || rdSum == Math.abs(n)){
            winner =  player;
        }
        return winner;
    }
}
