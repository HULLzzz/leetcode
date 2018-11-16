/**
 * @Auther: Think
 * @Date: 2018/11/16 15:41
 * @Description:
 */
public class leetcode106_ConstructBT {
    //根据中序遍历和后续遍历还原二叉树
    public TreeNode solution(int[] inorder,int[] postoder){
        return helper(postoder.length-1,0,inorder.length-1,inorder,postoder);
    }

    private TreeNode helper(int poststart, int instart, int inend, int[] inorder, int[] postorder) {
        if (poststart<0||instart>inend)
            return null;
        TreeNode root = new TreeNode(postorder[poststart]);
        int inindex = 0;
        //根据根的值找到中序遍历的根，中序遍历中，根的左边为左子树，右边为右子树
        for (int i = instart;i<=inend;i++){
            if (inorder[i]==root.val){
                inindex = i;
                break;
            }
        }
        root.right = helper(poststart-1,inindex+1,inindex,inorder,postorder);
        root.left = helper(poststart-(inend-inindex)-1,instart,inindex,postorder,inorder);
        return root;
    }

    //根据前序和中序遍历还原二叉树
    public TreeNode solution105(int[] preorder,int[] inorder){
        return helper2(preorder,inorder,0,0,inorder.length-1);
    }

    private TreeNode helper2(int[] pre, int[] in, int prestart, int instart, int inend) {
        if (prestart>pre.length-1||instart>inend)
            return null;
        TreeNode root = new TreeNode(pre[prestart]);
        int index = 0;//记录根节点的位置
        for (int i = instart;i<inend;i++){
            if (root.val == in[i]){
                index = i;
                break;
            }
        }
        root.left = helper2(pre,in,prestart+1,instart,index-1);
        root.right = helper2(pre,in,prestart+index-instart+1,index+1,inend);
        return root;
    }
}
