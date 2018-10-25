import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/24 21:43
 * @Description:
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 给定一个区间，将相交部分合并
 * 第一种是例如[0,4][1,3]的情况，前面的全部包含后面的。
 * 第二种是例如[0,3][2,6]，部分交叉。
 * 第三种是例如[0,4][5,6]的情况，就是没有交叉。
 */
public class leetcode56_mergeIntervals {

     //Definition for an interval.
      public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public List<Interval> merger(List<Interval> intervals){
          int len = intervals.size();
          if (len<=1){
              return intervals;
          }
          //对intervals进行排序
        Collections.sort(intervals,new IntervalsComparator());
          //取intervals中的第一个区间
        Interval newInterval = intervals.get(0);
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 1;i<len;i++){
            Interval interval = intervals.get(i);
            //不相交的情况
            if (newInterval.end < interval.start) {
                res.add(newInterval);
                newInterval = interval;
            }else{
                //相交的情况 按照start的升序已经排序好了，只需要比较end的值即可
                newInterval = new Interval(newInterval.start,Math.max(newInterval.end,interval.end));
            }
        }
        //添加最后一个
        res.add(newInterval);
        return res;
    }



    private class IntervalsComparator implements Comparator<Interval> {
          //按照start变量升序排序
        public int compare(Interval i1,Interval i2){
            return i1.start-i2.start;
        }
    }

     /*
    * leetcode57 给定一个区间集合，这些区间有些是重合的
    * 给另外一些区间，然后把这些区间进行合并有重叠的区间
    * 给定一个区间集合： [1 3] [6 9] 再给一个区间[2 5]
　     输出：　[1 5][6 9]
    * */

     public static List<Interval> insert(List<Interval> intervals,Interval newInterval){
         List<Interval> list = intervals;
         List<Interval> newList = new ArrayList<Interval>();
         list.add(newInterval); //将给定区间插入到区间集合中
         Collections.sort(list, new Comparator<Interval>() {
             @Override
             public int compare(Interval o1, Interval o2) {
                 return o1.start-o2.start;
             }
         });
         //对区间集合进行排序，用start的升序排序
         Interval prev = null; //用于指定当前区间的前一个区间
         for (Interval cur:list){
             if (prev==null||prev.end<cur.start){
                 newList.add(cur);
                 prev = cur;
             } else if (prev.end < cur.end) {
                 prev.end = cur.end;
             }
         }
         return newList; //返回合并好的区间
     }


}
