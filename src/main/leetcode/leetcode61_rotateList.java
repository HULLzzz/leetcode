import java.util.ArrayList;

/**
 * @Auther: Think
 * @Date: 2018/10/25 15:20
 * @Description:
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 */
public class leetcode61_rotateList {
    class Node{
        int val ;
        Node next;
        Node(int x){
            this.val = x;
        }
    }

    public Node Solution(Node head,int k){
        if (head==null)
            return head;
        Node tmp = head;
        int len = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        tmp.next = head;
        k = k%len;
        for (int i = 0;i<len-k-1;i++){
            head = head.next;
        }
        tmp = head;
        head = head.next;
        tmp.next = null;
        return head;
    }

    //优化：空间换时间
    public Node Solution2(Node head,int k){
        if (head == null) {
            return head;
        }
        Node tail = head;
        int len = 1;
        ArrayList<Node> list = new ArrayList<>();
        while (tail.next!=null){
            list.add(tail);
            tail = tail.next;
            len++;
        }
        list.add(tail);
        tail.next = head;
        k = k%len;
        k =len - k -1;
        tail = list.get(k);
        head = tail.next;
        tail.next = null;
        return head;
    }
}
