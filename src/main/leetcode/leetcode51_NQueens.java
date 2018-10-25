import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/22 11:01
 * @Description: 八皇后的问题
 * 借助isvalue函数判断此位置是否可以放Q皇后，及判断纵横，左右对角线是否有皇后
 * 从0行0列开始放置皇后，如果位置合适，放置皇后
 * 回溯法：递归到row+1行，如果循环试了0-col列都无法放置，则当前无解需要将上次放置的皇后取消掉。
 */
public class leetcode51_NQueens {
    public List<List<String>> solution(int n){
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n]; //第i个位置存放的数表示i行时，Q的列
        placeQueen(queenList,0,n,res);  //在第0行放Q
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，则生成结果，行数为题目中的行数n
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            //行
            for (int i = 0;i<n;i++){
                String str = "";
                //列
                for (int col = 0;col<n;col++){
                    if (queenList[i] == col){
                        str += "Q";
                    }else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        //循环每一列
        for (int col = 0;col<n;col++){
            if (isValid(queenList, row ,col)) {
                //判断放在此列是否冲突
                //在col列放置皇后
                queenList[row] = col;
                //放置下一行
                placeQueen(queenList,row+1,n,res);
                //回溯，如果下一行不合适，那么就不会进入递归，而退出下一行递归回到当前点执行for循环

            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        //如果该列放入Q不冲突的话
        for (int i = 0; i<row;i++){
            int pos = queenList[i];
            if (pos == col) {
                //和新加入的Q位于同一列
                return false;
            }
            if (pos + row - i == col) {
                //在右对角线上 col-row = pos - i
                return false;
            }
            if (pos - row + i == col) {
                //左对角线  col+row = pos+i
                return false;
            }
        }
        return true;
    }

}
