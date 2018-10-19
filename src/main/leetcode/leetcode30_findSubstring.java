import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Think
 * @Date: 2018/10/11 14:32
 * @Description:
 * For example, given:s: "barfoothefoobarman"words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 解题思路：题意比较难以理解，简单说，就是让words里的单词每个都（可以不分顺序）出现在索引之后有且只有一次。如果words里有【a，a】，那就是找含有aa的子串，如果是【b，a，a】，就是找 aab、aba、baa的子串索引
 * 参考 https://blog.csdn.net/sinat_34136785/article/details/81145699
 */
public class leetcode30_findSubstring {
    public List<Integer> findSubstring(String s,String[] words){
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null) {
            return list;
        }
        int slen = s.length();
        int wlen = words[0].length();
        int wslen = words.length;
        if (slen<wlen*wslen) return list;

        //记录word数组中每一个字符串的个数
        Map<String,Integer> map = new HashMap<>();
        for (String word:words){
            if (map.containsKey(word))
                map.put(word,map.get(word)+1);
            else
                map.put(word,1);
        }
        for (int i = 0;i<wlen;i++){
            //定义窗口的大小和左右边界
            int left = i,right = i,window = 0;
            while (right+(wslen-window)*wlen<=slen&&right+wlen<=slen){
                String cur = s.substring(right,right+wlen);
                if (map.containsKey(cur)){
                    int cnt = map.get(cur);
                    //包含当前字符串，窗口大小加1
                    window++;
                    if (cnt > 0){
                        map.put(cur,cnt-1);
                    }else {
                        //map当前的字符串个数位0说明出现了重复字符串
                        String removed = s.substring(left,left+wlen);
                        //从左边窗口移除字符串
                        while (!removed.equals(cur)) {
                            map.put(removed,map.get(removed)+1);//恢复移除字符串的个数
                            left+=wlen;
                            window--;
                            removed = s.substring(left,left+wlen);
                        }
                        left += wlen;
                        window--;
                    }
                    if (window==wslen)
                        list.add(left);  //窗口大小等于数组长度，匹配成功
                }else {
                    //恢复map
                    window = 0;
                    while (left < right) {

                    }
                }
            }
        }
        return list;
    }

}
