/**
 * @Auther: Think
 * @Date: 2018/10/31 20:31
 * @Description:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * 【解析】
 * 这道题给了一个排好序的二维矩阵，问改矩阵内是否有target这个数字。其实不用把它当成矩阵，直接按照一个序列来计算即可。
 */
public class leetcode74_searchA2DMatrix {
    public boolean solution(int[][] matrix ,int target){
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        int left = 0,right = m*n-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (target==matrix[mid/n][mid%n]){
                return true;
            }else if (target>matrix[mid/n][mid%n]){
                left = mid + 1;
            }else {
                right = mid + 1;
            }
        }
        return false;
    }

}
