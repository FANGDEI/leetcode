package com.dyw.nowcoder.top100;

import java.util.Deque;

/**
 * @author Devil
 * @since 2023-01-12-11:04
 */
@SuppressWarnings("all")
public class BM36判断是不是平衡二叉树 {

    public static void main(String[] args) {

    }


    //todo:复习
    /**
     * 这个解题思路还挺好理解的
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        //左子树深度减去右子树相差绝对值大于1
        if (Math.abs(left-right)>1){
            return false;
        }
        //判断子节点
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    private int deep(TreeNode root) {
        if (root==null){
            return 0;
        }
        //递归计算左右子树深度
        int left = deep(root.left);
        int right = deep(root.right);

        //取最大值加上1
        return Math.max(left,right)+1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
