package leetcode130;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: Think
 * @Date: 2018/11/29 21:14
 * @Description:
 */
public class leetcode128_LongestConsecutive {
    public int solution(int[] nums){
        if (nums==null) return 0;
        int len = nums.length;
        if (len<=1) return len;
        Arrays.sort(nums);

        //排序之后找连续的数即可

        int res = 1;
        int tmp = nums[0];
        int count = 1;
        int dis;
        for (int i = 1;i<len;i++){
            dis = nums[i] - tmp;
            if (dis==0) continue;
            if (dis==1){
                tmp++;
                count++;
            }else {
                res = res>count?res:count;//res保存的是最大的连续数字的值
                count = 1;
                tmp = nums[i];
            }
        }
        res = res>count?res:count;
        return res;
    }
}
