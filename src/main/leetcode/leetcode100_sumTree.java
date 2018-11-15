/**
 * @Auther: Think
 * @Date: 2018/11/12 19:31
 * @Description:
 * 给定两个二叉树，判断两个树是否相等
 * 仅当两棵树结构相同且结点值都相等的时候，两个树相等
 */
public class leetcode100_sumTree {
    public class Node{
        int val;
        Node left;
        Node right;
        Node(int x){
            this.val = x;
        }
    }

    public boolean isSame(Node n1,Node n2){
        if (n1==null&&n2==null){
            return true;
        }
        if (n1!=null&&n2==null){
            return false;
        }
        if (n1==null&&n2!=null){
            return false;
        }
        return n1.val==n2.val&&isSame(n1.left,n2.left)&&isSame(n1.right,n2.right);
    }
}
