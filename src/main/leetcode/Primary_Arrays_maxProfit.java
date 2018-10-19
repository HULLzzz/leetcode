import org.omg.CORBA.MARSHAL;

/**
 * @Author:
 * @Description: 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *               给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *               设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *               示例 1:
 *
 *               输入: [7,1,5,3,6,4]
 *               输出: 7
 *               解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *               随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *               思路：始终保存最小的买入价格
 *                    始终保存最大的收益价格
 * @params:
 * @Data: Created in  14:04 2018/8/27
 * @Modified By:
 */
//明天的价格比今天的价格贵的时候我们今天买，明天卖，这样能够获取最大利润。
public class Primary_Arrays_maxProfit {
    public static int maxprofit1(int[] prices){
        int max = 0;
        int size = prices.length;
        for (int i = 0;i<size-1;i++){
            if (prices[i]<prices[i+1]){
                max+=prices[i+1] - prices[i];
            }
        }
        return max;
    }

    //买卖股票的最佳时机1：只能进行单次交易（相当于求最长子序列）
    //动态规划：选取最小的买，最大的卖，O（N）
    public static int maxProfit2(int[] prices){
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int minbuy = prices[0];
        for (int i = 1;i<prices.length;i++){
            result = Math.max(result,prices[i]-minbuy);
            minbuy = Math.min(minbuy,prices[i]);
        }
    return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{7,4,1,3,4,5};
        int max = maxprofit1(nums);
        int max2 = maxProfit2(nums);
        System.out.println("solution2: "+ max2);
        System.out.println("solution1:  "+max);
    }
}
