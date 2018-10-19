import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/17 10:42
 * @Description: 本题和39题类似，只不过本题的数组不能重复使用且有重复
 * 递归的用法：递归本质上就是不断缩小问题规模，需要有明确的中止条件，比如本题的 if (tmp==target)
 */
public class leetcode40_combination2 {
    public List<List<Integer>> combination2(int[] candidates,int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        combinationSum(result,list,candidates,target,0);
        return result;
    }

    private void combinationSum(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index) {
        for (int i = index;i<candidates.length;i++){
            int tmp = candidates[i];
            if (tmp==target){
                list.add(tmp);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                break;
            }
            if (candidates[i]<target){
                list.add(candidates[i]);
                combinationSum(result,list,candidates,target-tmp,i+1);
                list.remove(list.size()-1);
                //重复的需要跳过，避免结果重复
                while (i<candidates.length-1&&candidates[i]==candidates[i+1]){
                    i++;
                }
            }
            if (tmp > target) {
                break;
            }
        }
    }
}
