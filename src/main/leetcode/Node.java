import java.util.LinkedList;

/**
 * @Auther: Think
 * @Date: 2018/11/13 21:50
 * @Description:
 */
public class Node {
    public class TreeNode {
        TreeNode left ;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public class LinkList{
        LinkedList next;
        int val;
        LinkList(int x){
            this.val = x;
        }
    }
}
