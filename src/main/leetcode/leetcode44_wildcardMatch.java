/**
 * @Auther: Think
 * @Date: 2018/10/19 15:10
 * @Description: 通配符匹配
 * 参考https://www.cnblogs.com/acbingo/p/9346378.html
 * 动态规划三步：
 *      1、判断是否能用动态规划来做：判断的标准：最优子结构，重叠子问题（匹配就属于重叠子问题）
 *      2、描述状态。这个题的状态还是比较好描述的，boolean f[i][j] ：表示子串s[0~i-1] 与子串p[0~j-1]是否match
 *      3、找出状态转移方程以及初始状态：
 *          最难的地方就在于如何找状态转移方程。
 *          如何找？即分析当前状态由上层哪个或者哪些以及处理过的状态转换而来
 *          假设题中没有*，那就简单了，状态转移方程为f[i][j] = f[i-1][j-1] && s[i]==p[j]
 *
 *          现在加上，我们就可以按情况讨论嘛，如果p[j]!='' ,那么状态转移方程就是f[i][j] = f[i-1][j-1] && s[i]==p[j]
 *          如果p[j]=='' , 即可以代替0个、1个或者多个，对于的状态f[i][j]可以由f[i-1][j-1]，f[i][j-1]和f[i-1][j]而来，即f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
 *
 *          初始状态，显然f[0][0]=true
 *          不过，还有一个初始状态很容易被遗忘：
 *          当p以开头时
 *          if (p.length() > 0 && p.charAt(0) == '') {
 *          f[0][1] = true;
 *          }
 */
public class leetcode44_wildcardMatch {
    public boolean isMatch(String s,String p){
        String tp = "";

        //处理p中多余的* s为源字符串，p为匹配字符串
        for (int i = 0;i<p.length();i++){
            if (p.charAt(i) == '*') {
                tp += '*';
                while (i < p.length() && p.charAt(i) == '*') {
                    i++;
                }
            }
            if (i < p.length()) {
                tp += p.charAt(i);
            }
        }
        p = tp;

        //boolean f[i][j] ：表示子串s[0~i-1] 与子串p[0~j-1]是否match
        boolean[][] f = new boolean[s.length()+1][p.length()+1];
        f[0][0] = true;

        //当p以*开头的时候
        if (p.length()>0&&p.charAt(0)=='*'){
                f[0][1] = true;
        }
        for (int i = 1;i<=s.length();i++){
            for (int j = 1;j<=p.length();j++) {  //i = 1;j = 1;f[i][j]为下一状态，[i-1][j-1]才是上一个状态
                if (p.charAt(j - 1) == '*'){
                    f[i][j] = f[i-1][j-1]||f[i-1][j]||f[i][j-1];
                }else {
                    f[i][j] = f[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?');
                }
            }
        }
        return f[s.length()][p.length()];
    }
}
