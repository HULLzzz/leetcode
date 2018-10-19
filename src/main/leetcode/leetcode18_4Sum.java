import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/9/25 15:20
 * @Description:
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

//暴力解法
public class leetcode18_4Sum {
    public List<List<Integer>> Core(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        int pre_i = Integer.MAX_VALUE;
        for (int i = 0;i<length-3;i++){
            if (pre_i == nums[i]){
                continue;
            }
            pre_i = nums[i];
            //已经拍好序了，如果4*nums[i]>target，则排除nums[i]
            if (4 * nums[i] > target) {
                break;
            }
            int remain_target = target - nums[i];
            if (nums[i] + 3*nums[i+1]>target||nums[i]+3*nums[length-1]<target){
                continue;
            }
            for (int j = i+1;j<length-2;j++){
                if (j>i+1&&nums[j-1]==nums[j]){
                    continue;
                }
                int m = j+1;
                int n = length - 1;
                int sub_target = target - nums[i] - nums[j];
                while (m < n) {
                    if (nums[m] + nums[n] == sub_target) {
                        Integer[] tmp = {nums[i],nums[j],nums[n],nums[m]};
                        result.add(Arrays.asList(tmp));
                        m++;
                        n--;
                        while (++m<n&&nums[m]==nums[m-1]);
                        while (m<n--&&nums[n]==nums[n+1]);

                    } else if (nums[m] + nums[n] < sub_target) {
                        m++;
                        while (++m<n&&nums[m]==nums[m-1]);
                    }else {
                        n--;
                        while (m<n--&&nums[n]==nums[n+1]);
                    }
                }
            }


        }
        return result;
    }
}
