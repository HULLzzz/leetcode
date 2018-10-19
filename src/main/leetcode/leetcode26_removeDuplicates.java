/**
 * @Auther: Think
 * @Date: 2018/10/9 14:58
 * @Description:
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Given nums = [1,1,2],
 */
public class leetcode26_removeDuplicates {
    public int removeDuplicates(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        int result = 1;
        while (k < nums.length) {
            if (nums[k]!=nums[k-1]){
                result++;
                nums[result-1] = nums[k];
            }
            k++;
        }
        return result;
    }
}
