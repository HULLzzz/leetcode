package leetcode140;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther: Think
 * @Date: 2018/11/30 17:36
 * @Description:
 * 这题是要复制一个链表，这个链表比普通的链表多一个指针，这个指针可以指向任意地方，可以为空也可以为链表中的任一个节点
 */
public class leetcode138_copyListWithRandomPointer {
    public class Node {
        Node next;
        Node random;
        int val;
        Node(int x){this.val = x;}
    }
    public Node solution(Node head){
        HashMap<Node,Node> newMap = new HashMap<>();
        //将节点存入hash表
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newMap.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = newMap.get(cur);
            node.next = newMap.get(cur.next);
            node.random = newMap.get(cur.random);
            cur = cur.next;
        }
        return newMap.get(head);

    }
}
