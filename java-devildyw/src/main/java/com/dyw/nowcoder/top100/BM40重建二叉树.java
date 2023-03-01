package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-29-13:58
 */
@SuppressWarnings("all")
public class BM40重建二叉树 {
    public static void main(String[] args) {

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
        root.right=reConstructBinaryTreeHelper(pre,pstart+leftNum+1,pend,vin,i_root_index+1,vend);

        return root;


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
