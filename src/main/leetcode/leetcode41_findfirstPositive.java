/**
 * @Auther: Think
 * @Date: 2018/10/17 14:07
 * @Description: 给定未排序的数组，找出其中没有出现过的最小的正整数
 * 输入: [1,2,0]
 * 输出: 3
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 将每个数n放在数组中序号为n-1的位置上，其中负数和大于数组长度的数不用管，没有他们的位置
 * 重复的数也只遍历一次，这样再遍历一遍之后，再从头开始遍历数组，当哪个位置上的数是不希望的该位置上缺少的数就是要找的数
 * 如果全部都是希望的数，那么所缺的数就是len+1
 */
public class leetcode41_findfirstPositive {
    //算法时间复杂度为o(n)
    public int firstMissingPositive(int[] nums){
        int len = nums.length;
        for (int i = 0;i<len;){
            if (nums[i]!=i+1&&nums[i]>0&&nums[i]<=len&&nums[i]!=nums[nums[i]-1]){
                swap(i,nums[i]-1,nums);//nums[i]和nums[nums[i]-1]交换，num[i]-1作为下标，交换之后nums[i]-1下表下的数字即为nums[i]
            }else {
                i++;
            }
        }
        for (int i = 1;i<=len;i++){
            if (nums[i - 1] != 1) {
                return i;
            }
        }
        return len+1;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
