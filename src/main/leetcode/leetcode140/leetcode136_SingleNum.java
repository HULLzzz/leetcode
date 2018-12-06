package leetcode140;

/**
 * @Auther: Think
 * @Date: 2018/11/30 17:11
 * @Description:
 * 给定一个数组，每个元素都出现2次除了其中的一个，找出只出现一次的数字注意：算法必须是线性时间复杂度，可以不使用额外空间实现吗？
 *
 */
public class leetcode136_SingleNum {
    public int soluiton(int[] nums){
        if (nums == null||nums.length<1){
            throw new IllegalArgumentException("nums");
        }

        for (int i = 1;i<nums.length;i++){
            nums[0]^=nums[i];
        }
        return nums[0];
    }

    //给一个数组，里面只有一个数字一次，其它数字都出现3次，找出这个出现一次的数字，要求时间复杂度为O(n)，空间复杂度为O(1)。最好不傅额外的空间。
    public int solution137(int[] nums){
        int[] count = new int[32];
        int res = 0;
        for (int i = 0;i<32;i++){
            //统计第i位1的个数
            for (int n:nums){
                if (((n>>i)&1)==1){
                    count[i]++;
                }
            }
            res|=(count[i]%3)<<i;
        }
        return res;
    }
}

//用大小为32的数组记录每个位数的和，每个位数的和%3的值就是single num这个位上的数字
//考虑数字全部用二进制表示
