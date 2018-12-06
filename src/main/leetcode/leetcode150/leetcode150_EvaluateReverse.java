package leetcode150;

import javax.swing.*;
import java.util.Stack;

/**
 * @Auther: Think
 * @Date: 2018/12/3 19:16
 * @Description:
 * ate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class leetcode150_EvaluateReverse {
    public int solution(String[] str){
        int len = str.length;
        if (len==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<len;i++) {
            if (str[i].equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 + num2);

            } else if (str[i].equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);

            } else if (str[i].equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (str[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(str[i]));
            }
        }
    return stack.pop();
    }

}
