package leetcode.leetcode170;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Think
 * @Date: 2018/12/14 21:25
 * @Description:
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 *
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class leetcode166_Fraction2RecurringDecimal {
    //循环求数：每次作除，取整数部分，余数*10
    //如何判断重复：余数重复的时候 hashMap存储余数（key）和索引位
    //当余数重复的时候，则结束循环得到索引值
    //如何处理正负数：判断符号，转换成正数
    //如何处理溢出 如果输出位Integer.MIN_VALUE，取绝对值之后会溢出，先转换为long
    public String solution(int numerator,int denominator){
        long quo = 0,res = 0;
        String result = "";

        //特殊情况处理
        if (numerator == 0)
            return "0";
        if (denominator == 0){
            return "";
        }

        //结果是负
        if ((numerator>0&&denominator<0)||(numerator<0&&denominator>0)){
            result += "-";
        }

        //溢出处理并取正
        long num = numerator,
                deno = denominator;
        num = Math.abs(num);
        deno = Math.abs(deno);

        //整数部分的处理
        quo = num/deno;
        res = (num%deno)*10;
        result += Long.toString(quo);
        if (res == 0){
            return result;
        }

        //小数部分的处理
        Map<Long,Integer> map = new HashMap<>();
        int index = 0;

        result += ".";
        while (res != 0) {
            if (map.containsKey(res)) {
                index = map.get(res);
                result = result.substring(0,index)+"("+result.substring(index,result.length())+")";
                return result;
            }

            map.put(res,result.length());
            quo = res/deno;
            result += Long.toString(quo);
            res = (res%deno) * 10;

        }
        return result;
    }
}
