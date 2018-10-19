package main.leetcode;

/**
 * @Auther: Think
 * @Date: 2018/9/3 15:20
 * @Description:https://blog.csdn.net/qq_34379015/article/details/80237309
 */
public class leetcode10_RegularExpressionMatching {
    public static boolean isMatch(String s,String p){
        if (s == null || p == null) {
            return false;
        }
        return match(s,0,p,0);
    }

    private static boolean match(String s, int sIndex, String p, int pIndex) {
        if (sIndex==s.length()&&pIndex==p.length())
            return true;
        else if (sIndex!=s.length()&&pIndex==p.length())
            return false;
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if (sIndex != s.length() && p.charAt(pIndex) == s.charAt(sIndex)
                    || p.charAt(pIndex) == '.' && sIndex != s.length())
            //当前字符匹配成功
            {
                return match(s,sIndex,p,pIndex+2)  //匹配字符串覆盖整个s字符串但s:pa p：p*pa 这种情况也是匹配的
                        ||match(s,sIndex+1,p,pIndex+2)  //*匹配零个字符的时候
                        ||match(s,sIndex+1,p,pIndex);  //*匹配多个字符的时候
            }else
                return match(s,sIndex,p,pIndex+2);
        } else if (sIndex != s.length() &&p.charAt(pIndex)==s.charAt(sIndex)|| p.charAt(pIndex) == '.') {
            return match(s,sIndex+1,p,pIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.printf("ismatch :" +  isMatch(s,p));
    }

}
