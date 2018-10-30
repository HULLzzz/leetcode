/**
 * @Auther: Think
 * @Date: 2018/10/30 13:51
 * @Description: 求x的平方根，返回类型是整数
 */
public class leetcode69_mySqrt {
    //二分法：
    public int mySqrt(int x){
        int l = 1,r = x;
        int mid = (l+r)/2;
        while (l <= r) {
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
            mid = (l+r)/2;
        }
        return mid;
    }

}
