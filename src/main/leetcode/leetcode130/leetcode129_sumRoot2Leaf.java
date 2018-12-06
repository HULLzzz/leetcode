package leetcode130;

/**
 * @Auther: Think
 * @Date: 2018/11/29 21:07
 * @Description:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class leetcode129_sumRoot2Leaf {
    public class TreeNode {
        TreeNode left,right;
        int val;
        TreeNode(int x){this.val = x;}
    }
    int sum;
    public int solution(TreeNode root){
        if (root == null) {
            return 0;
        }
        dfs(root,root.val);
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            sum+=num;
        }
        if (root.left != null) {
            dfs(root.left,num*10+root.left.val);
        }
        if (root.right != null) {
            dfs(root.right,num*10+root.right.val);

        }
    }
}
