package java.leetcode120;




/**
 * @Auther: Think
 * @Date: 2018/11/19 14:08
 * @Description:
 * For example,
 * Given the following perfect binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * 题解：
 *
 * 递归调用，如果root.next不为null, root.right.next 等于 root.next.left, 然后root.left.next指向root.right.
 *
 * Time Complexity: O(n), 每个点访问不超过两遍. Space: O(logn).
 */
public class leetcode116_populatingNextRightPointer {
    public class TreeNode{
        int val;
        TreeNode left,right,next;
        TreeNode(int x){this.val = x;}
    }
    public void solution(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.right!=null&&root.next!=null){
            root.right.next = root.next.left;
        }
        if (root.left!=null){
            root.left.next = root.right;
        }
        solution(root.right);
        solution(root.left);
    }

    /*
    *leetcode 117
     1
   /  \
  2    3
 / \    \
4   5    7



After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
    * */

    public void solution117(TreeNode root){
        //使用dummy节点记录当前遍历的层，从当前层开始进行遍历
        TreeNode dummy = new TreeNode(0);
        TreeNode pre = dummy;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                root = dummy.next;
                pre = dummy;
                dummy.next = null;
            }
        }
    }

}
