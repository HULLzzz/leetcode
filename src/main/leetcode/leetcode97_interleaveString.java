/**
 * @Auther: Think
 * @Date: 2018/11/13 15:12
 * @Description:
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 *
 * When s3 = "aadbbbaccc", return false.
 */
public class leetcode97_interleaveString {
    public boolean solution(String s1,String s2,String s3){
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1+len2 != len3){
            return false;
        }

        //使用动态规划 dp[i][j]表示s1在第i个位置，s2在第j个位置，s3在遍历i+j个位置
        boolean[][] dp = new boolean[len1][len2];
        //当s2为空的时候，只需要判断s1和s3即可
        for (int i = 0;i<=len1;i++){
            dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i))?true:false;

        }
        //同理s2
        for (int j = 0;j<=len2;j++){
            dp[0][j] = s1.substring(0,j).equals(s3.substring(0,j))?true:false;
        }
        //s1,s2均不为空 两种情况：从(i-1,j)到达（i，j）的位置，只需要比较s1的第i个位置和s3的第j+i个位置
        //另一种情况同理
        for (int i = 1;i<=len1;i++){
            for (int j = 1;j<=len2;j++){
                dp[i][j] = (dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))
                        ||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
