/**
 * @Auther: Think
 * @Date: 2018/10/24 22:45
 * @Description:
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 生成一个矩阵：类似于54题
 */
public class leetcode59_SpiralMatrix {
    public int[][] Solution(int n ){
        int[][] res = new int[n][n];
        if (n<1)
            return res;
        int index = 1,rowStart = 0,rowEnd = n - 1,colStart = 0,colEnd = n - 1;
        while (index < n * n) {
            for (int i = colStart;i<colEnd;i++){
                res[rowStart][i] = index++;
            }
            for (int i = rowStart+1;i<=rowEnd;i++){
                res[i][colEnd] = index++;
            }
            for (int i = colEnd - 1;i>=colStart;i--){
                res[rowEnd][i] = index++;
            }
            for (int i = rowEnd - 1;i>rowStart;i--){
                res[i][colStart] = index++;
            }
            rowStart+=1;
            rowEnd-=1;
            colEnd-=1;
            colStart+=1;
        }
        return res;
    }


}
