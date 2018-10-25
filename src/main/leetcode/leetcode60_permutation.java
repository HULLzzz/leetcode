import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/10/25 13:21
 * @Description:
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * n个数的permutation总共是n！，当前的长度是n，每个相同的起始元素对应（n-1）！个permutation
 * 也就是（n-1）！个permutation之后会换一个起始元素，因此，只要当前的k进行（n-1）！取余，得到的
 * 数字就是当前数组的index，即可得到对应的元素，如此递推直到数组中没有元素结束
 * 我们需要维护一个数据记录当前元素，每次得到一个元素加入结果数组，然后从剩余数组中移除
 * 空间复杂度是o（n），时间上总共是n个回合，如果每次删除元素用的是数组则需要O(N)
 * 总共是O(N^2)
 *
 */
public class leetcode60_permutation {
    public String getPermutation(int n,int k ){
        k--;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1;i<=n;i++){
            list.add(i);
        }
        int factorial = 1;
        for (int i = 2;i<n;i++){
            factorial *= i;
        }
        int round = n - 1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0) {
            sb.append(list.remove(k/factorial));
            k %= factorial;  //new k
            if (round!=0)
                factorial /= round;
            round--;
        }
        return sb.toString();

    }



}
