package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: TreeNode的一些小操作
 * @author: Ladidol
 * @description:
 * @date: 2022/8/25 23:35
 * @version: 1.0
 */
public class TreeNode的一些小操作 {
    /**
     * 获取树的高度
     *
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
