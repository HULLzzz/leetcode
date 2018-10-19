/**
 * @Auther: Think
 * @Date: 2018/10/11 14:14
 * @Description:
 * 不用乘除法实现两个数的除法，如果溢出则返回最大值
 */
public class leetcode29_divide {
    public int divide(int dividend,int divisor){
        boolean isPositive = true;
        if ((dividend < 0 && dividend > 0) || (dividend > 0 && divisor < 0)) {
            isPositive = false;
        }
        //判断正负，判断结束后全部按照整数进行操作
        //使用long解决数值溢出的问题
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend==0||ldividend<ldivisor)return 0;

        long result = divide(ldividend,ldivisor);
        if (result > Integer.MAX_VALUE) {
            return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)(isPositive?result:-result);
    }

    private long divide(long ldividend, long ldivisor) {
        if (ldividend<ldivisor) return 0;
        long sum = ldivisor;
        long result = 1;
        //二分法计算结果
        while (ldividend >= (sum + sum)) {
            sum+=sum;
            result+=result;
        }
        return result+divide(ldividend-sum,ldivisor);
    }

}
