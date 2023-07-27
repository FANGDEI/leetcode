package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/19 21:49
 **/
@SuppressWarnings("all")
public class OII045二叉树最底层最左边的值 {

    public static void main(String[] args) {

    }

    int curVal = 0;
    int curHeight = 0;

    /**
     * 深度优先搜索 先处理左子树 再处理右子树 这样最后处理的就是最底层最左边的值
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    private void dfs(TreeNode root, int height) {
        if (root==null){
            return ;
        }

        height++;
        //先处理左子树 再处理右子树 这样最后处理的就是最底层最左边的值
        dfs(root.left,height);
        dfs(root.right,height);
        //如果当前节点的高度大于最大高度 则更新最大高度和最左边的值
        if (height>curHeight){
            curHeight = height;
            curVal = root.val;
        }
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
