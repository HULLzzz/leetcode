/**
 * @Auther: Think
 * @Date: 2018/11/20 20:19
 * @Description:
 * 给定一个二叉树和一个和，判断从树的根节点到叶子节点的所有节点和是否等于给定的和
 */
public class leetcode112_sumPath {
    private boolean stop = false; //判断是否已经找到答案
    public boolean hasPathSum(TreeNode root,int sum){
        solution(root,0,sum);
        return stop;
    }

    private void solution(TreeNode node, int cur, int sum) {
        if (!stop && node != null) {
            //还没有找到答案且处理的节点不为空
            if (node.left==null&&node.right==null&&(node.val+cur==sum)){
                stop = true;
            }
            //非叶节点，继续处理
            if (node.left != null) {
                solution(node.left,cur+node.val,sum);
            }
            if (node.right!=null){
                solution(node.right,cur+node.val,sum);
            }
        }
    }

}
