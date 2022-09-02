package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L687最长同值路径
 * @author: Ladidol
 * @description: 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度由它们之间的边数表示。
 * 示例 1:
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * @date: 2022/9/2 13:22
 * @version: 1.0
 */
public class L687最长同值路径 {
    // 根据题意我们可以先找当前节点左子树的路径left，再找当前节点右子树的路径right
    // 若root.val == root.left.val,则当前节点的路径长为leftPath = left + 1
    // 若root.val == root.right.val,则当前节点的路径长为rightPath = right + 1
    // 然后得到当前节点的左右路径后相加即为已当前节点为根节点的最长路径。
    class Solution {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return max;// 这就是longest方法返回的max，而dfs返回的是当前节点子节点的边长数。
        }

        int dfs(TreeNode root){// 单独抽一个dfs方法出来不直接在longest方法上操作是，是因为return的值含义有待商榷。
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            int leftLength = 0, rightLength = 0;
            if (root.left != null && root.val == root.left.val) {// 和下一层构成连线，默认就有1；
                leftLength = left + 1;
            }
            if (root.right != null &&root.val == root.right.val) {
                rightLength = right + 1;
            }
            max = Math.max(max, leftLength + rightLength);
            return Math.max(leftLength,rightLength);// 这里的为了避免不是一条直线（分叉的路径），只返回最大值。
        }
    }
}
