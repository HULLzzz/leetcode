import java.util.*;

/**
 * @Author:
 * @Description: 从排序数组中删除重复项
 *               给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *              不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @params:
 * @Data: Created in  13:22 2018/8/27
 * @Modified By:
 */
public class Primary_Arrays_deletDuplication {
    //方法一：需要一个存储去重后元素的新数组
    //去重后的新数组长度未知因此在知道去重后数组长度后需要将去重后的数组copy到新数组中
    public static int[] deletDuplication1(int[] array){
        int t = 0;
        int[] tmpArr = new int[array.length];
        //两层循环：外层遍历原数组，内层将原数组元素逐个对比
        for (int i = 0;i<array.length;i++){
            boolean isTrue = true;
            for (int j = i+1;j<array.length;j++){
                if (array[i] == array[j]){
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                //没有重复元素就将原数组的元素赋给临时的数组
                tmpArr[t] = array[i];
                t++;
            }
        }
        //去重后的数组copy到数组长度为t的新数组中
        int[] newArr = new int[t];
        System.arraycopy(tmpArr,0,newArr,0,t);
        return newArr;
    }

    /*
    * 方法二：创建一个集合，遍历数组元素并逐一放入集合中，使用contains方法判断即可
    * */
    public static List isRepeat(int[] array){
        List list = new ArrayList();
        for (int i = 0;i<array.length;i++){
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        return list;
    }

/*
* 使用set集合的无序不重复特性
*
* */
    public static Object[] isRepeatUseSet(int[] array){
        Set set = new HashSet();
        for (int i = 0;i<array.length;i++){
            set.add(array[i]);
        }
        return set.toArray();
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,2,2,2,3,1,4};
        //List list = isRepeat(array);
        Object[] list = isRepeatUseSet(array);
        // int[] newArr = deletDuplication1(array);
        System.out.println(Arrays.toString(list));
    }

}
