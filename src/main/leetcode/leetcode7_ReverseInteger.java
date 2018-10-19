/**
 * @Auther: Think
 * @Date: 2018/9/2 09:11
 * @Description:
 *              Input: -123
 *              Output: -321
 *              Input: 120
 *              Output: 21
 *              Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class leetcode7_ReverseInteger {
    /**
     *
     * @description:  将整数除以10后的余数不断的添加到新数的末尾做个位数，不断的进行迭代运算
     *                关于整数溢出的问题：将拿到的新数做一下判断即可
     *                例如x=1534236469，反转后result应为9646324351，但Integer.MAX_VALUE=2147483647,导致溢出
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2018/9/2 9:18
     */
    public static int reverse(int x){
        int result = 0;
        while (x != 0) {
            int num = x%10;
            int res = result*10 + num;
            if ((res - num) / 10 != result) {
                return (res - num) / 10;
            }
            result = res;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        int n = reverse(x);
        System.out.printf("reverse : "+ n);
    }

}
