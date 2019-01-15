package leetcode.leetcode170;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Think
 * @Date: 2018/12/14 20:55
 * @Description:
 */
public class leetcode_solution161_170 {

    /**
     * @Auther: Think
     * @Date: 2018/12/14 20:55
     * @Description:
     *
     * 给定一个大小为n的数组，找到其中的众数（出现次数大于n/2）
     */

    //利用hash表做映射，存储这个数和他出现的次数
    public int majorityElement(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num: nums){
            Integer count = map.get(num);
            if (count == null) {
                count = 1;
            }else {
                count++;
            }
            map.put(num,count);
            if (map.get(num)>n/2)
                return num;
        }
        return 0;
    }



}
