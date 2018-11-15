import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;

/**
 * @Auther: Think
 * @Date: 2018/11/6 14:55
 * @Description:
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00-0
 * 01-1
 * 10-2
 * 11-3
 *
 * 要求计算gray码
 * 但是如果对位运算很熟悉，那么这道题其实并不困难
 * 首先我们来看，随着n的变化，结果集也是规律变化的：
 * n = 0时， 0
 * n = 1时，（0），（1）
 * n = 2时，（00,01）， （10,11）
 * n = 3时，（000,001,010,011），（100,101,110,111）
 * 也就是说，每当n+1，则对原来数组中所有的数的首位插入1即可，同时造成数据扩大2倍
 * 所以dp转移方程： dp[k] = (1 << n) | dp[k-1]，其中2^(n-1) <= k < 2^n，（1<<n）表示首位为1其他为0的二进制数
 * 原文：https://blog.csdn.net/h_targaryen/article/details/83034115
 */
public class leetcode89_grayCode {
    public static ArrayList<Integer> solution(int n){
        ArrayList<Integer> arr = new ArrayList<>(1<<n);
        arr.add(0);
        for (int i = 0;i<n;i++){
            int high_bit = 1<<i;
            for (int j = arr.size()-1;j>=0;j--){
                arr.add(high_bit|arr.get(j));
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }

}
