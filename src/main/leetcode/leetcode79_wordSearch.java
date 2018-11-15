/**
 * @Auther: Think
 * @Date: 2018/11/2 20:52
 * @Description:
 * 代码参考：https://blog.csdn.net/happyaaaaaaaaaaa/article/details/50834335
 * 给定矩阵和字符串，判断字符串能否由矩阵中的相邻元素组成
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * 对每一点的每条路径进行深度遍历，遍历过程中一旦出现数组越界，该点已被访问，或者不匹配的情况都需要进行剪枝
 */
public class leetcode79_wordSearch {
    int[] dh = {0,1,0,-1};
    int[] dw = {1,0,-1,0}; //检索方向【右，下，左，上】
    public boolean exits(char[][] board,String word){
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0;i<board.length;i++){
            for (int j = 0;i<board[0].length;j++){
                if (isThisWay(board,word,i,j,0,isVisited))
                    return true;
            }
        }
        return false;
    }

    private boolean isThisWay(char[][] board, String word, int row, int col, int index, boolean[][] isVisited) {
        if (row<0||row>=board.length||col<0||col>=board[0].length
                ||isVisited[row][col] || board[row][col]!=word.charAt(index))
            return false; //剪枝
        if (++index == word.length()) return true;
        isVisited[row][col] = true;
        for (int i =0;i<4;i++){
            if (isThisWay(board,word,row+dh[i],col+dw[i],index,isVisited))
                return true;
            //以board[row][col]为起点找匹配的word路径
            isVisited[row][col] = false; //遍历之后将该点设置为没有访问的状态，主方法中的下一次for循环

        }
        return false;

    }

}
