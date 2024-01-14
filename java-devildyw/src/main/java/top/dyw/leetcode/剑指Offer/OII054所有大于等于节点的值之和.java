package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/31 12:16
 **/
@SuppressWarnings("all")
public class OII054所有大于等于节点的值之和 {

    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;
    /**
     * 根据题意这里按右中左的顺序遍历，通过全局变量sum 去记录反向中序遍历的二叉搜索树的前缀和再赋值到当前节点
     * @param root
     * @return
     */
    private void dfs(TreeNode root) {
        if (root==null){
            return ;
        }

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
