import javax.swing.event.InternalFrameEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/9/27 14:01
 * @Description:Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class leetcode21_mergeTwoLists {
    public static class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node Core(Node list1,Node list2){
        if (list1==null)return list2;
        if (list2==null)return list1;

        Node resultHead;
        if (list1.val < list2.val) {
            resultHead = list1;
            resultHead.next = Core(list1.next,list2);
        }else {
            resultHead = list2;
            resultHead.next = Core(list1,list2.next);
        }
        return resultHead;
    }
}
