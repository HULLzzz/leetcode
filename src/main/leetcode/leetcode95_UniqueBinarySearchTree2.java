import jdk.internal.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Think
 * @Date: 2018/11/16 13:17
 * @Description:
 * 给一个数列，输出全部二叉搜索树(96题是输出所有树的个数）
 * 使用动态规划：从start到end，逐个取出一个rootval作为根节点
 * 对于i在[1,n]区间内, 以i为root时, 生成BST的left child 是由1到i-1生成的, BST的right child 是由i+1 到n生成的.
 * Here's an example:
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 *
 */
public class leetcode95_UniqueBinarySearchTree2 {
    public class Node{
        Node left;
        Node right;
        int val ;
        Node(int x){
            this.val = x;
        }
    }
    public List<Node> solution(int n){
        if (n<=0) return new ArrayList<Node>();
        return helper(1,n);
    }

    private List<Node> helper(int start, int end) {
        ArrayList<Node> result = new ArrayList<Node>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int rootVal = start;rootVal<=end;rootVal++){
            for (Node leftSubTreeRoot:helper(start,rootVal-1)){
                for (Node rightSubTreeRoot:helper(rootVal+1,end)){
                    Node root = new Node(rootVal);
                    root.left = leftSubTreeRoot;
                    root.right = rightSubTreeRoot;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
