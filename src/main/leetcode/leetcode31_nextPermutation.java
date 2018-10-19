import java.util.Arrays;

/**
 * @Auther: Think
 * @Date: 2018/10/13 09:26
 * @Description:https://blog.csdn.net/zr1076311296/article/details/51296008
 * think：找到全排数字的下一个数字，即找比这个数字大的最小的数字
 * 例如：547532  7532已经是排序好的最大的数字，我们需要找比47532大的最小的数字，比4大的只有5，即57432，然后对后面的数字进行排序即可
 */
public class leetcode31_nextPermutation {
    public void nextPermutation(int[] nums){
        int len = nums.length;
        if (len == 0 || len == 1) {
            return ;
        }
        //从尾部向前找，找到nums[pos]>nums[pos-1] 即4的位置
        int pos = len - 1;
        while (pos>0&&nums[pos]<=nums[pos-1]){
            pos--;
        }
        if (pos == 0) {
            //说明到了最后一个位置 比如321，此时将他排序即可
            Arrays.sort(nums);
            return;
        }else {
            if (pos == len - 1) {
                //pos在最后一个位置，即123
                swap(nums[pos],nums[pos-1]);
                return;
            }else {
                //这种情况说明pos在中间位置 547532
                int key = nums[pos-1];
                int begin = len -1;
                //先找比4大的数
                while (begin > pos && nums[begin] <= key) {
                    begin--;
                }
                swap(nums[pos-1],nums[begin]);
                Arrays.sort(nums,pos,nums.length-1);
            }
        }

    }

    private void swap(int num1, int num2) {
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
    }
}
