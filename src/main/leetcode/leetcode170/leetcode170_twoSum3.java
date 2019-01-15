package leetcode.leetcode170;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Think
 * @Date: 2018/12/14 20:47
 * @Description: 170
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class leetcode170_twoSum3 {
    Map<Integer,Integer> dict = new HashMap<>();
    public void add(int num){
        if (dict.containsKey(num)){
            dict.put(num,dict.get(num)+1);
        }else {
            dict.put(num,1);
        }
    }

    public boolean find(int value){
        for (Integer key:dict.keySet()){
            if (value - key == key){
                if (dict.get(key) >= 2){
                    return true;
                }
            }
            else if (dict.containsKey(value - key)){
                return true;
            }
        }
        return false;
    }
}
