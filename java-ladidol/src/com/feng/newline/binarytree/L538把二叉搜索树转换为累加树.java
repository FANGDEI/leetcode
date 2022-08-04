package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L538把二叉搜索树转换为累加树
 * @author: Ladidol
 * @description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * @date: 2022/8/4 18:00
 * @version: 1.0
 */
public class L538把二叉搜索树转换为累加树 {

    //直接给出最优解：反中序遍历，双指针单层递归逻辑处理。（也可以中序走的，那就是想有个总和sum一步步减下去。）
    class Solution {
        int pre = 0;

        public TreeNode convertBST(TreeNode root) {
            getBST(root);
            return root;
        }

        void getBST(TreeNode cur) {
            if (cur == null) return;
            getBST(cur.right);//后
            cur.val += pre;
            pre = cur.val;
            getBST(cur.left);
        }
    }
}
