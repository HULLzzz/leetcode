package leetcode160;

/**
 * @Auther: Think
 * @Date: 2018/12/13 15:10
 * @Description: 最多有两个字符不同的最长子串
 * 使用快慢指针维护窗口
 * 代码参考https://blog.csdn.net/whuwangyi/article/details/42451289
 */
public class leetcode159_LongestString {
    public static String str = "abcd";

    public int solution(String s){
        int[] map = new int[256];
        int res = 0;
        int right = 0;
        int left = 0;
        int count = 0;
        while (right < s.length()){
            //todo: 扫描过的字符均设置为1
            if (map[s.charAt(right++)]++ == 0){
                //TODO: 记录字符串中不相同的字符的个数
                count++;
            }
            while (count>2){
                if (map[s.charAt(left++)]-- == 1){
                    count--;
                }
            }
            res = Math.max(res,right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] map = new int[256];
        System.out.println(str.charAt(0));
        System.out.println(map[str.charAt(0)]);
    }
}
