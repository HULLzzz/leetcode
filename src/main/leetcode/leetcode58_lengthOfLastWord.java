/**
 * @Auther: Think
 * @Date: 2018/10/24 22:23
 * @Description:
 * Given a string s consists of upper/lower-case alphabets and empty space characters ’ ‘, return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = “Hello World”,
 * return 5.
 */
public class leetcode58_lengthOfLastWord {
    public int Solution(String s){
        //trim函数将最后的空格去掉
        s = s.trim();
        int len = s.length();
        if ("".equals(s)||" ".equals(s.charAt(len-1)))
            return 0;
        int count = 0;
        for (int i = len-1;i>=0;i--){
            if (s.charAt(i)==' '){
                return count;
            }
            else {
                count++;
            }
        }
        return count;
    }
}
