package java.leetcode120;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/19 10:18
 * @Description:
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 *
 */
public class leetcode120_triangle {
    public int solution(List<List<Integer>> triangle){
        int row = triangle.size();  //行数
        if (row==0){
            return 0;
        }
        int[] res = new int[row+1];
        for (int i = row-1;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j = 0;j<list.size();j++){
                res[j] = (Math.min(res[j+1],res[j])+list.get(j));

            }
        }
        return res[0];
    }
}
