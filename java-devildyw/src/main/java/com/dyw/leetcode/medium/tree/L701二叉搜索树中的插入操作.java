package com.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-07-23-11:21
 * <p>
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
@SuppressWarnings("all")
public class L701二叉搜索树中的插入操作 {
    public static void main(String[] args) {

    }

    /**
     * 本题只要求在二叉搜索树中插入新节点 而不是二叉平衡树 所以不用在意树的平衡只要插入新节点后能达到二叉搜索树即可
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //如果头结点为空 那么新插入的节点理所应到会成为第一个节点
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        //遍历树的节点 找到适合新节点插入的位置
        while (pos != null) {
            //如果新节点值小于该节点 那么新节点一定会插入在该节点的左子树上
            if (val < pos.val) {
                //如果该节点左子树为空 那么就将该节点就成为了该节点的左子树，并且因为插入成功 所以结束循环
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    //如果左子树不为空 那么继续在左子树上查找知道找到合适的节点
                    pos = pos.left;
                }
            } else {
                //大于的时候 则完全相反
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
