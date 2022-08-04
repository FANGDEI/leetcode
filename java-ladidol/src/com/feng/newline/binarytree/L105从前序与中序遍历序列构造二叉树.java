package com.feng.newline.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L105从前序与中序遍历序列构造二叉树
 * @author: Ladidol
 * @description: 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * @date: 2022/8/3 17:00
 * @version: 1.0
 */
public class L105从前序与中序遍历序列构造二叉树 {

    //在切割的过程中会产生四个区间，把握不好不变量的话，一会左闭右开，一会左闭右闭，必然乱套！
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
                map.put(inorder[i], i);
            }
            return traversal(inorder, 0, inorder.length, preorder, 0, preorder.length);
        }

        Map<Integer, Integer> map;  // 方便根据数值查找位置, 减少时间复杂度。

        // 参数里的范围都是前闭后开
        TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] preorder, int postBegin, int postEnd) {
            //第一步 当前分割数组是空的时候
            if (inBegin >= inEnd || postBegin >= postEnd) return null;//终止条件。
            //第二步：前序遍历数组第一个元素，就是当前的中间节点
            int rootValue = preorder[postBegin];//root节点值
            int rootIndex = map.get(rootValue);//root节点在中序遍历中的位置。
            TreeNode root = new TreeNode(rootValue);//构造节点。

            // 第四步：切割中序数组，得到 中序左数组和中序右数组
            // 第五步：切割前序数组，得到 前序左数组和前序右数组
            // 第六步 得到的数组放到下次递归中，
            // root.left = traversal(中左，前左);
            // root.right = traversal(中右，前右); 注意去除当前root节点。
            int lenOfLeft = rootIndex - inBegin;//中序左子树大小，用于分割前序数组。
            root.left = traversal(inorder, inBegin, rootIndex,
                    preorder, postBegin+1, postBegin + 1 + lenOfLeft);//前开后闭
            root.right = traversal(inorder, rootIndex + 1, inEnd,
                    preorder, postBegin + 1 + lenOfLeft, postEnd);//前开后闭
            return root;
        }
    }
}
