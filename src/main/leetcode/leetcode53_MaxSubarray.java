/**
 * @Auther: Think
 * @Date: 2018/10/23 15:44
 * @Description:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 求一个连续的数组值，使之和最大
 */
public class leetcode53_MaxSubarray {
    public int maxSubarrray(int[] nums){
        int[] sum = new int[nums.length];
        int max = sum[0];
        sum[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            sum[i] = Math.max(nums[i],sum[i-1]+nums[i]);
            max = Math.max(max,sum[i]);
        }
        return max;
    }
}
