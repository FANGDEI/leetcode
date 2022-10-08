package com.dyw.leetcode.medium.tree;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * @author Devil
 * @since 2022-10-08-11:27
 */
public class L538把二叉搜索树转换为累加树 {

    public static void main(String[] args) {

    }


    int sum;
    /**
     * 因为是二叉搜索树 我们通过其性质可知 二叉搜索树的中序遍历是一个升序的有序数组
     * 我们可以通过反中序遍历再累加就可以得出原树中大于等于 node.val 的值之和（从后往前加先遍历右子树 把右子树上的值加起来 就相当于将大于当前节点的值加起来了 最后加上自己节点的值 即等于 node.val 的值 最终替换原 node.val 的值）
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBSTHelper(root);
        return root;
    }

    /**
     * 反中序遍历累加按 右中左的顺序遍历
     * @param root
     */
    private void convertBSTHelper(TreeNode root) {
        if (root==null){
            return;
        }
        //右
        convertBSTHelper(root.right);
        //中
        sum+=root.val;
        root.val = sum;
        //左
        convertBSTHelper(root.left);
    }
}
