import java.security.PublicKey;
import java.util.HashSet;

/**
 * @Auther: Think
 * @Date: 2018/10/16 17:07
 * @Description: 判断有效数独 维护一个hash表，按行查找，按列查找，按块查找，均满足没有重复数字即可
 */
public class leetcode36_validSudoku {
    public boolean isValidSudoku(char[][] board){
        for (int i = 0;i<9;i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0;j<9;j++){
                //检查第i行，在横坐标的位置
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                //检查第i列，在纵坐标位置
                if (board[j][i]!='.'&&!column.add(board[j][i]))
                    return false;
                //行号+偏移量
                int rowIndex = 3*(i/3)+j/3;
                int colIndex = 3*(i%3)+j%3;
                //每个小9宫格，总共9个 此时的i表示第i个小九宫格，j表示小九宫格中的第j个格子（0-9） 循环是每个小九宫格进行判断
                if (board[rowIndex][colIndex]!='.'
                        &&!cube.add(board[rowIndex][colIndex]))
                    return false;
                }
        }
        return true;
    }
}
