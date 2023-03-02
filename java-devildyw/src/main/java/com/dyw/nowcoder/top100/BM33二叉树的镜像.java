package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-11-11:31
 */
@SuppressWarnings("all")
public class BM33二叉树的镜像 {


    public static void main(String[] args) {

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 自底向上 不断交换一颗子树的左右节点达到镜像的效果
     * @param pRoot
     * @return
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot==null){
            return null;
        }
        //递归子树
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        //交换
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

}
