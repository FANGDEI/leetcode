package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L530二叉搜索树的最小绝对差
 * @author: Ladidol
 * @description:
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * 思路：
 * 题目中要求在二叉搜索树上任意两节点的差的绝对值的最小值。
 * 注意是二叉搜索树，二叉搜索树可是有序的。
 * 遇到在二叉搜索树上求什么最值啊，差值之类的，就把它想成在一个有序数组上求最值，求差值，这样就简单多了。
 * @date: 2022/8/3 21:13
 * @version: 1.0
 */
public class L530二叉搜索树的最小绝对差 {




    //方法一：类似验证二叉搜索树里面的。依旧可以用一个数组来装中序遍历的结果，然后对这个数组进行操作。
    class Solution1 {
        public int getMinimumDifference(TreeNode root) {
            //略！
            return 0;
        }
    }
    //方法二：递归，用双指针来操作。记录上一个节点的值。
    class Solution {

        TreeNode preNode;
        int res = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            inorderTraversal(root);
            return res;
        }

        //本题重点怎么在递归中记录上一个节点。
        void inorderTraversal(TreeNode root) {
            if (root == null) return;
            inorderTraversal(root.left);
            if (preNode != null){
                res = Math.min(res, root.val- preNode.val);//第一个差值。
            }
            preNode = root;//记录当前，给下一个节点保存其前一个节点。
            inorderTraversal(root.right);
        }
    }
    //方法三：通过迭代法，来代替二方法。先留个坑后面填上。


}
