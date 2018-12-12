package leetcode160;

import java.util.Stack;

/**
 * @Auther: Think
 * @Date: 2018/12/7 18:58
 * @Description:
 * 实现一个stack，要求有push,pop,top功能，还要有一个返回stack最小值的函数（要在常量时间里返回这个值）。
 */
public class leetcode155_MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x){
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop(){
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
