/**
 * @Auther: Think
 * @Date: 2018/11/16 14:19
 * @Description:
 * 判断是否是平衡二叉树
 * 平衡二叉树的定义：空树，或者左右两个子树的高度的差绝对值不超过1
 * 递归判断二叉树是否为平衡二叉树，递归找二叉树的高度
 * 递归的中止条件：递归到叶子节点的时候中止，root.left==null&&root.right==null时返回1，root==null时返回0
 */
public class leetcode110_balancedBinaryTree {
    public boolean isBalanced(Node.TreeNode root){
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        //本节点满足平衡二叉树，判断左右子树是否满足
        if (left-right>=-1&&left-right<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }else {
            return false;
        }
    }

    private int height(Node.TreeNode root) {
        int lheight,rheight;
        if (root == null) {
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        lheight = height(root.left);
        rheight = height(root.right);

        return lheight>=rheight?lheight+1:rheight+1;
    }
}
