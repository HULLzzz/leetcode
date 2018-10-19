import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/9/27 15:22
 * @Description:Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class leetcode23_mergeKSortedLists {
    public static class Node{
        int val ;
        Node next;
        public Node(){
            this.val = val;
        }
    }

    public static Node mergeKlist(Node[] lists){
        if (lists == null || lists.length == 0) {
            return null;
        }
        int begin = 0,end = lists.length - 1;
        while (begin < end) {
            int mid = (begin+end-1)/2;
            for (int i = 0;i<=mid;i++){
                lists[i] = merge2List(lists[i],lists[end-i]);
            }
            end = (begin+end)/2;
        }
        return lists[0];
    }

    public static Node merge2List(Node l1,Node l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        Node resultHead;
        if (l1.val < l2.val) {
            resultHead = l1;
            resultHead.next = merge2List(l1.next,l2);
        }
        else {
            resultHead = l2;
            resultHead.next = merge2List(l1,l2.next);
        }
        return resultHead;
    }
}
