package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/20 20:36
 **/
@SuppressWarnings("all")
public class O54二叉搜索树的第k大节点 {

    public static void main(String[] args) {

    }


    //定义全局变量
    int res , k;
    public int kthLargest(TreeNode root, int k) {
        //中序遍历
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * 中序遍历反过来
     * @param cur
     */
    private void dfs(TreeNode cur) {
        if (cur==null){
            return;
        }
        dfs(cur.right);
        //找到第k个数，并将其值赋值给res
        if (k==0) return;
        if (--k==0) res = cur.val;
        dfs(cur.left);
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
