/**
 * @Auther: Think
 * @Date: 2018/10/31 21:06
 * @Description:
 * 输入两个字符串word1和word2，允许对word1进行插入，删除和替换的操作，计算出将word1转化为word2所需要的最少的操作数。
 * 算法分析参考：https://segmentfault.com/a/1190000010512402
 */
public class leetcode72_editDistance {
    public int solution(String word1,String word2){
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();
        int[][] steps = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i<=word1.length();i++){
            for (int j = 0;j<=word2.length();j++){
                if (i==0){
                    steps[i][j] = j;
                } else if (j == 0) {
                    steps[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    steps[i][j] = steps[i-1][j-1];
                }else {
                    steps[i][j] = Math.min(Math.min(steps[i-1][j]+1,steps[i][j-1]+1),steps[i-1][j-1]+1);
                }
            }
        }
        return steps[word1.length()][word2.length()];
    }

}
