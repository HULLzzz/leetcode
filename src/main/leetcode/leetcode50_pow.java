/**
 * @Auther: Think
 * @Date: 2018/10/21 12:05
 * @Description:  给定两个数，求幂次
 */
public class leetcode50_pow {

    public  static double pow(double x,int n ){
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2==0)?pow(x*x,n/2):x*pow(x*x,n/2);
    }

    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println(pow(x,n));
    }
}
