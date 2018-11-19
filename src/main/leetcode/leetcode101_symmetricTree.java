/**
 * @Auther: Think
 * @Date: 2018/11/17 15:59
 * @Description: 给定二叉树判断他是否是镜像对称
 */
public class leetcode101_symmetricTree {
    public boolean solution(TreeNode root){
        if (root == null) {
            return true;
        }else {
            return solution(root.left,root.right);
        }
    }
    private boolean solution(TreeNode left,TreeNode right){
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val&&solution(left.left,right.right)&&solution(left.right,right.left);
    }
}
