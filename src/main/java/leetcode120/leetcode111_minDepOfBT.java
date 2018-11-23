/**
 * @Auther: Think
 * @Date: 2018/11/20 15:18
 * @Description:
 * 树的最小高度，我们使用递归的方法，注意和找最大高度的不同，最小高度定义为根节点到最近叶子节点的高度，如果遇到null的情况不能直接返回0
 * 例如单节点的情况，root.left只有left，但是root.left.right==null，将null赋值为0的话，这个节点不是叶子节点，可将null的值赋值为最大值
 * 保证能遍历到叶子节点结束
 */
public class leetcode111_minDepOfBT {
    public int solution(TreeNode root){
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int left,right;
        if (root.left!=null)
            left = solution(root.left);
        else
            left = Integer.MAX_VALUE;
        if (root.right!=null)
            right = solution(root.right);
        else
            right = Integer.MAX_VALUE;
        return Math.min(left,right)+1;

    }
}
