package com.feng.newline.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L106从中序与后序遍历序列构造二叉树
 * @author: Ladidol
 * @description: 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗二叉树。
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 注意：inorder 和 postorder 都由 不同 的值组成
 * @date: 2022/7/31 22:29
 * @version: 1.0
 */
public class L106从中序与后序遍历序列构造二叉树 {


    //在切割的过程中会产生四个区间，把握不好不变量的话，一会左闭右开，一会左闭右闭，必然乱套！
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
                map.put(inorder[i], i);
            }
            return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }

        Map<Integer, Integer> map;  // 方便根据数值查找位置, 减少时间复杂度。

        // 参数里的范围都是前闭后开
        TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
            //第一步 当前分割数组是空的时候
            if (inBegin >= inEnd || postBegin >= postEnd) return null;//终止条件。
            //第二步：后序遍历数组最后一个元素，就是当前的中间节点
            int rootValue = postorder[postEnd - 1];//root节点值
            int rootIndex = map.get(rootValue);//root节点在中序遍历中的位置。
            TreeNode root = new TreeNode(rootValue);//构造节点。

            // 第四步：切割中序数组，得到 中序左数组和中序右数组
            // 第五步：切割后序数组，得到 后序左数组和后序右数组
            // 第六步 得到的数组放到下次递归中，
            // root.left = traversal(中左，后左);
            // root.right = traversal(中右，后右); 注意去除当前index节点。
            int lenOfLeft = rootIndex - inBegin;//中序左子树大小，用于分割后序数组。
            root.left = traversal(inorder, inBegin, rootIndex,
                    postorder, postBegin, postBegin + lenOfLeft);//前开后闭
            root.right = traversal(inorder, rootIndex + 1, inEnd,
                    postorder, postBegin + lenOfLeft, postEnd - 1);//前开后闭
            return root;
        }
    }
}
