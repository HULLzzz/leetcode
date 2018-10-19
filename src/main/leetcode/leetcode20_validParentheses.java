import java.util.Stack;

/**
 * @Auther: Think
 * @Date: 2018/9/27 13:49
 * @Description:
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

/*
* 左边的字符和右边的字符不仅对称而且数量上要相同，使用栈来进行辅助判断
* 栈具有后进先出的特性，将左边的括号push进栈中，一次pop看与s右边的是否相同
*  */
public class leetcode20_validParentheses {
    public static boolean isValid(String s){
        Stack<Integer> stack = new Stack<>();
        char in[] = s.toCharArray();
        for (char c : in){
            if (c=='('){
                stack.push(0);
            } else if (c == '[') {
                stack.push(1);
            } else if (c == '{') {
                stack.push(2);
            } else if (stack.isEmpty()) {
                return false;
            }else if (c==')'&&stack.pop()!=0){
                return false;
            }else if (c==']'&&stack.pop()!=1){
                return false;
            }else if (c=='}'&&stack.pop()!=2){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[(})]}";
        System.out.println("isValid"+isValid(s));
    }
}
