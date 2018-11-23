package java.leetcode120;

/**
 * @Auther: Think
 * @Date: 2018/11/19 14:51
 * @Description:
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 *
 * Return 3.
 * 思路：https://blog.csdn.net/cslbupt/article/details/54286571
 */
public class leetcode115_distinctSub {
    //使用动态规划：dp[i][j]表示T[i]和S[j]匹配的个数
    //dp[0][0] = 1;T，S均为空
    //dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。
    //dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。
    //dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0).1 <= i <= T.length(), 1 <= j <= S.length()
    public int solution(String s,String t){
        int[][] dp = new int[t.length()+1][s.length()+1];
        dp[0][0] = 1;
        for (int i = 1;i<=t.length();i++){
            dp[i][0] = 0
        }
    }

}
