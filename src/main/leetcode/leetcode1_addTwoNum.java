import javax.swing.*;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author:https://www.cnblogs.com/Xieyang-blog/p/8196690.html
 * @Description:
 *              Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *              You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *              Example:
 *              Given nums = [2, 7, 11, 15], target = 9,
 *              Because nums[0] + nums[1] = 2 + 7 = 9,
 *              return [0, 1].
 * @params:
 * @Data: Created in  9:30 2018/8/29
 * @Modified By:
 */
public class leetcode1_addTwoNum {
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(target - nums[i])) {
                //此时nums[i]还没放进去
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    //当需要进行多循环或者是定位的时候，尽量优先考虑是否能用map，使用值作为KEY，相应下标作为value
    //使用map.containsKey(_)进行定位
    //时间复杂度位o(n)


    /*
    * 将2sum的题目改为如下：
        给定一个n个整数的数组，在数组中找到和为目标值的所有唯一的两个元素组合【注意不是求下标】
        注意:答案集不能包含重复的双胞胎。
        测试用例：{1,4,-1,2,-1,0}   1　　　　　结果：[[0, 1], [-1, 2]]
　　　　　{3,2,3,4,1,4,5,5}  8　　　　 结果：[[4, 4], [3, 5]]
    * */
    public static List<List<Integer>> twoSumAll(int[] num,int target){
        Arrays.sort(num);//将所有相同的元素放在一起
        List<List<Integer>> res = new LinkedList<List<Integer>>();;
        Set<Integer> set = new HashSet<Integer>();  //需要元素唯一，用set
        for (int i = 0;i<num.length;i++){
            if (set.contains(target - num[i])) {
                res.add(Arrays.asList(target - num[i],num[i]));
                set.remove(target - num[i]); //防止元素被重复利用

            }
            set.add(num[i]);
        }
        return res;
    }
    //时间复杂度o(n) 使用set避免出现相同的数组（要求唯一的尽量先使用set）

    //使用双指针相向移动的思想

    public static List<List<Integer>> twoSumAll2(int[] num,int target){
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            if (num[left] + num[right] == target) {
                res.add(Arrays.asList(num[left],num[right]));
                while (left<right&&num[left]==num[left+1]) left++;
                while (left<right&&num[right]==num[right-1]) right--;
                left++;
                right--;
            }else if (target>num[left]+num[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,5,6,7};
        int[] arr = twoSum(nums,6);
       // System.out.println(Arrays.toString(arr));
        List<List<Integer>> list = twoSumAll2(nums,6);
        System.out.println(list.size());
        for (int i = 0;i<list.size();i++){
           // List l =list.get(i);
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

}
