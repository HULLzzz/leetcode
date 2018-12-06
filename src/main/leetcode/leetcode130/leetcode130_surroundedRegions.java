/**
 * @Auther: Think
 * @Date: 2018/11/28 16:29
 * @Description:
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 像围棋一样，去掉被包围的O
 */
public class leetcode130_surroundedRegions {
    public void solution(char[][] board){
        if (board.length==0) return;
        int row = board.length;
        int col = board[0].length;

        for (int i = 0;i<row;i++){
            if (board[i][0] == 'O')
                dfs(board,i,col-1);
            if (board[i][col-1] == 'O')
                dfs(board,i,col-1);
        }
        for (int i = 1;i<col-1;i++){
            if (board[0][i]=='O')
                dfs(board,0,i);
            if (board[row-1][i] == 'O')
                dfs(board,row-1,i);
        }

        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    //只有在外圈为O，紧挨着这个外圈O的字符
    private void dfs(char[][] board, int m, int n) {
        if (board[m][n]!='O'){
            return;
        }
        board[m][n] = '1';
        if (m<board.length-2)
            dfs(board,m+1,n);
        if (m > 1) {
            dfs(board,m-1,n);
        }
        if (n<board[0].length-2){
            dfs(board,m,n+1);
        }
        if (n > 1) {
            dfs(board,m,n-1);
        }
    }


}
