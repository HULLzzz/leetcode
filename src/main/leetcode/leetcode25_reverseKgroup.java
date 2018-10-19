package main.leetcode;

/**
 * @Auther: Think
 * @Date: 2018/10/9 11:11
 * @Description:反转链表
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 反转每k个节点的子链，链表节点数不为K个不做反转
 */
public class leetcode25_reverseKgroup {
    class Node{
        Node next;
        int val;
        public Node(int data){
            this.val = data;
        }
    }
    public Node reverseKgroup(Node head,int k){
        Node root = new Node(-1);
        root.next = head;
        Node res = root;
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            i++;
            tmp = tmp.next;
        }
        while (i >= k) {
            for (int j = 0;j<k-1;j++){
                Node node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
            }
            root = head;
            head = head.next;
            i -= k;
        }
        return res.next;
    }




}
