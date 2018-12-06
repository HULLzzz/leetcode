package leetcode130;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Think
 * @Date: 2018/11/29 21:50
 * @Description:
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 给出两个单词，和一个字典，找到从start到end的最短转换序列
 */
public class leetcode127_wordLadder {
    private boolean onlyOneChange(String s1,String s2){
        int count = 0;
        for (int i = 0;i<s1.charAt(i);i++){
            if (s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        return count == 1?true:false;
    }
    //前后两个一起查询
    public int solution(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> hashSet = new HashSet<>(); //保存已经使用过的word
        Set<String> beginSet = new HashSet<String>(),endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;
        while (!beginSet.isEmpty()&&!endSet.isEmpty()){
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
                //每次查找较小的
            }
            HashSet<String> tmp = new HashSet<>();
            for (String str : beginSet){
                for (int i=0;i<wordList.size();i++){
                    String a = wordList.get(i);
                    if (onlyOneChange(str,a)&&endSet.contains(a))
                        return level+1;
                    if (!hashSet.contains(a) && onlyOneChange(str, a)) {
                        hashSet.add(a);
                        tmp.add(a);
                    }
                }
            }
            beginSet = tmp;
            level++;
        }
        return 0;
        //代码来自https://www.cnblogs.com/271934Liao/p/7716554.html
    }
}
