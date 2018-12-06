package leetcode150;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

/**
 * @Auther: Think
 * @Date: 2018/12/6 21:20
 * @Description:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class leetcode143_recorderList {
    public class Node{ Node next; int val ; Node(int x){this.val = x;}}
    //todo: 找到中间节点，将链表从中间节点断开，将后半截链表反转，之后合并两个链表
    public void solution(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        //mid Node
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next.next;
        }
        Node second = slow.next;
        //div 2 list
        slow.next = null;
        second = reverseList(second);

        Node first = head;
        //merge 2 list
        while (second != null) {
            Node next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
        }
    }

    private Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
