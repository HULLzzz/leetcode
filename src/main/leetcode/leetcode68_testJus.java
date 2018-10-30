import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/30 20:02
 * @Description:
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 *
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 代码参考https://blog.csdn.net/xuyueqing1225/article/details/75946438
 */
public class leetcode68_testJus {
    public List<String> Jus(String[] words,int maxWid){
        if (words == null || words.length == 0) {
            return new ArrayList<String>();
        }
        int len = words.length;
        int index = 0;
        int num = 0;
        int len1 = 0;
        int len2 = 0;

        List<String> result = new ArrayList<String>();
        List<String> strsub = new ArrayList<String>();

        while (index < len) {
            int strlen = words[index].length();
            if (len1 + strlen <= maxWid) {
                strsub.add(words[index]);
                len1+=strlen+1;
                len2+=strlen;
                index++;
            }
            else {
                int spacenum = maxWid - len2;
                String f= "";
                while (!strsub.isEmpty()) {
                    int size = strsub.size()-1;
                    int snum;
                    if (size==0)
                        snum = spacenum;
                    else {
                        snum = spacenum/size;
                        if (spacenum%size!=0)
                            snum+=1;
                    }
                    spacenum -= snum;
                    f+=strsub.remove(0);
                    for (int i = 0;i<snum;i++){
                        f+="";
                    }
                }
                result.add(f);
                strsub.clear();
                len1 = 0;
                len2 = 0;
            }
        }
        return result;

    }
}
