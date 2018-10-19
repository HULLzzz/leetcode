package main.leetcode;

/**
 * @Auther: Think
 * @Date: 2018/10/8 17:10
 * @Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class leetcode24_swapNodeInPairs {
    class Node {
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    //使用递归的方法，因为每一段的头节点都可以在函数中返回
    public Node swapPairs(Node head){
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    //非递归方法
    public Node swapPair2(Node head){
        Node root = new Node(-1);
        root.next = head;
        Node pre = root;
        while (head != null && head.next != null) {
            Node node1 = head;
            Node node2 = head.next.next;
            root.next = head.next;
            root = root.next;
            root.next = node1;
            node1.next = node2;
            root = root.next;
            head = node2;
        }
        return pre;
    }

}
