package com.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-08-30-10:34
 * <p>
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a)例程从列表a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回null 。
 * 否则，令a[i] 作为 a 的最大元素。创建一个值为a[i]的根节点 root 。
 * root的左子树将被构建为Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root的右子树将被构建为Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回Construct(b) 。
 */
@SuppressWarnings("all")
public class L998最大二叉树II {
    public static void main(String[] args) {

    }

    /**
     * 遍历右子树
     * <p>
     * 由题可知 val是加在构造数组末尾的, 由构造函数可得出
     * <p>
     * 1. 如果val比root根节点的值还要大 就以val为新的根节点 而val又是数组末尾的点 所以root内所包含的数都是属于val左边的
     * 所以原来的root就作为新节点的左子树
     * <p>
     * 2. 否则 我们从根节点不断地向右子节点进行遍历,这是因为,当遍历到的节点的值大于val时，由于val是新添加位于数组末尾的元素，那么在构造的结果中，val一定出现在该节点的右子树中。
     * <p>
     * 3. 如果遍历到最后都没有找到val大于的那个节点 那么直接新建以val为值的节点 并且将其添加到当前父节点的右子树上
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //cur节点的父节点 当前节点的父节点
        TreeNode parent = null;
        //当前节点
        TreeNode cur = root;

        //遍历右子树
        while (cur != null) {
            if (val > cur.val) {
                //情况一
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                //情况二
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                //一直循环遍历右子树
                cur = cur.right;
            }
        }
        //如果遍历到最后都没有找到val大于的那个节点 那么直接新建以val为值的节点 并且将其添加到当前父节点的右子树上
        parent.right = new TreeNode(val);
        return root;
    }
}
