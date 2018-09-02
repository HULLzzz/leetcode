/**
 * @Auther: Think
 * @Date: 2018/9/2 09:44
 * @Description: 这个题目即需要自己实现一个字符串解析整数的功能方法，总结如下
 *
 *              在没有遇到数字或正负号之前，只能出现空格否则不能转换。
 *              遇到数字或者正负号之后在遇见空格或者其他字符（包括正负号）转换停止之后的数字不在转换。
 *              转化的值可能会超出int范围，一旦转化的当前整数值超出int范围，停止转化。
 */
public class leetcode8_StringtoInteger {
    public int myAtoi(String str){
        boolean flag = false;  //表示是否之前出现过正负号，未出现之前只能接受空格字符，出现之后只能接受数字
        boolean posi = true;   //判断正负
        long res = 0;
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res*10+(c-'0');
            }
            else if (c=='-'&&!flag)
                posi = false;
            else if (c=='+'&&!flag)
                posi = true;
            else if(flag||!flag&&c!=' ')
                break;
            if(!flag&&c!=' ')
                flag = true;
            if(res-1>Integer.MAX_VALUE)
                break;

        }
        return posi?(int)Math.min(res,Integer.MAX_VALUE)
                :(int)Math.max(-1*res,Integer.MIN_VALUE);
    }

}
