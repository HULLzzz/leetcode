/**
 * @Auther: Think
 * @Date: 2018/11/2 20:16
 * @Description:
 * 给出一个有序数组，将已经重复两次以上的字符剔除，返回剩余数组长度。
 * 例如 1，1，1，2，2，3，1，1，1。变化为1，1，2，2，3，1，1。返回7，同时原数组的前7位变为正确的数组
 */
public class leetcode80_removeDuplicate{
    public static int solution(int[] nums){
        if (nums.length<2) return nums.length;
        int tmp = nums[0];
        int insert = 1;
        boolean flag = false;
        //insert表示要改写的数组位，如果不用剔除就填入insert，需要剔除直接跳过，
        for (int i = 1;i<nums.length;i++){
            //1112
            if (nums[i]==tmp){
                if (flag){
                    continue;
                }
                else {
                    flag = true;
                    nums[insert++] = tmp;
                }
            }else {
                flag = false;
                nums[insert++] = nums[i];
                tmp = nums[i];
            }
        }
        if (insert<nums.length){
            nums[insert] = nums[insert-1]+1; //将inserth后面的数组位填入与insert最后一位不同的数进行区分
        }
        return insert;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,1,1,1};
        //
         System.out.println(solution(nums));
        for (int i = 0;i<nums.length;i++){
            System.out.print(nums[i]);
        }

    }


}
