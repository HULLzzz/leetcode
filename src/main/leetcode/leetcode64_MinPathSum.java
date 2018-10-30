/**
 * @Auther: Think
 * @Date: 2018/10/29 16:39
 * @Description:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 程序参考：https://blog.csdn.net/sinat_33150417/article/details/82792070
 */
public class leetcode64_MinPathSum {
    public int minPathSum(int[][] grid){
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        for (int i = 1;i<m;i++)
            dp[0][i] = grid[0][i]+dp[i-1][0];
        for (int i = 1;i<n;i++){
            dp[i][0] = grid[i][0]+grid[i - 1][0];
        }
        for (int i = 1;i<grid.length;i++){
            for (int j = 1;j<grid[i].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

}
