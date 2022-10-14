package com.feng.newline.binarytree;

/**
 * @author: ladidol
 * @date: 2022/10/14 14:55
 * @description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109<= Node.val <= 109
 * -1000<= targetSum<= 1000
 * 通过次数197,362提交次数372,276
 */
public class L437路径总和III {


    //对每一个遍历到的节点都进行一个新的开始。
    class Solution {
        //这种暴力搜索的遇到这个：[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000] 0就通过不了。
        //可以将target变成long。

        int ans = 0;

        //pathSum表示从根节点开始遍历每一个节点
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
//            if (root.val==1000000000) return 0;

            sum(root, targetSum);

            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);

            return ans;
        }


        void sum(TreeNode root, long targetSum) {
            targetSum -= root.val;
            if (targetSum == 0) ans++;
//            if (targetSum < 0) return;//有可能有负数值，所以这一句是多余的。

            if (root.left != null) sum(root.left, targetSum);
            if (root.right != null) sum(root.right, targetSum);

        }
    }
    //后面有空可以用：树的遍历+前缀和。




}