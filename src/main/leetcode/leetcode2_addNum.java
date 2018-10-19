import java.util.LinkedList;

/**
 * @Author:
 * @Description:
 *          You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *          Example:
 *
 *          Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *          Output: 7 -> 0 -> 8
 *          Explanation: 342 + 465 = 807.
 * @params:
 * @Data: Created in  12:27 2018/8/29
 * @Modified By:
 */
public class leetcode2_addNum {

    public static void main(String[] args){
        LinkedList link1 = new LinkedList();
        link1.addLast(1);
        link1.addLast(2);
        LinkedList link2 = new LinkedList();
        link2.addLast(1);
        link2.addLast(9);
        link2.addLast(2);
        LinkedList resultLink = addTwoNums(link1, link2);
        for(Object i : resultLink){
            System.out.println(""+(int)i);
        }

    }

    //主要解决进位问题以及将链表倒序的元素正序输出
    public static LinkedList addTwoNums(LinkedList list1, LinkedList list2){
        int maxLength = 0;
        int minLength = 0;
        LinkedList res = null; //结果链表
        int carry = 0;
        if (list1.size() > list2.size()) {
            res = list1;
            maxLength = list1.size();
            minLength = list2.size();
        }else {
            res = list2;
            maxLength = list2.size();
            minLength = list1.size();
        }
        for (int i = 0;i<minLength;i++){
            carry = 0;
            int result = (int)list1.get(i)+(int)list2.get(i)+carry;
            if (result >= 10) {
                carry = (int)result/10;
                if (i == minLength - 1) {
                    //超处链表长度的进位处理
                    //没有超出最长的链表，不用加位置
                    if (i < maxLength - 1) {
                        res.set(i+1,(int)res.get(i+1)+carry);
                    }else {
                        res.addLast(carry); //超出最长链表需要加位置
                    }
                }
                res.set(i,result%10);
            }else {
                //不进位的情况
                res.set(i,result);
            }
        }
        return res;
    }
}
