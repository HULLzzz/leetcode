package leetcode.leetcode170;

/**
 * @Auther: Think
 * @Date: 2018/12/14 21:01
 * @Description:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 *  1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *
 *
Excel序是这样的：A~Z, AA~ZZ, AAA~ZZZ, ……
 */
public class leetcode169_ExcelSheetColTitle {
    //实际上就是26位循环一次，注意n是从1开始 计算ascci值的时候需要-1
    public String solution(int n){
        String s = "";
        while (n!=0){
            int tmp = (n-1)%26;
            s = (char)('A'+tmp) + s;
            n = (n-1)/26;
        }
        return s;
    }


}
