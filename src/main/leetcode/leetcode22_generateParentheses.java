import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Think
 * @Date: 2018/9/27 14:19
 * @Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
/*
* 采取深度优先搜索
* 最优解：https://blog.csdn.net/yutianzuijin/article/details/13161721
* */
public class leetcode22_generateParentheses {
    public static List<String> Core(int n ){
        List<String> res = new ArrayList<String>();
        genetating(n,n,"",res);
        return res;
    }

    private static void genetating(int left, int right, String str, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
        }
        if (left > 0) {
            genetating(left-1,right,str+"(",res);
        }
        if (left<right){
            genetating(left,right-1,str+")",res);
        }
    }

    public static void main(String[] args) {

        System.out.println(Core(3));
    }

}
