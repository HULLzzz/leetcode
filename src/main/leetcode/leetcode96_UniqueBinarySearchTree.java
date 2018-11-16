/**
 * @Auther: Think
 * @Date: 2018/11/16 13:35
 * @Description:
 * 解题：
 * 用递归的思想，当只有0个或是1个节点的时候，只有一种；n个节点的时候有f(n)种:
 *
 * 左边可以有n-1个节点，右边0个节点，根据对称性可以左右互换，这时候有2*f(n-1)*f(0);
 *
 * 一边1个，另一边n-2个，这时候有2*f(1)*f(n-2);
 *
 * 一边两个，一边N-3个，这时候有2*f(2)*f(n-3);
 *
 * 。。。。。。
 *
 * 如果n为奇数，两边都是n/2个，这时候有f(n/2)*f(n/2)，如果n为偶数，一边n/2一边(n/2+1)个，为2*f(n/2)*f(n/2+1);
 * 代码参考原文：https://blog.csdn.net/u012249528/article/details/47807115
 */
public class leetcode96_UniqueBinarySearchTree {
    public int solution(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        int sum = 0;
        if (n % 2 == 0) {
            for (int k = n-1;k>=n/2;k--){
                sum += 2*solution(k)*solution(n-1-k);
            }
            return sum;
        }else {
            for (int k = n;k>n/2;k--){
                sum+=2*solution(k)*solution(n-1-k);
            }
            return sum+solution(n/2)*solution(n/2);
        }
    }
}
