package top.dyw.nowcoder.top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-01-29-14:13
 */
@SuppressWarnings("all")
public class BM41输出二叉树的右视图 {

    public static void main(String[] args) {
        int[] solve = new BM41输出二叉树的右视图().solve(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3});
        for (int i : solve) {
            System.out.println(i);
        }
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return reConstructBinaryTreeHelper(pre,0,pre.length-1,vin,0,vin.length-1);
    }

    private TreeNode reConstructBinaryTreeHelper(int[] pre, int pstart, int pend, int[] vin, int vstart, int vend) {
        if (pstart>pend){
            return null;
        }

        //根节点的值
        int rootVal = pre[pstart];
        //生成根节点
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = vstart; i<=vend; i++){
            if (vin[i]==rootVal){
                i_root_index = i;
                break;
            }
        }

        //计算得出左边节点个数
        int leftNum = i_root_index - vstart;

        root.left = reConstructBinaryTreeHelper(pre,pstart+1, pstart+leftNum,vin,vstart,i_root_index-1);
        root.right=reConstructBinaryTreeHelper(pre,pstart+leftNum+1,pend,vin,i_root_index+1,pend);

        return root;


    }

    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = reConstructBinaryTree(xianxu, zhongxu);

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        int[] result = new int[xianxu.length];
        int index = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-->0){
                TreeNode poll = deque.poll();
                if (size==0){
                    result[index++] = poll.val;
                }
                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
        }

        return Arrays.copyOfRange(result,0,index);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
