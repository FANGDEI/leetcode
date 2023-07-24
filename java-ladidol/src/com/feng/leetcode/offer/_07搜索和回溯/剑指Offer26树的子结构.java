package com.feng.leetcode.offer._07搜索和回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:34
 * @description: {}
 */
public class 剑指Offer26树的子结构 {


    //dfs
    class Solution {
        /**
         * 注意判断的是，从哪里开始找，停止条件是发现不相等就停止。
         * B为A的子结构有3种情况,满足任意一种即可:
         * 1.B的子结构起点为A的根节点,此时结果为isContain(A,B)
         * 2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
         * 3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
         * <p>
         * <p>
         * 当A与B当前节点值相等,若要判断B为A的子结构
         * 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
         * 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
         *
         * @param A
         * @param B
         * @return
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        boolean isContain(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return isContain(A.left, B.left) && isContain(A.right, B.right);
        }
    }


}
