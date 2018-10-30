/**
 * @Auther: Think
 * @Date: 2018/10/30 13:43
 * @Description:
 * 长度为n的楼梯，每次只能爬一步或者两步，求爬完楼梯一共多少种爬法
 * 典型的动态规划：到第i步只有两种方法：要么从i-2爬两步，要么从i-1爬一步，所以d(i)=d(i-2)+d(i-1)
 * 即到第i-1步的走法加上到i-2的走法
 */
public class leetcode70_ClimingStairs {
    public int solution(int n ){
        int[] arr = new int[n]; //记录每一步有多少种走法
        arr[0] = 1;
        if (n == 1) {
            return 1;
        }
        arr[1] = 2;
        for (int i = 2;i<n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

}
