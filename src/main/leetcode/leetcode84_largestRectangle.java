import java.util.Stack;

/**
 * @Auther: Think
 * @Date: 2018/11/5 15:36
 * @Description: 最大矩形柱状图
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class leetcode84_largestRectangle {
    public int solution(int[] height){
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0;i<=len;i++){
            int h = (i==len?0:height[i]); //下标为len的时候高度为0，为了避免特殊情况，最后一位比倒数第二位还要高
            if (stack.isEmpty()||h>=height[stack.peek()]){
                //利用一个栈，递增的块直接压入栈中，否则将栈顶出栈，计算上一个比他高的块的面积，从当前的位置依次向前计算，
                stack.push(i);

            }
            else {
                int tmp = stack.pop();
                maxArea = Math.max(maxArea,height[tmp]*(stack.isEmpty()?i:i-1-stack.peek()));
                i--; //i--之后再进入i++ 还是当前位
            }
        }
        return maxArea;
    }
}
