/**
 * @Auther: Think
 * @Date: 2018/11/13 20:53
 * @Description:
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 反转从位置m到n的链表，使用一趟扫描完成反转
 */
public class leetcode92_reverseLinkedList2 {
    public class Node{
        Node next;
        int val ;
        Node(int x){this.val = x;}
    }

    public Node reverse(Node head,int m,int n){
        if (head==null||head.next==null||m==n)
            return head;
        Node normal = head,last = null,pre,cur,gra = new Node(0);
        gra.next = head;
        pre = gra;
        cur = head;
        while (cur != null) {
            if (m==1){
                normal = cur;
                //链表反转，头拼接
                last = reverseList(cur,pre,n);
                normal.next = last;
                break;
            }
            cur = cur.next;
            pre = pre.next;
            m--;
            n--;
        }
        return gra.next;

    }

    private Node reverseList(Node head, Node first, int n) {
        Node pre = null;
        Node next = head;
        while(n>0){
            Node tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
            n--;
        }
        first.next = pre;
        return next;
    }
}
