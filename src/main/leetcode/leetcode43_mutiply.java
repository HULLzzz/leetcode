/**
 * @Auther: Think
 * @Date: 2018/10/19 14:34
 * @Description: 大数相乘，设计程序将溢出结果转换为String
 * 解：为了避免溢出，显然应该考虑对应位相乘，求结果的每一位的值最后串在一起。
 * 比如，217*561，个位=7*1，十位=1*1+7*6，百位 = 7*5+1*6+2*1，千位=2*6+1*5，万位=2*5。分别存进数组里面，在考虑低位向高位的进位。转换为字符串之后考虑首位为0的情况。
 *
 * think: 关于大数处理，相乘可先进行单独位想乘，然后再考虑进位情况，最后一定要考虑去除首段的‘0’
 * 原文：https://blog.csdn.net/qq_32199531/article/details/52760362
 */
public class leetcode43_mutiply {
    public String mutiply(String num1,String num2){
        //字符串反转
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        //两数想成，最大位数是两者位数之和
        int[] b = new int[num1.length()+num2.length()];
        for (int i = 0;i<num1.length();i++){
            for (int j = 0;j<num2.length();j++){
                //先获取对应位相乘，不考虑进位
                b[i+j] +=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');

            }
        }
        for (int i = 0;i<num1.length()+num2.length();i++){
            //对进位进行处理
            if (b[i]>9){
                b[i+1] += b[i]/10;
                b[i] %=10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = num1.length()+num2.length()-1;i>=0;i--){
            stringBuilder.append(b[i]);
        }

        while (stringBuilder.charAt(0)=='0'&&stringBuilder.length()>1)
            stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }
}
