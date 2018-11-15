import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/6 14:47
 * @Description:
 * For example,
 * If nums = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 使用回溯法
 */
public class leetcode90_subsets2 {
    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res,nums,list,0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start;i<nums.length;i++){
            if (i>start&&nums[i]==nums[i-1]) continue; //重复元素跳过
            list.add(nums[i]);
            backtracking(res,nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
