package leetcode160;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;
import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.net.InterfaceAddress;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Auther: Think
 * @Date: 2018/12/7 15:15
 * @Description:
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * Input: "
 * the sky is blue
 * ",
 * Output: "
 * blue is sky the
 * ".
 */
public class leetcode151_reverseWordInString {
    public String reverse(String s ){
        char[] ch = s.toCharArray();
        int index = 0;
        LinkedList<String> list = new LinkedList<>();
        while (index < ch.length) {
            //剔除空格
            while (index < ch.length && ch[index] ==' ') {
                index++;
            }
            StringBuilder sb = new StringBuilder();
            while (index<ch.length&&ch[index]!=' '){
                sb.append(ch[index++]);

            }
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
        }
        //倒序迭代器
        Iterator<String> ite = list.descendingIterator();
        StringBuilder str = new StringBuilder();
        while (ite.hasNext()) {
            str.append(ite.next());
            if (ite.hasNext()) str.append(" ");
        }
        return str.toString();
    }

}
