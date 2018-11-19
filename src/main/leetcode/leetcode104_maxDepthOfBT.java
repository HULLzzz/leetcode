/**
 * @Auther: Think
 * @Date: 2018/11/17 17:12
 * @Description:
 */
public class leetcode104_maxDepthOfBT {
    int result = 0;
    public int maxDepth(TreeNode root){
        if (root==null)
            return 0;
        result = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return result;
    }
}
