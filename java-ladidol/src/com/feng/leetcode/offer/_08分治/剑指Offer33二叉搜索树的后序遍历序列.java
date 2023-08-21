package com.feng.leetcode.offer._08分治;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/7 19:34
 * @description: {}
 */
public class 剑指Offer33二叉搜索树的后序遍历序列 {

    //分治谢谢
    class Solution {
        /**
         * 要点：二叉搜索树中根节点的值大于左子树中的任何一个节点的值，小于右子树中任何一个节点的值，子树也是
         *
         * @param postorder
         * @return
         */
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length <= 2) return true;
            return verify(postorder, 0, postorder.length - 1);
        }


        /**
         * 后续遍历的根节点在最后
         *
         * @param postorder
         * @param left
         * @param right
         * @return
         */
        private boolean verify(int[] postorder, int left, int right) {
            if (left >= right) return true;
            int curRoot = postorder[right];

            int mid = left;
            //寻找左右子树分界线：第一个大于根节点的数，后面一定都大于根节点
            while (mid < right && postorder[mid] < postorder[right]) {
                mid++;
            }
            //对当前层root是不是符合要求进行统计
            for (int i = mid; i < right; i++) {
                if (postorder[i] < postorder[right]) return false;
            }
            //走到这里了，就开始看看root的两个子树是不是标准的
            return verify(postorder, left, mid - 1) &&
                    verify(postorder, mid, right - 1);

        }

    }


}
