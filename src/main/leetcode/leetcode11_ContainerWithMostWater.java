package main.leetcode;

/**
 * @Auther: Think
 * @Date: 2018/9/3 16:14
 * @Description:  https://leetcode.com/problems/container-with-most-water/description/
 *                求最大的面积，从数组的两端开始向中间遍历，先假设第一块模板和最后一块木板组成的面积最大，如果还有更大的，移动木板直到两个木板重合
 *
 */
public class leetcode11_ContainerWithMostWater {
    public static int maxArea(int[] height){
        int max = Integer.MIN_VALUE;
        for (int i = 0,j = height.length - 1;i<j;){
            if (height[i]>height[j]){
                max = Math.max(max,height[j]*(j-i));
                j--;
            }else {
                max = Math.max(max,height[i]*(j-i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] p =new int[]{1,8,6,2,5,4,8,3,7};
        System.out.printf("maxArea: "+maxArea(p));
    }

}
