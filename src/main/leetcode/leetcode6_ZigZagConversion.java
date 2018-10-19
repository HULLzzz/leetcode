/**
 * @Auther: Think
 * @Date: 2018/9/1 15:31
 * @Description:  将字符串以Z字形输出
 *              Input: s = "PAYPALISHIRING", numRows = 3
 *              Output: "PAHNAPLSIIGYIR"
 *
 *              Input: s = "PAYPALISHIRING", numRows = 4
 *              Output: "PINALSIGYAHRPI"
 *              Explanation:
 *
 *              P     I    N
 *              A   L S  I G
 *              Y A   H R
 *              P     I
 *
 */
public class leetcode6_ZigZagConversion {
    public static String convert(String s,int nRows){
        if (s == null || nRows == 1) {
            return s;
        }
        //字符个数
        int len = s.length();
        //步长
        int step = nRows*2-2;
        if (len <= nRows) {
            return s;
        }
        //结果容器
        StringBuffer res = new StringBuffer();
        //计算两个索引
        int[] index1 = new int[nRows];
        int[] index2 = new int[nRows];
        //填充两个索引数组
        int j = 0;
        for (int i =0;i<nRows;i++){
            index1[i] = j++;
        }
        index2[0] = -1;
        index2[nRows-1] = -1;
        for (int i = nRows - 2;i>0;i--){
            index2[i] = j++;
        }
        //填充结果存容器
        for (int i = 0;i<nRows;i++){
            int k = 0;
            int ind;
            while ((ind = index1[i] + k * step) < len) {
                res.append(s.charAt(ind));
                if (index2[i] != -1 && (ind = index2[i] + k * step) < len) {
                    res.append(s.charAt(ind));
                }
                k++;
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String res = convert(s,4);
        System.out.printf("result: "+res);

    }

}
