/**
 * @Auther: Think
 * @Date: 2018/9/3 14:43
 * @Description: 判断一个数字是否是回文数
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class leetcode9_PalindromeNumber {
    /**
     *
     * @description: 总结如下：负数不是回文数，0是回文数，将输入的整数进行反转之后得到的数和原来的数相同即为回文数
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2018/9/3 14:44
     */
    public static boolean isPalindrome(int x){
        if (x==0)
            return true;
        else if (x < 0) {
            return false;
        }
        int temp = x;
        int contrast = 0;
        while (temp > 0) {
            contrast = contrast*10+temp%10;
            temp/=10;
        }
        return contrast==x;
    }

    public static void main(String[] args) {
        int x = 1234321;
        System.out.printf("isPlaindrome: "+isPalindrome(x));
    }

}
