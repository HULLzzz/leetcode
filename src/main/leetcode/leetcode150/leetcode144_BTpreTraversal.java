package leetcode150;

import sun.awt.image.ImageWatched;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/12/6 21:34
 * @Description:
 * 树的先序遍历： 先访问根节点，再访问左节点，右节点
 */
public class leetcode144_BTpreTraversal {
    public class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int x){this.val = x;}
    }
    public List<Integer> solution144(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                res.add(top.val);
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        return res;


    }

    //145 postTraversal 后序遍历
    public List<Integer> postOder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            postOder(root.right);
            postOder(root.left);
            res.add(root.val);
        }
        return res;
    }
}
