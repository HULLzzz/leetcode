/**
 * @Auther: Think
 * @Date: 2018/10/16 18:50
 * @Description: 给定一个排好序的数组，和一个目标值，在数组中找到目标值，如果目标值存在，返回其索引，如果目标值不存在，返回他要插入的位置
 *
 */
public class leetcode35_searchInsert {
    public int searchInsert(int[] nums,int target){
        if (nums.length==0||target<=nums[0]) return 0;
        for (int i = 0;i<nums.length-1;i++){
            if (target>nums[i]&&target<=nums[i+1])
                return i+1;
        }
        return nums.length;
    }

    //二分法实现（循环）
    public int sulotion(int[] nums,int target){
        if (nums.length==0) return 0;

        int i = 0,j = nums.length,mid = (i+j)/2;
        while(i<j){
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (j == mid) break;
                j = mid;
                mid = (i + j) / 2;
            } else {
                    if (i==mid) break;
                    i = mid;
                    mid = (i+j)/2;
                }
            }
            return j;
        }
    }

