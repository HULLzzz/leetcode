/**
 * @Auther: Think
 * @Date: 2018/11/12 19:56
 * @Description:
 * 数的中序遍历输出的是有序数列，可以在中序遍历输出的地方进行判断，如果是错误节点就保留该节点
 */
public class leetcode99_RecoverBinarySearchTree {

    public class Node{
        int val;
        Node left;
        Node right;
        Node(int x){
            this.val = x;
        }

    }

    Node n1,n2;
    Node pre = new Node(Integer.MIN_VALUE);
    public void recoverTree(Node root){
        bfs(root);
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    private void bfs(Node root) {
        if (root==null){
            return;
        }
        bfs(root.left);   //1、中序遍历处理：先进行左半边的递归，这一步处理完实际上是到树的最左节点，将最左节点设置为pre
        //中序遍历中间处理
        if (n1==null&&pre.val>=root.val){   //3、能进入这一步此时的root为中间节点，而pre是左节点，判断大小即可。如果n1==null，此时左节点大于中间节点，则记录左节点
            n1 = pre;
        }
        if (n1!=null&&pre.val>=root.val){  //4、如果n1！=null，证明是第二个被换的小值节点，未被置换时做节点
            n2 = root;
        }
        pre = root;   //2、将最左节点设置为pre
        //处理结果
        bfs(root.right);
    }


}
