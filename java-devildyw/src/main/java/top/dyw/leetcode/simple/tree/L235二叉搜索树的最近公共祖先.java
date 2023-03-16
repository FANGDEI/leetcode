package top.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-24-12:28
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。”
 */
@SuppressWarnings("all")
public class L235二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {

    }

    /**
     * 一次遍历 通过二叉搜索树的性质 左子树总是小于根节点 右子树总是大于根节点
     * 按这个性质去遍历查找最近的祖先 如果两个节点同时小于某个节点的值 那么就继续查找它的左子树 否则就右子树
     * 如果两种情况都不符合就把当前的祖先返回
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //初始化当前祖先
        TreeNode ancestor = root;
        //遍历
        while (true) {
            //如果两个节点的值都小于现祖先的值 那么最近节点一定在该节点的左子树上
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
                //如果两个节点的值都大于现祖先的值 那么最近节点一定在该节点的右子树上
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            }//都不是说明一个节点的最近祖先在该节点的左子树 另一个在右子树所以他们的最近祖先就是现祖先节点 直接跳出循环返回
            else {
                break;
            }
        }
        return ancestor;
    }

}
