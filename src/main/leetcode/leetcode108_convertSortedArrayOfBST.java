/**
 * @Auther: Think
 * @Date: 2018/11/16 14:48
 * @Description:
 * 将升序排列的有序数组转换为一颗高度平衡的二叉树
 * 这个题有点类似二分查找，根节点在正中间，左子树的根节点在左边一半数组的正中间，右子树的根节点在右边一半数组的正中间；
 * 于是可以递归解决：先确定根节点，然后构造左子树，然后构造右子树， 结束条件类似二分查找(low > high)。
 */
public class leetcode108_convertSortedArrayOfBST {
    public TreeNode solution(int[] nums){
        if (nums == null) {
            return null;
        }
        return convertTree(nums,0,nums.length-1);
    }

    private TreeNode convertTree(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (right+left) / 2;
            TreeNode newNode = new TreeNode(nums[mid]);
            newNode.left = convertTree(nums,left,mid-1);
            newNode.right = convertTree(nums,mid+1,right);
            return newNode;

        }else {
            return null;
        }
    }



    //leetcode109 将双向链表转换为BST NODE为链表类
    public TreeNode solution109(Node head){
        if (head==null)
            return null;
        if (head.next==null)
            return new TreeNode(head.val);

        //快慢指针快速查找链表中的中间值
        Node fast = head.next.next;
        Node slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //找到链表中点及右边链表的头部
        Node tmp = slow.next.next;
        TreeNode root = new TreeNode(slow.next.val);
        //切断
        slow.next = null;

        //递归
        root.left = solution109(head);
        root.right = solution109(tmp);
        return root;
    }
}
