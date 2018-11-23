import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/20 20:28
 * @Description:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class leetcode113_sumPath2 {
    public List<List<Integer>> solution(TreeNode root,int sum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(res,list,root,sum);
        return res;
     }

    private void backTrack(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root==null) return;
        list.add(root.val);
        if (root.left==null&&root.right==null&&root.val==sum){
            res.add(new ArrayList(list));
        }
        else {
            backTrack(res,list,root.left,sum-root.val);
            backTrack(res,list,root.right,sum-root.val);
        }
    }
}
