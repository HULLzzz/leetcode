package main.leetcode;

/**
 * @Auther: Think
 * @Date: 2018/9/27 11:16
 * @Description:
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class leetcode19_removeNnodeOfList {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    /*
    * 定义两个指针，一个指针比第二个指针先走n步
    * */
    public static Node Core(Node head,int n){
        if (head == null || head.next == null && n == 1) {
            return null;
        }
        Node node = head;
        Node delete = null;
        while (node != null) {
            if (n > 0) {
                n--;
            } else if (delete == null) {
                delete = head;
            }else {
                delete = delete.next;
            }
            node = node.next;
        }
        if (delete != null) {
            delete.next = delete.next.next;
        }
        else if (n==0){
            head = head.next;
        }
        return head;

    }
}
