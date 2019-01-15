package leetcode.leetcode170;

/**
 * @Auther: Think
 * @Date: 2018/12/14 21:13
 * @Description:
 * 有序数组中找到两个数，使他们的和为target
 * given：数组升序排列，函数返回这两个下标值index1和index2，其中index1小于index2
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class leetcode_TwoSum2 {
    public int[] solution(int[] nums,int target){
        for (int i = 0;i<nums.length;i++){
            for (int j = i + 1;j<nums.length;j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }

    //使用快慢指针
    //如果两个指针元素的和等于target，返回两个指针所指的数的下标
    //两个指针的和大于target，移动较大的元素使和变小
    //两个指针的和小于target，移动较小的元素，使和变大

    public int[] solution2(int[] nums,int target){
        int[] res = new int[2];
        if (nums.length<2)
            return res;
        int len = nums.length;
        int small = nums[0];
        int big = nums[len-1];
        for (int i = 0,j=len - 1;i<nums.length&&j>0&&j>i;){
            if (small + big == target){
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
            if (small + big > target){
                j--;
            }
            if (small + big < target){
                i++;
            }
            small = nums[i];
            big = nums[j];
        }
        return res;
    }

}
