import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * @Auther: Think
 * @Date: 2018/11/17 16:11
 * @Description:
 * 本题是从顶层往下，107是从底层往上遍历 https://blog.csdn.net/crazy1235/article/details/51524241
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class leetcode102_BTlevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size()!=0){
            int num = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            for (int i = 0;i<num;i++){
                if (queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            list.add(0,levelList);

        }




        return list;
    }

    public List<List<Integer>> solution107(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            List<Integer> levelList = new ArrayList<>();
            for (TreeNode child:queue){
                levelList.add(child.val);
            }
            list.add(new ArrayList<>(levelList));
            Queue<TreeNode> queue2 = queue;
            queue = new LinkedList<>();
            for (TreeNode child:queue2){
                if (child.left != null) {
                    queue.add(child.left);
                }
                if (child.right!=null){
                    queue.add(child.right);
                }
            }
            Collections.reverse(list);

        }
        return list;
    }
}
