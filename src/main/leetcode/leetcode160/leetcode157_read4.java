package leetcode160;

/**
 * @Auther: Think
 * @Date: 2018/12/13 14:36
 * @Description:
 * 这道题给了我们一个Read4函数，每次可以从一个文件中最多读出4个字符，如果文件中的字符不足4个字符时，返回准确的当前剩余的字符数。现在让我们实现一个最多能读取n个字符的函数。
 * 这题有迭代和递归的两种解法，我们先来看迭代的方法，思路是我们每4个读一次，然后把读出的结果判断一下，如果为0的话，说明此时的buf已经被读完，跳出循环，直接返回res和n之中的较小值。
 * 否则一直读入，直到读完n个字符，循环结束，最后再返回res和n之中的较小值
 */
public class leetcode157_read4 {
    public int read4(char[] buf4){return 0;}
    public int read(char[] buf,int n){
        if (n<=0)
            return 0;
        char[] buf4 = new char[4];
        int total = 0;
        boolean eof = false;
        while (!eof&&total<n){
            int read4 = read4(buf4);
            eof = read4 < 4;
            int copyCnt = Math.min(read4,n-total);
            for (int i = 0;i<copyCnt;i++){
                buf[total++] = buf4[i];  //TODO；total记录读取的位置，每次选4个字节靠辅助函数进行读取
            }
        }
        return total;
    }

    /*
    和那道read n不同的是这次call multiple times，问题就是当前的call可能存在多读了几个字节，那么下一次call read的时候要先算上上次多读的部分，所以要保存上次读的。和读一次一样有两种要考虑的case：

file读完了： read4(buf[]) == 0

file没读完，但是buf装满了read4(buf[]) > n - res
     */
    public int solution158(char[] buf,int n){
        char buff[] = new char[4];
        int start = 0;
        int num = 0;

        int res  = 0;
        while (res<n){
            if (start == 0)
                num = read4(buff);
            //finish read
            if (num == 0)
                break;
            while (res<n&&start<num){
                buf[res++] = buff[start++];
            }
            if (start == num)
                start = 0;
        }
        return res;
    }

}
