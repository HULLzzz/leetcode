/**
 * @Auther: Think
 * @Date: 2018/10/30 20:31
 * @Description:
 */
public class leetcode67_addBinary {
    public String addBinary(String a,String b){
        int maxLen = Math.max(a.length(),b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0;i<maxLen;i++){
            //从右边开始逐位取出字符串，较短的字符串用0补齐
            int tmpA = a.length()>i?a.charAt(a.length()-i-1):0;
            int tmpB = b.length()>i?b.charAt(b.length()-i-1):0;
            sb.insert(0,(tmpB+tmpA+carry)%2);//左侧插入
            carry = tmpA+tmpB+carry>1?1:0;
        }
        //最高位有进位的话还要加1
        if (carry == 1) sb.insert(0,1);
        return sb.toString();


    }
}
