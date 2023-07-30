package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/30 12:05
 **/
@SuppressWarnings("all")
public class OII053二叉搜索树中的中序后继 {

    public static void main(String[] args) {

    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        //利用二叉搜索树的特性，节点的右子树上的节点都是大于当前节点的，而右子树的左子树的最后一个节点为子树中最小的节点
        if (p.right!=null){
            successor = p.right;
            while (successor.left!=null){
                successor = successor.left;
            }
            return successor;
        }

        //如果所给p点没有右子树 那么利用二叉搜索树的特性，去遍历，遇到大于p节点就记录并且去他的左子树去逼近，否则取右子树
        TreeNode node = root;
        while (node!=null){
            if (node.val>p.val){
                successor = node;
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return successor;
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
