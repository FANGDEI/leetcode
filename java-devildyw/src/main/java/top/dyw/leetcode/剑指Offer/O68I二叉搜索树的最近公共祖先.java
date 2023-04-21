package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/21 16:23
 **/
@SuppressWarnings("all")
public class O68I二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (root.val<p.val&&root.val<q.val){
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else{
                return root;
            }
        }
        return null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
