package leetcode150;

/**
 * @Auther: Think
 * @Date: 2018/12/4 17:22
 * @Description:
 * 在O(nlogn)时间内，使用常数空间对链表进行排序。使用归并排序
 *
 */
public class leetcode148_sortList {
    public class Node{
        Node next;
        int val ;
        Node(int x){
            this.val = x;
        }
    }

    public Node sortList(Node head){
        if (head==null||head.next==null)
            return head;
        //todo: 快慢指针查找中间的节点
        Node fast = head;
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        Node right = slow.next;
        //todo: 将链表从中间断开 分
        slow.next = null;
        Node left = sortList(head);
        right = sortList(head);

        //治
        return merge(left,right);

    }

    //todo： 两个链表的合并
    private Node merge(Node n1, Node n2) {
        Node res = null;
        if (n1 == null) {
            return n2;
        }
        if (n2 == null)
            return n1;
        if (n1.val <= n2.val) {
            res = n1;
            n1.next = merge(n1.next,n2);
        }else {
            res = n2;
            n2.next = merge(n1,n2.next);
        }
        return res;
    }

    //leetcode 147 插入排序
    //todo: 保证前面的n-1序列都是排好序的，将n排序插入到前面的序列
    public Node insertionSortList(Node head){
        Node fakeNode = new Node(-1);
        fakeNode.next = head;
        if (head==null)
            return null;
        Node cur = head.next; //从第二个节点开始遍历
        Node pre = head; //排序好的最后一个节点
        while (cur != null) {
            if (cur.val < pre.val) {
                //todo: 保存下一个需要遍历的节点
                Node nextNode = cur.next;

                //todo: 寻找插入的合适位置
                Node cur2 = fakeNode.next;
                Node tmp = fakeNode;

                while (cur.val>cur2.val&&cur!=pre){
                    tmp = cur2;
                    cur2 = cur2.next;
                }
                //插入
                tmp.next = cur;
                cur.next = cur2;
                pre.next = nextNode;
                //继续遍历下一个节点
                cur = nextNode;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return fakeNode.next;
    }
}
