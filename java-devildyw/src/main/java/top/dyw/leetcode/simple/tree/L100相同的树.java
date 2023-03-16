package top.dyw.leetcode.simple.tree;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author Devil
 * @since 2022-09-23-10:09
 */
@SuppressWarnings("all")
public class L100相同的树 {

    /**
     * 类似对称二叉树的比较 递归去比较两个二叉树每个对应的节点 有如下三种情况
     * 1. 两个节点都为空 相同 返回 true
     * 2. 一个为空 一个不为空 不相同 返回 false
     * 3. 两个节点都不为空 比较节点值是否相同 相同返回 并且子节点都相同则返回true
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }

        if (p==null||q==null){
            return false;
        }

        return p.val==q.val && isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
    }
}
