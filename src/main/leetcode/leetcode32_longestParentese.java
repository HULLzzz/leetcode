import java.util.Map;

/**
 * @Auther: Think
 * @Date: 2018/10/13 10:28
 * @Description: 最有效的长括号 输出个数
 * Input: ")()())"
 * Output: 4
 */
public class leetcode32_longestParentese {
    public int longestParenthese(String s){
        //动态规划 dp[i]为以s[i]为结尾的最长有效字串的长度
        //s[i]=='(' dp[i]为0
        //s[i]==')'，看堆成位置是否为'('，注意（）（（）））
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;
        for (int i = 1;i<chars.length;i++){
            if (chars[i] == ')') {
                pre = i - dp[i-1]-1; //对称位置
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
