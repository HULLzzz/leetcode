/**
 * @Auther: Think
 * @Date: 2018/11/13 20:14
 * @Description:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 题意及分析：本题给出A-Z字符对应的数字，给出一个数字组成的字符串，要求求出可能A-Z组成的编码。这道题还是动态规划的题目，对于字符串中第i（i>2）个字符,因为编码最大的数字是26，所以到该点可能的编码方式和前一个字符也相关，如果当前字符和前一个字符组成的数字d=s.charAt(i-1)*10+s.charAt(i),
 *
 * （1）当0<d<=26，如果d%10!=0，有两种方式到达第i个字符（从第i-1字符加一个字符达到、从第i-2个字符加一个字符达到），即f(s.charAt(i))=f(s.charAt(i-1))+f(s.charAt(i-2))；如果i%10=0,则只有一种方式达到f(s.charAt(i))=f(s.charAt(i-2))
 *
 * （2）当d>26,如果d%10!=0,则一种方法到达i点（即从i-1到达i），f(s.charAt(i))=f(s.charAt(i-1))；如果d%10=0,则没有对应的编码表达d这两个字符，所以直接return 0
 *
 * （3）d==0的时候，字符串中出现了两个连续的0，直接return 0
 */
public class leetcode91_decodeWays {
    public int solution(String s){
        if (s.length()==0) return 0;
        int[] count = new int[s.length()+1];
        //count[i]表示从开始到i-1有可能的编码方式
        count[0] = 1;
        if (s.charAt(0) > '0') {
            count[1] = 1;
        }
        for (int i = 2;i<s.length();i++){
            if (s.charAt(i - 1)>='1') {
                count[i] = count[i-1];
            }
            int sum = Integer.parseInt(s.substring(i-2,i));
            if (sum <= 26 && s.charAt(i - 1 )!= '0') {
                count[i] += count[i-2];
            }

        }
        return count[s.length()];
    }


}
