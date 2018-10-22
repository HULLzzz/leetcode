import java.util.*;

/**
 * @Auther: Think
 * @Date: 2018/10/21 12:12
 * @Description:
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *  think:采用hashMap<String,List<String>> 每次将读入的字符串在map中查找（必须将字符串使用sort排序）
 */
public class leetcode49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<List<String>>();
        int len = strs.length;
        if (len<1) return result;
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        String tmp = "" ;

        for (int i = 0;i<len;i++){
            tmp = strs[i];
            char[] arrOfStr = tmp.toCharArray();
            Arrays.sort(arrOfStr);
            tmp = new String(arrOfStr);
            if (map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else {
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(tmp,item);
            }
        }
        for (List<String> value:map.values()){
            result.add(value);
        }
        return result;
    }

}
