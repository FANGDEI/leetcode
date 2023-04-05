package top.dyw.leetcode.medium.tree;

/**
 * @author Devil
 * @since 2022-08-13-9:17
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 */
@SuppressWarnings("all")
public class L236二叉树的最近公共祖先 {
    public static void main(String[] args) {

    }

    //全局变量记录最近公共祖先
    private TreeNode ans = null;

    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }


    /**
     * 深度优先搜索
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return false;
        }
        //判断该节点的左节点/右节点 是否存在p或q节点  如果左子树包含的是 p节点，那么右子树只能包含 q 节点，反之亦然
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);

        //这里则是满足条件更新公共祖先的  如果满足 lson&&rson 则代表该节点的左右子树分别包括着p q节点 说明该节点就是最近公共节点,
        //亦或是满足 当前节点满足值等于p或q中的一个 且它的子节点包含另一个值 也说明该节点就是最近公共节点（因为树节点中值不相同 所以该节点值如果相同的话，那么他的子节点如果包含 只能时另一个节点的值了）
        //因为是自底向上的 所以找到的公共节点一定是最近的。
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }

        //返回结果到上一层 只要存在有一个节点满足即可
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        //找到一个节点为p或者q直接返回当前节点
        if (root==null||root==p||root==q){
            return root;
        }

        //后续遍历
        TreeNode left = lowestCommonAncestor01(root.left,p,q);
        TreeNode right = lowestCommonAncestor01(root.right,p,q);

        if (left==null&&right==null){ //如果没有找到节点
            return null;
        } else if (left==null&&right!=null) { //如果找到一个节点 如果p(q) 是 q(p)的子孙节点 到最后只会返回一个节点 也就是父节点
            return right;
        } else if (left!=null&&right==null){
            return left;
        } else{ //如果找到两个结点 这就是非p(q) 是 q(p)的子孙节点 的情况
            return root;
        }
    }
}
