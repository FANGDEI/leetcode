package com.dyw.leetcode.medium.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * <p>
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * @author Devil
 * @since 2022-09-27-21:01
 */
@SuppressWarnings("all")
public class L106从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> map; //方便根据数值查找位置

    /**
     * 常规版本
     * <p>
     * 第一步：如果数组大小为零的话，说明是空节点了。
     * <p>
     * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
     * <p>
     * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
     * <p>
     * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
     * <p>
     * 第五步：切割后序数组，切成后序左数组和后序右数组
     * <p>
     * 第六步：递归处理左区间和右区间
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { //用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    /**
     * 递归函数
     *
     * 从根结点开始建立 自顶向下 建立 因为根节点是最好确定的 通过不断地分割数组找到不同子树的根结点 来完成对整颗树的构建
     *
     * @param inorder
     * @param inBegin
     * @param inEnd
     * @param postorder
     * @param postBegin
     * @param postEnd
     * @return
     */
    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }

        int rootIndex = map.get(postorder[postEnd - 1]); //借助map 找到后序遍历最后一个元素在中序遍历里面的位置
        TreeNode root = new TreeNode(inorder[rootIndex]); //构造结点
        int lenOfLeft = rootIndex - inBegin; //保存中序左子树个数，用来确定后续数列的个数 来确定后序数列的分割点

        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);

        //处理左右区间时需要将我们已经访问过的结点排除
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);


        return root;
    }

}
