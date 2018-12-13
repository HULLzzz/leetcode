package leetcode.leetcode160;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Hashtable;

/**
 * @Auther: Think
 * @Date: 2018/12/12 15:14
 * @Description:
 * 相交链表，求出相交点
 * 1.使用hashtable将link1的值放入一个hashtable中，在table中查找link1的值
 *
 */
public class leetcode160_intersectionOfLinkedList {
    public class Node {Node next;int val;  Node(int x){this.val = x;}}
    public Node getIntersectionNode(Node headA,Node headB){
        if (headA == null || headB == null){
            return null;
        }
        Node cur1 = headA;
        Node cur2 = headB;
        Hashtable<Node,Integer> table = new Hashtable<>();
        while (cur1 != null) {
            table.put(cur1,1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (table.get(cur2) != null) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }


    //走过一段共同的差值即可，a到达终点的时候指向b的头节点，b到达终点的时候指向a节点，这是后再一起移动会在交点处相交
    public  Node solution2(Node headA,Node headB){
        if (headA == null || headB == null) {
            return null;
        }
        Node cur1 = headA,cur2 = headB;
        while (cur1 != cur2){
            if (cur1 == null) {
                cur1 = cur2;
            }
            else
                cur1 = cur1.next;
            if (cur2 == null)
                cur2 = cur1;
            else
                cur2 = cur2.next;

        }
        return cur1;
    }
}
