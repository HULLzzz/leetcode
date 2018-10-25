import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/23 14:49
 * @Description:  50题是输出打印n皇后的位置，本题要求输出总共有几种解法
 */
public class leetcode52_NQueen2 {
    private int solve(int n, int index, List<Integer> tmpList){
        //n个皇后，从第0行开始放置
        if (n == index){
            return 1;
        }
        int count = 0;

        //循环列，看放置到哪一列，0行的时候，尝试在不同列放置皇后，即一个for循环
        for (int col = 0;col<n;col++){
            int row = index;
            int rowList;
            //将放置好皇后的位置进行判断，看是都有同行，同列，同对角线的情况
            for (rowList = 0;rowList<tmpList.size();rowList++){
                int rrow = rowList;
                int ccol = tmpList.get(rrow);
                //同一列
                if (ccol == col) {
                    break;
                }
                //同一对角线
                if (Math.abs(rrow - row) == Math.abs(ccol - col)) {
                    break;
                }
            }
            //将之前放置的皇后和当前的皇后进行判断
            if (rowList == tmpList.size()) {
                tmpList.add(col);
                int val = solve(n,index+1,tmpList);
                //如果下一行无法放置，则回溯，将当前放置的皇后移除
                tmpList.remove(tmpList.size()-1);
                if (val>0){
                    count+=val;
                }
            }
        }
        return count;
    }

    public int totalNQueen(int n){
        //tmpList用于描述n皇后的棋盘
        List<Integer> tmpList = new LinkedList<>();
        return solve(n,0,tmpList);
    }
}
