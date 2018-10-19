/**
 * @Auther: Think
 * @Date: 2018/10/16 16:02
 * @Description:
 * 数独游戏，纵横每列都含有1-9 9个数，并且不能重复
 * 回溯法：从一条路往前走，能进则进，不能进后退
 * 遍历每一行，每一列，只要是‘.’的都尝试填入1-9，注意判断是否为空的条件
 * 首先判断行，然后判断列，判断每个小block是否都合法
 */
public class leetcode37_Sudoku {
   public void solveSudoku(char[][] board){
       if (board == null || board.length == 0) {
           return ;
       }
       helper(board);
   }

    private boolean helper(char[][] board) {
        for (int i = 0;i<board.length;i++){ //行
            for (int j = 0;j<board[0].length;j++){  //列
                if (board[i][j] == '.') {  //如果是.的话，从1到9开始试
                    for (char num = '1';num<='9';num++){
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;   //或判断合法，填数，这时候矩阵的状态发生变化，可以进行递归了
                            if (helper(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false; //全都放过之后还是没有正确的
                }
            }
        }
        return true; //全都遍历完之后找不到'.'说明正确
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int row = 0;row<9;row++){
            if (board[row][j]==c){
                return false; //遍历行是否合法
            }
        }
        for (int col = 0;col<9;col++){
            if (board[i][col]==c){
                return false; //遍历列是否合法
            }
        }
        for (int row = i/3*3;row<i/3*3+3;row++){
            //小的block是否合法
            for (int col = j/3*3;col<j/3*3+3;col++){
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
