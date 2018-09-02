import org.omg.CORBA.MARSHAL;

public class leetcode5_LongestPalindromicSubstring {

/**
 *
 * @description: 寻找最长回文子串
 *        manacher算法：http://blog.sina.com.cn/s/blog_3fe961ae0101iwc2.html
 * @param:
 * @return: 
 * @auther: 
 * @date: 2018/9/1 10:14
 */
  public static int manacher(String str){
      char[] cStr = str.toCharArray();
      StringBuffer sBuffer = new StringBuffer();
      //将奇偶长度字符串经过处理都是奇数长度
      sBuffer.append("#");
      for (int i = 0;i<cStr.length;i++){
          sBuffer.append(cStr[i]);
          sBuffer.append("#");
      }
      int max = -1;  //right表示已知的回文中最右边的边界
      int id =  -1;  //已知的回文中拥有最右边边界的中心点位置
      //计算所有的p[]
      int p[] = new int[sBuffer.length()];  //p[i]表示以i为中心的最大回文字半径，至少为1，即字符本身
      for (int i = 0;i<sBuffer.length();i++){
          int r = 1;
          //确定一个最小的半径
          if (i<=max){
              r = Math.min(p[id]-i+id,p[2*id-i]);
          }
          //尝试更大半径
          while (i - r >= 0 && i + r < sBuffer.length() && sBuffer.charAt(i - r) == sBuffer.charAt(i + r)) {
              r++;
          }
          //更新边界和回文中心的坐标
          if (i + r - 1 > max) {
              max = i+r-1;
              id = i;
          }
          p[i] = r;
      }
      //扫描一遍p数组找出最大半径
      int maxLen = 0;
      for (int r:p){
          if (r > maxLen) {
              maxLen = r;
          }
      }
      return maxLen - 1;
  }

    public static void main(String[] args) {
        String str = "babad";
        int i = manacher(str);
        System.out.printf("i = "+i);
    }

}
