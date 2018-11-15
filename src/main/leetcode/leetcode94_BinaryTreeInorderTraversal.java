import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/13 21:44
 * @Description:
 */
public class leetcode94_BinaryTreeInorderTraversal {
    public List<Integer> solution(Node.TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(Node.TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}
