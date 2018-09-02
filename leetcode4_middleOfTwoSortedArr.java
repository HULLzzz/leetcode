/**
 * @Author:
 * @Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *               Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *               nums1 = [1, 2]
 *               nums2 = [3, 4]
 *               The median is (2 + 3)/2 = 2.5
 * @params:
 * @Data: Created in  10:21 2018/8/30
 * @Modified By:
 */

//如果将两个数组合并再排序找到中位数，时间复杂度是o(nlogn)
    //使用分治法，将找中位数的问题划分为多个区域，使用递归进行求解
    //think: 使用分治法将问题划分为多个区域  针对一种情况（奇数）（m<n)的情况进行求解
    //       寻找的是第k个数，将寻找范围不断缩小，将区域分为k/2 k/2进行寻找，如果a[k/2]<b[k/2]则a的前k/2部分就可以丢弃，这样一直找到两数相等或者k==1的时候输出即可

public class leetcode4_middleOfTwoSortedArr {
    public static double findKth(int[] a,int begina,int m,int[] b,int beginb,int n,int k){
        if (m>n)
            return findKth(b,beginb,n,a,begina,m,k);
        if (m==0){
            return b[beginb+k-1];
        }
        if (k==1){
            return Math.min(a[begina],b[beginb]);
        }
        //m<n的情况 将k分为两个部分
        int ma = Math.min(k/2,m),mb = k - ma; //将k分为两部分
        //将a数组的前ma个元素丢弃，第k小的元素不在这里
        if (a[begina + ma - 1] < b[beginb+mb-1]) {
            return findKth(a,begina+ma,m-ma,b,beginb,n,k-ma);
        }else if (a[begina+ma-1]>b[beginb+mb-1]){
            return findKth(a,begina,m,b,beginb+mb,n-mb,k-mb);
        }else return a[begina+ma-1]; //相等的时候就是它

    }
    public static double findMidSortedArr(int a[],int b[]){
        int m = a.length;
        int n = b.length;
        int totalLen = m+n;
        if (totalLen % 2 == 1) { //奇数长度
            return findKth(a,0,m,b,0,n,totalLen/2+1);
        }
        //偶数长度
        else {
            return (findKth(a,0,m,b,0,n,totalLen/2)+findKth(a,0,m,b,0,n,totalLen/2+1))/2;
        }
    }
    public static void main(String[] args){
        int[] a={1,2,5,9};
        int[] b={3,4,6,7,10};
        double median=findMidSortedArr(a,b);
        System.out.println(median);

    }

    //（1，2，5，9）-->a  m=4    (3,4,6,7，10)-->b  n=5  k=4 输出是5
    //
}
