import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/17 16:54
 * @Description:
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 联系102，107，本题是顶层往下，由于有层级的关系，需要判断level%2
 */
public class leetcode103_BTZigzag {
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root,res,0);
        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> res, int level) {
        if(node==null)
            return;
        if (res.size()<level+1){
            res.add(new LinkedList<Integer>());
        }
        if (level%2!=0){
            ((LinkedList<Integer>)res.get(level)).addFirst(node.val);
        }
        res.get(level).add(node.val);
        helper(node.left,res,level+1);
        helper(node.right,res,level+1);

    }
}
