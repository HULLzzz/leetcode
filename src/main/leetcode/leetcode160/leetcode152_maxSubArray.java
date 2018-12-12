package leetcode160;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @Auther: Think
 * @Date: 2018/12/7 18:30
 * @Description:
 *
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class leetcode152_maxSubArray {
    public int solution(int[] nums){
        if (nums == null||nums.length == 0)
            return 0;
        int maxP = nums[0],minN = nums[0],dp = nums[0];
        for (int i = 1;i<nums.length;i++){
            //需要分别存储当前的最大正乘积和最小负乘积，因为负数也会有一定影响
            int locMax = nums[i]*maxP,locMin = nums[i]*minN;
            maxP = Math.max(nums[i],Math.max(locMax,locMin));
            minN = Math.min(nums[i],Math.min(locMax,locMin));
            dp = Math.max(dp,maxP);
        }
        return dp;
    }
}
