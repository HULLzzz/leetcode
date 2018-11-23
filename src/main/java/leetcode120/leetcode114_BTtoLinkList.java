/**
 * @Auther: Think
 * @Date: 2018/11/20 20:40
 * @Description:
 */
public class leetcode114_BTtoLinkList {
    public void solution(TreeNode root){
        treeToList(root);
    }

    private TreeNode treeToList(TreeNode root) {
        if (root==null) return null;
        TreeNode right = treeToList(root.right);
        root.right = treeToList(root.left);
        root.left = null;
        TreeNode tmp = root;
        while (tmp.right!=null)
            tmp = tmp.right;
        return root;
    }
}
