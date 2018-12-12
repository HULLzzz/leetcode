package leetcode160;

/**
 * @Auther: Think
 * @Date: 2018/12/7 18:42
 * @Description:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class leetcode153_FindMinInRotatedSortedArray {
    public int solution153(int[] nums){
        int len = nums.length;
        if (nums.length==1)
            return nums[0];
        int p1 = 1,p2 = len - 1;
        if (nums[len-1]>nums[0])
            return nums[0];
        while (true) {
            if (p1>=p2-1)
                return Math.min(nums[p1],nums[p2]);
            int mid = (p1+p2)>>1;
            if (nums[mid]>=nums[p1]){
                p1 = mid;
                continue;
            }else {
                p2 = mid;
                continue;
            }
        }
    }

    /*
    * Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0

leetcode154 和 153不同的地方在于154的数字是可以重复的
    * */

    public int solution(int[] nums){
        int len = nums.length;
        if (nums.length==1)
            return nums[0];
        int p1 = 0,p2 = len - 1,mid = 0;
        if (nums[len-1]>nums[0])
            return nums[0];
        while (p1 < p2) {
            mid = (p1 + p2) >> 1;
            if (nums[mid]>nums[p2]){
                p1 = mid + 1;
            }else if (nums[mid]<nums[p2]){
                p2 = mid;
            }else {
                p2 = p2 - 1;
                //nums[mid] == nums[p2] p2即使是最小值也不影响
            }
        }
        return nums[p1];
    }

}
