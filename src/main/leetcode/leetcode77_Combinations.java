import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/2 21:35
 * @Description:
 * 题意及分析：给出一个n和k,要求求出由n中k个不同的数组成是序列，序列为升序排序。这道题要求所有可能的情况，显然我们可以使用回溯的方法求解，对于每次判断的边界条件为：后面的数要大于前面的数。而且由于这里1到n肯定是递增的，所以继续进行下一层运算的条件可以为 当前位置后面的数。具体看代码实现。
 * 代码参考： https://www.cnblogs.com/271934Liao/p/6962789.html
 */
public class leetcode77_Combinations {
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        backtracking(res,list,1,1,n,k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int t, int start,int n, int k) {
        if (t>k){
            res.add(new ArrayList<>(list));
        }else {
            for (int i = start;i<=n;i++){
                list.add(i);
                backtracking(res,list,t+1,i+1,n,k);
                list.remove(list.size()-1);
            }
        }
    }

}
