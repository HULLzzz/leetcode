/**
 * @Auther: Think
 * @Date: 2018/10/16 14:35
 * @Description:
 * n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。依次类推，写个countAndSay(n)函数返回字符串。理解题意后，关键就是如何say一串数字了。 依次读入每个字符，对于每个字符，首先判断用于计数的count是否为0，如果不为0，表示前面该字符前面已经有字符了，所以再判断该字符和前一个字符是否相等，如果不相等，就把前面计算的结果添加到result中去，同时把count清零，最后count加1。
 * 原文：https://blog.csdn.net/changetocs/article/details/50154255?utm_source=copy
 */
public class leetcode38_countAndSay {
    public String countAndSay(int n){
        if (n == 1) {
            return 1+"";
        }
        String result = "1";

        for (int i =2;i<=n;i++){
            result = say(result);
        }
        return result;
    }

    public String say(String s){
        String result = "";
        int count = 0;
        char c = '0';
        for (int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if (count != 0) {
                if (s.charAt(i-1)!=c){
                    result = result+count+s.charAt(i-1);
                    count = 0;
                }
            }
            count++;
        }
        result = result+count+c;
        return result;

    }
}
