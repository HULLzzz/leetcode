package leetcode160;

/**
 * @Auther: Think
 * @Date: 2018/12/13 12:00
 * @Description:
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 *
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *    旋转树
 *    给定一棵树，这棵树的右节点有两个选择，空节点，叶子节点（左节点一定存在）
 *    旋转树，结构对称，且做节点变换为：空姐点，叶子节点（右节点一定存在）
 *
 *    使用非递归的方式实现
 */
public class leetcode156_BTUpsideDown {
    public class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int x){this.val = x;}
        public TreeNode solution(TreeNode root){
            if (root == null||(root.left == null&&root.right == null)){
                return root;
            }
            TreeNode node = root;
            TreeNode nodeleft = root.left;
            TreeNode noderight = root.right;
            while (nodeleft != null) {
                TreeNode nodeChange = node;
                TreeNode nodeLeftChange = nodeleft;
                TreeNode nodeRightChange = noderight;
                node = nodeleft;
                nodeleft = node.left;
                noderight = node.right;
                nodeLeftChange.left = nodeRightChange;
                nodeLeftChange.right = nodeChange;

            }
            root.left = null;
            root.right = null;
            return node;
        }
    }
}
