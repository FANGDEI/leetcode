package top.dyw.leetcode.simple.tree;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-07-24-11:59
 * <p>
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
@SuppressWarnings("all")
public class L653两数之和IV_输入BST {
    HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {

    }

    /**
     * hashset + 深度优先搜索
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
