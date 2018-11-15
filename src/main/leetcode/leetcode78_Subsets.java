import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/2 21:22
 * @Description:
 * 返回子序列
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 回溯法：回溯的基本形式是递归+循环
 */
public class leetcode78_Subsets {
    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        dfs(res,tmp,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<Integer>(tmp));
        for (int i = index;i<nums.length;i++){
            tmp.add(nums[i]); //将nums[i]加入
            dfs(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1); //将元素移除
        }
    }

}
