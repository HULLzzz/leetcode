import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/13 21:19
 * @Description:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 参考：https://blog.csdn.net/mine_song/article/details/70210397
 */
public class leetcode93_restoreIPAddress {
    public List<String> restore(String s){
        List<String> res = new ArrayList<>();
        solution(s,"",res,0);
        return res;
    }

    private void solution(String s, String tmp, List<String> res, int n) {
        //ip不会超过三位
        if (s.length()>3*(4-n)){
            return;
        }
        if (n==4){
            if (s.length() == 0)
                //去掉最后一个点
                res.add(tmp.substring(0,tmp.length()-1));
            return;
        }
        for (int k = 1;k<=3;k++){
            //如果剩余的长度不够k说明不能排列为ip
            if (s.length()<k)
                break;
            int val = Integer.parseInt(s.substring(0,k));
            if (val>255||k!=String.valueOf(val).length())
                continue;
            solution(s.substring(k),tmp+s.substring(0,k)
            +".",res,n+1);
        }

    }

}
