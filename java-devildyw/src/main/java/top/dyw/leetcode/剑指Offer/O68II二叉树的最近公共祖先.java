package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/22 11:05
 **/
@SuppressWarnings("all")
public class O68II二叉树的最近公共祖先 {

    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果为当前节点为空直接返回null，如果当前节点就为q或者p则代表当前节点可能就是最近公共节点直接返回（第一次遇到q或者p）
        if (root==null||root==p||root==q) return root;
        TreeNode left= lowestCommonAncestor(root.left,p,q); //其他情况，再该节点的左右子树上查找
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if (left==null&&right==null){ //如果都为空则代表该节点root下没有q、p 也就不是他们的祖先
            return null;
        }
        if (left==null){ //如果只有left为空，那么p、q的某一个就在root的右子树上，或者两个都在，root的右子树上的节点就是她两的最近公共祖先
            return right;
        }
        if (right==null){ //同理
            return left;
        }
        //如果都不为空那么代表 p，q分别在root的左右子树节点上，那么root就是最近她两的最近公共祖先
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor01(root.left,p,q);
        TreeNode right = lowestCommonAncestor01(root.right,p,q);

        if (left==null&&right==null){
            return null;
        }

        if (left==null){
            return right;
        }

        if (right==null){
            return left;
        }

        return root;

    }
}
