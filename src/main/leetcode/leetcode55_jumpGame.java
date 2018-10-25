/**
 * @Auther: Think
 * @Date: 2018/10/24 21:32
 * @Description:
 *
 * 根据题目要求，数组里的每个元素表示从该位置可以跳出的最远距离，要求问从第一个元素（index=0）开始，能否达到数组的最后一个元素，这里认为最后一个元素为终点。
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 *
 * 贪心算法:计算出某个点时能跳的最大的距离，（当前点+能跳出的最大距离的较大值
 * 如果能跳出的最大距离大于最后一个点的位置，返回true
 */
public class leetcode55_jumpGame {
    public static boolean canJump(int[] nums){
        if (nums.length < 1) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        //记录到当前点时能到的最大的位置
        int max = 0;
        for (int i = 0;i<nums.length-1;i++){
            max = Math.max(max,i+nums[i]);
            if (max < i + 1) {
                return false;
            }
            if (max >= (nums.length - 1)) {
                return true;
            }
        }
        return false;
    }
}
