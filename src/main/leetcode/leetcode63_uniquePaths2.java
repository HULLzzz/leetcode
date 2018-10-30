/**
 * @Auther: Think
 * @Date: 2018/10/29 16:21
 * @Description:
 * 给出一个二维格子，其中值为1的点表示障碍点，要求求出从最左上角的点到最右下角的点有多少种走法。
 * 使用动态规划，对于其中一个点obstacleGrid[i][j](1<i<m,i<j<n)，到该点的走法为d(obstacleGrid[i][j])=d(obstacleGrid[i-1][j])+d(obstacleGrid[i][j-1])，对于第一行和第一列，如果该点前面有障碍点，那么到到此点有0中方法，反之为1。遍历数组即可求解。
 */
public class leetcode63_uniquePaths2 {
    public int Solution(int[][] obstacleGrid){
        int row = obstacleGrid.length;
        if (row==0) return 0;
        int col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                if (obstacleGrid[i][j]==1){
                    res[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    if (j != 0) {
                        res[i][j] = res[i][j-1];
                    }else if (i!=0)
                        res[i][j] = res[i-1][j];
                    else
                        res[i][j] = 1;
                }else {
                    res[i][j] = res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[row-1][col-1];
    }


}
