package leetcode130;




/**
 * @Auther: Think
 * @Date: 2018/11/23 21:04
 * @Description:
 * 计算二叉树中的路径之和的最大值，起止节点任意
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class leetcode124_BTmaximumPathSum {
    public class Tree{
        Tree left ;
        Tree right;
        int val;
        Tree(int x){
            this.val = x;
        }
    }
    private int maxVal = Integer.MIN_VALUE;
    public int maxPath(Tree root){
        if (root == null) return 0;
        maxCore(root);
        return maxVal;
    }

    private int maxCore(Tree root) {
        if (root == null) {
            return 0;
        }
        //以root为根的当前子树的最大路径和
        //如果左右子树都是负数
        //那么最大路径就是当前节点的值，无论当前节点正负
        int curValue = root.val;
        int lmax = maxCore(root.left);
        int rmax = maxCore(root.right);
        if (lmax>0)
            curValue +=lmax;
        if (rmax>0)
            curValue +=rmax;

        maxVal = Math.max(curValue,maxVal);
        //返回以当前root为根的子树的最大路径和
        //左右可能为负数，需要参与比较大小
        int thisMax = Math.max(root.val,Math.max(lmax+root.val,rmax+root.val));
        return thisMax;

    }

}
