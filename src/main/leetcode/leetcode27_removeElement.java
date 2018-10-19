/**
 * @Auther: Think
 * @Date: 2018/10/9 15:47
 * @Description:
 * Given nums = [3,2,2,3], val = 3,Your function should return length = 2, with the first two elements of nums being 2.
 * 给定数组和目标值，删除目标值之后数组的长度
 */
public class leetcode27_removeElement {
    public int removeElement(int[] nums,int val){
        int len = nums.length;
        int i = 0;
        while (i<len){
            if (nums[i] == val) {
                len--;
                nums[i] = nums[len]; //删除操作
            }else {
                i++;
            }
        }
        return len;
    }
}
