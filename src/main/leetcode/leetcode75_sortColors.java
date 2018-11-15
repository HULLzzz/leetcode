/**
 * @Auther: Think
 * @Date: 2018/11/2 15:22
 * @Description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class leetcode75_sortColors {
    //快排：小于1的放左边，大于1的放右边
    public void sortColors(int[] nums){
        int less = -1;
        int more = nums.length;
        int i = 0;
        while (i<more){
            if (nums[i]<1){
                swap(nums,++less,i++);
            }else if (nums[i]>1){
                swap(nums,--more,i);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
