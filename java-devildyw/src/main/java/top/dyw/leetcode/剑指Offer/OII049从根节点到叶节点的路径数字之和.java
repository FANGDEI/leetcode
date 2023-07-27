package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/27 10:49
 **/
@SuppressWarnings("all")
public class OII049从根节点到叶节点的路径数字之和 {

    public static void main(String[] args) {

    }


    int result = 0;
    /**
     * 深度优先搜索 先序遍历 根左右 回溯记录从根节点到叶子节点的路径
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        //先序遍历+回溯 path就为从根节点到叶子节点的路径
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, Integer path) {
        //如果当前节点为null 则返回
        if (root==null){
            return ;
        }

        //叶子节点计算路径和算上当前节点的值
        if (root.left==null&&root.right==null){
            result += path*10+root.val;
            return ;
        }

        //先序遍历 根左右 如果不是叶子节点就需要继续遍历先处理左子树 再处理右子树
        dfs(root.left,path*10+root.val);
        dfs(root.right,path*10+root.val);

        return;
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
