import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/9/19 13:44
 * @Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

/*
* 思路：先将数组排序，固定一个数，设置一个指针P指向下一个数和q数组末尾的数，如果sum<0 只需要将p向后移动一位，如果sum>0只需要将q向前移动一位
*      如果固定的数和下一个数相同，则可跳过（重复解）
*
* */
public class leetcode15_3Sum {
    public static List<List<Integer>> Core(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i<n;i++){
            if (i!=0&&nums[i]==nums[i-1]) continue;
            int sum = 0;
            int p = i+1;
            int q = n-1;
            while (p < q) {
                sum = nums[i]+nums[p]+nums[q];
                if (sum==0){
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[p]);
                    item.add(nums[q]);
                    list.add(item);
                    while (++p<q&&nums[p-1]==nums[p]){}
                    while (p<--q&&nums[q+1]==nums[q]){}
                } else if (sum > 0) {
                    q--;
                }else {
                    p++;
                }
            }
        }
        return list;
    }

    /*
    * leetcode16: 3Sum Closest
    *
        Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
        Example:
        Given array nums = [-1, 2, 1, -4], and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    * */
    //将数组排序，选定一个数，用target减去这个数，转换为寻找和target减去后的数最接近的两数之和

    public static int Core(int[] nums,int target){
        Arrays.sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length-2;i++){
            if (i!=0 && nums[i] == nums[i-1]){
                continue;
            } else if (min != Integer.MAX_VALUE && nums[i] > target) {
                break;
            }
            int j = i+1;
            int k = nums.length-1;
            int twoSum = target - nums[i];
            while (j < k) {
                if (Math.abs(twoSum - nums[j] - nums[k]) < min) {
                    result = nums[i]+nums[j]+nums[k];
                    min = Math.abs(twoSum - nums[j] - nums[k]);
                }
                if (nums[j]+nums[k]<twoSum) j++;
                else k--;
            }
        }
        return result;
    }

    /*
    * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
The solution set must not contain duplicate quadruplets.
Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
    * */

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,2,3,-2,-3};
        List<List<Integer>> list = Core(nums);
        for (int i = 0;i<list.size();i++){
            List<Integer> l = list.get(i);
            for (int num : l){
                System.out.print(num);
            }
            System.out.println(" ");

        }

        System.out.println("closest sum:"+Core(nums,4));
    }
}
