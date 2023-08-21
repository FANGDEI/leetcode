package com.feng.leetcode.offer._08分治;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/7 18:45
 * @description: {
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/solutions/100091/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/comments/719073
 * }
 */
public class 剑指Offer07重建二叉树 {


    //分治，，
    class Solution {
        /**
         * 核心就是，通过从root开始，构建左右子树，子树构建完成的条件就是范围缩小到零
         * 最重要的还是找到左右子树在中序遍历中所管辖的范围，
         * 构建过程都是围绕：拿到当前节点的在前序遍历preorder中的index进行取值
         *
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            TreeNode treeNode = buildCurrent(0, 0, inorder.length - 1);
            return treeNode;

        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] preorder;

        /**
         * @param pre_root 根节点在前序遍历中的index
         * @param left     中序遍历
         * @param right    中序遍历
         * @return
         */
        TreeNode buildCurrent(int pre_root, int left, int right) {
            if (left > right) return null;//子树完毕
            TreeNode curNode = new TreeNode(preorder[pre_root]);
            int midIndex = map.get(preorder[pre_root]);//得到在中序遍历里的index，可以用来计算左右子树的范围
            curNode.left = buildCurrent(pre_root + 1, left, midIndex - 1);//左子树的根的索引为先序中的根节点+1
            curNode.right = buildCurrent(pre_root + (midIndex - left) + 1, midIndex + 1, right);////右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
            return curNode;
        }

    }


}
