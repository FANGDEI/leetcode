package com.feng.review.二叉树.遍历模板;

import com.feng.review.二叉树.TreeNode;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L144二叉树的前序遍历
 * @author: Ladidol
 * @description:
 * @date: 2022/7/29 14:45 2023年3月5日11:09:41
 * @version: 1.0
 */
public class L144二叉树的前序遍历 {

    //递归遍历
    class Solution {//复习2023年3月5日11:13:36

        /**
         * 参数：[root]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述：
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }
        List<Integer> res = new ArrayList<>();

        void dfs(TreeNode root){
            if (root == null) return;
            res.add(root.val);
            dfs(root.left);
            dfs(root.right);
            //中前后
        }
    }


}
