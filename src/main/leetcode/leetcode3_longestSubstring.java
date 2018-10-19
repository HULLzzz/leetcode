import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author:
 * @Description:  Longest Substring Without Repeating Characters
 *                Input: "pwwkew"
 *                Output: 3
 *                Explanation: The answer is "wke", with the length of 3.
 *                Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @params:
 * @Data: Created in  9:44 2018/8/30
 * @Modified By:
 */
public class leetcode3_longestSubstring {
    //使用滑动窗口法，定义两个指针，start和end，使用hashset当窗口中有重复元素的时候start++，没有重负元素的时候end++
    public static int lengthOfLongestSubString(String s){
        int n = s.length();
        int res = 0;
        int end = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            }else {
                set.add(s.charAt(end++));
                res = Math.max(res,end-start); //确保每次保存的都是最长的子串的长度
            }
            }
            return res;
    }
    //有关查找，无重复的子元素的时候尽量使用set
    //此方法的时间复杂度是o(n)

    //优化：在上一个方法中，如果每次在[start,end]中有重复的元素，我们将滑动窗口从end处开始
    //需要定义一个hashmap保存字符到索引的映射
    public static int lengthOfLongestSubString2(String s){
        int n = s.length();
        int start = 0,end = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (;start<n&&end<n;end++){
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)),start); //如果有重复的元素，
            }
            map.put(s.charAt(end),end+1);
            res = Math.max(res,end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println( lengthOfLongestSubString(s));
        System.out.println(lengthOfLongestSubString2(s));
    }

}
