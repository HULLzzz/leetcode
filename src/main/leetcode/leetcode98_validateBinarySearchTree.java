import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: Think
 * @Date: 2018/11/13 14:58
 * @Description:
 * 判断是不是二叉搜索树，中序遍历树看输出的数字是否有序即可
 */
public class leetcode98_validateBinarySearchTree {
    public class Node{
        int val;
        Node left;
        Node right;
        Node(int x){
            this.val = x;
        }
    }
    public boolean isValidBST(Node root){
        if (root == null || root.left == null || root.right == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        midSearch(root,list);
        int tmp = 0,w = 0;
        Iterator<Integer> iter = list.iterator();
        if (iter.hasNext()) {
            tmp = iter.next();
        }
        while (iter.hasNext()) {
            w = iter.next();
            if (w<=tmp){
                return false;
            }
            tmp = w;
        }
        return true;
    }

    private void midSearch(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            midSearch(root.left,list);
        }
        list.add(root.val);
        if (root.right != null) {
            midSearch(root.right,list);
        }
    }

}
