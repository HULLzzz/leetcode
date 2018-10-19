/**
 * @Author:
 * @Description: 判断一个数组中是否含有重复元素 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @params:
 * @Data: Created in  17:25 2018/8/28
 * @Modified By:
 */
public class Primary_Arrays_isRepeat {
    public static void isRepeat(int[] arr){
        boolean flag = false;  //设置标志位
        for (int i = 0;i<arr.length;i++){  //首位开始

            for (int j = i+1;j<arr.length;j++){
                if (arr[i]==arr[j]){
                    flag = true;
                }
            }
        }
        if (flag){
            System.out.println("有重复元素");
        }else {
            System.out.println("没有重复元素");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,5,1};
        isRepeat(arr);
    }

}
