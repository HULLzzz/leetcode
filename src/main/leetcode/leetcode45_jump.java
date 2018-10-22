/**
 * @Auther: Think
 * @Date: 2018/10/19 16:10
 * @Description: 给定一个非负整数数组，给定的初始化位置在数组的起始位，数组的每个元素代表你能在此位置跳跃的最大位置
 *                 [2,3,1,1,4] 第一个数2，最大能跳两步，你可以选择跳1步或者两步，显然跳一步之后再从第二个数能直接跳到末尾 output=1
 *                 你的目标是用最少的跳跃数到达数组的结尾
 *                 贪心算法
 */
public class leetcode45_jump {
    public int jump(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //对于每个位置，都维护一个当前位置能跳到的最远的位置的下标，我们要找的就是最远的位置
        //每次跳到最远的位置之后记录last，如果走的步数超出了这个范围肯定是新的一跳，同时需要将step和last均更新为当前的step和cur
        //cur维护当前能跳到的最大位置 nums[i]+i
        //last 之前的点能跳到的最大位置 若i>last证明超出了上次所跳的最大位置，需要跳一步
        //第step+1，能到达的最远距离
        int cur = 0;
        int last = 0;
        int step = 0;  //所跳的步数
        for (int i = 0;i<nums.length;i++){
            //i大于之前的点能达到的最大位置的时候，需要跳一步，并更新last为cur
            if (i>last){
                step++;
                last = cur;
            }
            //计算step+1的最大距离
            cur = Math.max(cur,nums[i] + i);
        }
        //cur能达到最后一个元素则返回step，到不了说明根本走不到最后一步，返回-1
        return cur < nums.length - 1?-1:step;
    }

}
