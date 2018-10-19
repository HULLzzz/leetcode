/**
 * @Auther: Think
 * @Date: 2018/9/19 13:26
 * @Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class leetcode_14_LongestCommonPrefix {
    public static String Core(String[] str){
        if (str.length == 0) {
            return " ";
        }
        String result = str[0];
        int i = 1;
        //将第一个字符串作为匹配字符串，和下一个字符串进行匹配
        while (result.length()>0&&i<str.length){
            String s = str[i];
            if (s.length() == 0) {
                return " ";
            }
            String a = result;
            String b = s;
            //如果下一个字符串小于匹配字符串的长度，将匹配字符串换为下一个字符串
            if (result.length()>s.length()){
                a = s;
                b = result;
            }
            while (b.indexOf(a) != 0) {
                a = a.substring(0,a.length()-1);
            }
            result = a;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"flow","flower","fly"};
        System.out.println("result: "+ Core(str));
    }
}
