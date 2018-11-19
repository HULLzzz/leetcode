import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: Think
 * @Date: 2018/11/16 15:17
 * @Description:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 使用一个队列将每层的数据存储起来即可，使用广度优先搜索的方法，使用队列，每遍历一层节点将下一层节点
 * 将下一层节点放在队列中，遍历完一层的时候将这一层放到list中
 */
public class leetcode107_BTLevelOrderOutput2 {
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        //队列的offer和add区别：两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
        queue.offer(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            for (int i = 0;i<num;i++){
                if (queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            list.add(0,levelList);  //关键一步：将list放置在整体list之前
        }
        return list;
    }

}
