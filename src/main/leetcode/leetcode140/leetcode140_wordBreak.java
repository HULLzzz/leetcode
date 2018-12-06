package leetcode140;

import com.sun.org.apache.regexp.internal.RE;
import jdk.internal.dynalink.linker.LinkerServices;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @Auther: Think
 * @Date: 2018/11/30 14:49
 * @Description:
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 */
public class leetcode140_wordBreak {
    public List<String> solution2(String s,List<String> wordDic){
        return dfs(s,wordDic,new HashMap<String,LinkedList<String>>());
    }

    private List<String> dfs(String s, List<String> wordDic, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length()==0){
            res.add("");
            return res;
        }
        for (String word: wordDic){ //对表中的单词进行遍历，找出每个s.startsWith(word)
            if (s.startsWith(word)){
                //substring 参数 start是必须的
                List<String> subList = dfs(s.substring(word.length()),wordDic,map);
                for (String sub: subList)
                    res.add(word+(sub.isEmpty()?"":" ")+sub);
            }
        }
        map.put(s,res);
        return res;
    }


    //给出一个字符串数组作为字典dict与一个目标字符串，在数组中查找字符串能否拼接成目标字符串。举个例子，s = "leetcode", dict = ["leet", "code"]，那么s可以由字典中的leet和code组成；再举一个例子，s = "cars", dict = ["car", "ca","rs"]，那么s可以由字典中的ca和rs组成。
   public boolean solution139(String s ,List<String> dict){
        int len = s.length();
        //dp[i]表示前i个字符能不能被完美切分
       boolean[] dp = new boolean[len+1];
       dp[0] = true;
       for (int i = 1;i<=len;i++){
           for (int j = 0;j<i;j++){
               //substring 是前闭后开
               String tmp = s.substring(j,i);
               if (dp[j] && dict.contains(tmp)) {
                   dp[i] = true;
                   break;
               }
           }

       }
       return dp[len];

   }

}
