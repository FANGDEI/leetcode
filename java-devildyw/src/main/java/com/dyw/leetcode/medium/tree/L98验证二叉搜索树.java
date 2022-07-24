package com.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-07-24-11:16
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
@SuppressWarnings("all")
public class L98验证二叉搜索树 {
    public static void main(String[] args) {

    }

    /**
     * 这启示我们设计一个递归函数 helper(root, lower, upper) 来递归判断，
     * 函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r)(l,r)
     * 的范围内（注意是开区间）。如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，
     * 否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 通过二叉搜索树的性质可知 二叉树的左子树上的节点的值一定小于根节点 右子树上节点的值一定大于根节点
     * 根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界upper改为root.val 因为此节点的值就是该左子树的最大值
     * 递归调用右子树时，需要把下界lower改为root.val 因为此节点的值就是该节点右子树的最小值。
     *
     * <p>
     * <strong>因为二叉搜索树左右子树区间天然的分割线就是他们的根节点，又因为二叉搜索树中的每科子树也是一个二叉搜索树 通过这个规律自上而下的去更新区间去查找是否有不符合条件的节点</strong>
     * 对于右子树区间的下界只会不断增大 对于左子树区间的上界只会不断减小
     *
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    public boolean isValidBST(TreeNode root, long lower, long upper) {
        //如果节点为空返回true
        if (root == null) {
            return true;
        }
        //判断该节点的值是否处于区间之内
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        //既不为空节点的值又在区间范围内那么深度搜索该节点的左子树和右子树并且更新区间
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
