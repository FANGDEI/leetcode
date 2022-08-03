package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L654最大二叉树
 * @author: Ladidol
 * @description: 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 * @date: 2022/8/3 17:59
 * @version: 1.0
 */
public class L654最大二叉树 {




    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traversal(nums,0, nums.length);
        }

        //左闭右开
        TreeNode traversal(int[] nums, int left, int right) {
            if (left >= right) return null;//终止条件。

            //第一步：先找分割点下标：maxIndex。
            int maxIndex = left;
            for (int i = left + 1; i < right; i++) {
                if (nums[i]> nums[maxIndex]) maxIndex = i;//寻找最大值下标；
            }
            //第二步：构建根节点，和它的子节点。
            TreeNode root = new TreeNode(nums[maxIndex]);//根节点
            // 左闭右开：
            root.left = traversal(nums, left, maxIndex);
            root.right = traversal(nums, maxIndex + 1, right);//注意去掉最大值。

            return root;
        }
    }
}
