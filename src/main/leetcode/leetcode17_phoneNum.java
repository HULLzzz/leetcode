import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/9/19 15:50
 * @Description:
 *
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class leetcode17_phoneNum {
    public static List<String> Core(String digits){
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        Core(digits,0,"",result);
        return result;
    }
    public static void Core(String target,int count,String str,List<String> result){
        if (target.length() == count) {
            result.add(str);
            return ;
        }
        int temp = target.charAt(count) - '0';
        if (temp == 0 || temp == 1) {

        }
    }
}
