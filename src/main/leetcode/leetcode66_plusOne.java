/**
 * @Auther: Think
 * @Date: 2018/10/30 20:41
 * @Description: 给定一个非负整数组成的非空数组，再此数的基础上加1返回一个新的数组
 */
public class leetcode66_plusOne {
    public int[] plusOne(int[] digits){
        int carry = 1;
        int i = digits.length - 1;
        while (i>=0&&carry>0){
            int sum = digits[i]+carry;
            carry = sum/10;
            digits[i] = sum % 10;
            --i;
        }
        if (carry > 0) {
            int[] newArr = new int[digits.length+1];
            System.arraycopy(digits,0,newArr,1,digits.length);
            newArr[0] = carry;
            return newArr;
        }
        return digits;
    }

}
