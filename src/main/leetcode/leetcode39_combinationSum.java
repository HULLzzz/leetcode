import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/17 10:19
 * @Description: 给定一个数组和目标数，求出数组（可重复）中相加等于目标数的所有组合
 *  需要一个list来放数据（list），ans[]存相加结果等于target的数据，for循环中的return返回数据并跳出循环
 */
public class leetcode39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getResult(candidates,target,0,result,new int[target],0);
        return result;
    }

    private void getResult(int[] candidates, int target, int pos, List<List<Integer>> result, int[] ans, int num) {
        for (int i = pos;i<candidates.length;i++){
            if (target==candidates[i]){
                List<Integer> list = new ArrayList<Integer>();
                for (int j = 0;j<num;j++)
                    list.add(ans[j]);
                list.add(candidates[i]);
                result.add(list);
                return;
            }
            else if (target>candidates[i]){
                ans[num] = candidates[i];
                getResult(candidates,target-candidates[i],i,result,ans,num+1);

            }else
                return;
        }
    }
}
