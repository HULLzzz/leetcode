package leetcode130;

/**
 * @Auther: Think
 * @Date: 2018/11/23 14:20
 * @Description:
 * 假如有一个数组，第i个元素是一支股票第i天的价格，设计一个算法计算最大的收入
 * 只能进行一次操作，即买入和卖出一股的股票
 * 输入: [7, 1, 5, 3, 6, 4]
 * 输出: 5
 *
 * 最大利润 = 6-1 = 5（不是 7-1 = 6, 因为卖出价格需要大于买入价格）
 * thinking：遇到临时最小的，就保存，计算后面比他大的差，保留最大差
 * 如果后面有更小的，就保存更小的
 */
public class leetcode121_BestTime2Buy {
    public int solution(int[] price){
        if (price==null||price.length<=1)
            return 0;
        int res = 0,tmp,inv;
        tmp = price[0];  //保存临时值
        for (int i = 1;i<price.length;i++){
            inv = price[i];
            if (tmp>inv){
                tmp = inv; //如果遇到比tmp小的值，将其设置为临时保存值
            }else {
                inv = inv - tmp; //计算差值
                res = res>inv?res:inv; //保存最大的差值为res
            }
        }
        return res;
    }

    //leetcode122 可以完成多次交易
    public int solution122(int[] prices){
        int maxPro = 0;
        int len = prices.length - 1;
        for (int i = 0;i<len;i++){
            if (prices[i]<prices[i+1]){
                maxPro+=prices[i+1]-prices[i];
            }
        }
        return maxPro;
    }


    //leetcode123 交易两次找出最大差
    //计算所有的price[0,i]到price[l,len-1]的和，分别存在firstPro[] 和 secondPro[]中，因为买之前必须卖出，price[0,i]的最大值可以和121题一样计算得出
    //price[l len-l]在i之后的最大值，即第一次卖出之后的最大值，可以倒序遍历，计算出最大值，最后找到firstPro和secondPro相加最大的值即可
    //【7、1、5、3、6、4】
    //买之前必须卖出

    public int solution123(int[] price){
        if (price==null||price.length<2) return 0;
        int len = price.length;
        int[] firstPro = new int[len];
        int[] secondPro = new int[len];
        int min = price[0];
        //总共两次交易，买入卖出和第二次买入卖出
        for (int i = 1;i<len;i++){
            min = Math.min(min,price[i]);
            firstPro[i] = Math.max(firstPro[i-1],price[i]-min);
        }
        int max = price[len-1];
        for (int i = len-1;i>=0;i--){
            max = Math.max(max,price[i]);
            secondPro[i] = Math.max(secondPro[i+1],max-price[i]);
        }
        int res = 0;
        for (int i = 0;i<len;i++){
            res = Math.max(res,firstPro[i]+secondPro[i]);
        }
        return res;
    }

}
