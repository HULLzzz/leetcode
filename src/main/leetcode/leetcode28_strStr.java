/**
 * @Auther: Think
 * @Date: 2018/10/10 19:39
 * @Description:  找到字符串的子串，如果匹配的话就返回第一个匹配的值，不匹配的话返回-1
 *
 * 字符串匹配查找问题：KMP BM SUNDAY
 */
public class leetcode28_strStr {
    public int strStr(String haystack,String needle){
        if (haystack==null||needle==null) return 0;
        if (needle.length()==0) return 0;
        for (int i = 0;i<haystack.length();i++){
            if (i+needle.length()>haystack.length())
                return -1;
            int m = i ;
            for (int j = 0;j<needle.length();j++){
                if (needle.charAt(j) == haystack.charAt(m)) {
                    if (j==needle.length()-1){
                        return i;
                    }
                    m++;
                }else {
                    break;
                }
            }
        }
        return -1;
    }


}
