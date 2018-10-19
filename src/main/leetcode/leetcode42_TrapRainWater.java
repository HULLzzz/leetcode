/**
 * @Auther: Think
 * @Date: 2018/10/17 20:42
 * @Description:
 * 题目描述和思路参考https://www.cnblogs.com/zihaowang/p/5027379.html
 */
public class leetcode42_TrapRainWater {
    public int trap(int[] height){
        int length;
        int left,right;
        int maxLeftHight = 0,maxRightHeight = 0; //当前位置的左边最大值和右边最大值
        int result = 0;

        if (height==null||(length = height.length)==0)
            return 0;
        left = 0;
        right = length-1;
        while (left < right) {
            maxLeftHight = Math.max(maxLeftHight,height[left]);
            maxRightHeight = Math.max(maxRightHeight,height[right]);

            if (maxLeftHight < maxRightHeight) {
                result+=maxLeftHight - height[left];
                left++;
            }else {
                result+=maxRightHeight - height[right];
                right--;
            }
        }
        return result;
    }


}
