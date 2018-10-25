import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/23 16:03
 * @Description: 顺时针打印matrix
 *
 */
public class leetcode54_spiralMatrix {
    public List<Integer> spiralOrder(int[][] arr){
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) {
            return res;
        }
        int rows = arr.length;
        int cols = arr[0].length;

        //求圈数
        //ceil向上取整，返回大于或者等于函数参数的值
        int layers = (int)Math.ceil((Math.min(rows,cols))/2.0);

        for (int i = 0;i<layers;i++){
            //打印每圈
            // 从左到右
            for (int k = i;k<cols - i;k++){
               res.add(arr[i][k]);
            }
            //右上到右下
            for (int j = i+1;j<rows-i;j++){
                res.add(arr[j][cols-i-1]);
            }

            //从右至左
            for (int k = cols - i - 2;(k>=i)&&(rows-i-1!=i);k--)
                res.add(arr[rows-i-1][k]);

            //左下至左上
            for (int j = rows - i - 2;(j>i)&&(cols-i-1!=i);j--)
                res.add(arr[j][i]);
        }
return res;
    }
}
