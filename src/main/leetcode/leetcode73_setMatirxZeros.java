/**
 * @Auther: Think
 * @Date: 2018/10/31 20:42
 * @Description:
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 这里的思路是先从左上到右下遍历，将所有需要需要置零的行和列的首位都置为0，然后再反向遍历将所有首位为0的行和列都置为0。
 * 这里还用一个值来表示首行是否需要置零。这也是为什么需要反向的原因。
 */
public class leetcode73_setMatirxZeros {
    public void setZeros(int[][] matrix){
        int col0 = 1,rows = matrix.length,cols = matrix[0].length;
        for (int i = 0;i<rows;i++){
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1;j<cols;j++){
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }

        }
        for (int i = rows-1;i>=0;i--){
            for (int j = cols - 1;j>=1;j--){
                if (matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0)matrix[i][0] = 0;
        }
    }

}
