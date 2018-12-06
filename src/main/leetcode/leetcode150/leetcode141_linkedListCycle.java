package leetcode150;

/**
 * @Auther: Think
 * @Date: 2018/12/6 20:55
 * @Description:
 * 给定一个链表，判断链表是否有环
 */
public class leetcode141_linkedListCycle {
    public class Node {Node next;int val; Node(int x){this.val = x;}}
    public boolean hasCycle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast!=null&&fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
            if (slow==fast) return true;
        }
        return false ;
    }

    //142 给定一个链表，返回链表入环的第一个节点，如果没环就返回-1
    public Node solution142(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head,slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        //fast 到环入口的距离就是head到环入口的距离
        while (fast != slow) {
            slow = slow.next.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
