/**
 * @Auther: Think
 * @Date: 2018/10/21 12:24
 * @Description: 旋转矩阵
 *
 */
public class leetcode48_rotateMatrix {

    public static void Solution(int w,int h,int k){
        int sum = 0;

        for (int i = 0;i<k;i++){

            sum +=(h-2-4*i)*2+(w-4*i)*2;

        }
        System.out.println(sum);

    }


    public static void Solution2(int l,int[] a,int[] b){
       boolean[][] dp = new boolean[l][4];
       for (int i = 0;i<l;i++){
           for (int j = 0;j<4;j++){
               dp[i][j] = false;
           }
       }

           //for (int n = 0;n<4;n++){
               dp[0][1] = true;
               for (int i = 1;i<l;i++){
                   for (int m = 0;m<4;m++){
                       if (dp[i-1][m]){
                           System.out.println("i-1: "+(i-1)+"   m: "+m);
                           for (int j = 0;j<4;j++){
                               System.out.println("  start:   "+m);
                           //    System.out.println("a[i]:   "+a[i]+"  (m| j)--"+(m| j) +"  j--"+j + "  b[i]--"+b[i]+"  (m & j)--"+(m & j));
                             //  int last = 0;
                               dp[i][j] = (a[i-1] == (m| j)) && (b[i-1] == (m & j));
                               //--------------test
                               if (dp[i][j]) System.out.println("----------i: "+i+"  j: "+ j);
                           }
                       }
                   }
               }

          // }

           for (int i = 0;i<l;i++){
               for (int j = 0;j<4;j++){
                   if (dp[i][j]){
                       System.out.println( "第"+i+"个t为："+j);
                   }
               }
           }
        System.out.println("end");




    }

    public static void main(String[] args) {
        int l = 4;
        int[] a = new int[]{3,3,2};
        int[] b = new int[]{1,2,0};
        Solution2(l,a,b);
       // System.out.println(1&3);
       // int a = 100,b=10,c=10;
//       int w = 9, h =7,k=2;
//        Solution(w,h,k);
    }

}
