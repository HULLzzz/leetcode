package java.leetcode120;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/19 10:26
 * @Description:
 * 给定非负整数num，生成杨辉三角的前num行，杨辉三角中，每个数是他左上方和右上方的数字之和
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class leetcode118_pasclTriangle {
    public List<List<Integer>> solution(int num){
        List<List<Integer>> res = new ArrayList<>();
        if (num < 1) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1;i<num;i++){
            ArrayList<Integer>  tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1;j<res.get(i-1).size();j++){
                tmp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;


    }


    //119 给定一个整数n，返回杨辉三角的第n行 优化算法到o(n)空间复杂度
    public List<Integer> solution119(int n){
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<=n;i++){
            res.add(1);
            for (int j = i-1;j>=1;j--){
                res.set(j,res.get(j)+res.get(j-1));
            }
        }
        return res;
    }


}
