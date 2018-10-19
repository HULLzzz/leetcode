import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:
 * @Description:旋转数组
 *              给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *              输入: [1,2,3,4,5,6,7] 和 k = 3
 *              输出: [5,6,7,1,2,3,4]
 * @params:
 * @Data: Created in  14:34 2018/8/27
 * @Modified By:
 */
public class Primary_Arrays_convertArray {
    //解法一：将数组的最后一个元素设置为临时变量，数组整体后移一位，将最后一位元素赋值个i第一位元素
    public static void rotateArr(int[] array,int k){
        for (int i = 0;i<k;i++){
            int tmp = array[array.length-1];
            //注意for循环的初始条件
            for (int j = array.length-1;j>0;j--){
                array[j] = array[j-1];
            }
            array[0] = tmp;
            System.out.println(Arrays.toString(array));
        }
    }

    //（改进）解法二：利用k值求出中间值，middle = k%nums.length，这样可以先移动middle左边的数组，再移动右边的数组
    public static void rotateArr2(int[] array,int k ){
        if (array.length<0||array==null){
            return;
        }
        k = k % array.length;
        reverse(array,0,array.length-k-1);
        reverse(array,array.length-k,array.length-1);
        reverse(array,0,array.length-1);
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        int k = 7;
        //rotateArr(array,k);
        rotateArr2(array,k);
        System.out.println(Arrays.toString(array));
    }
}
