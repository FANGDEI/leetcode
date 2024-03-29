package top.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2023-02-06-12:50
 */
@SuppressWarnings("all")
public class L2331计算布尔二叉树的值 {

    public static void main(String[] args) {

    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public boolean evaluateTree(TreeNode root) {
        return evaluateTreeHelper(root);
    }


    /**
     * 按照根左右的顺序来计算树的布尔值
     * @param root
     * @return
     */
    private boolean evaluateTreeHelper(TreeNode root) {
        if (root==null){
            return true;
        }
        if (root.left==null&&root.right==null){
            return root.val==0?false:true;
        }

        boolean left = evaluateTreeHelper(root.left);
        boolean right = evaluateTreeHelper(root.right);

        if (root.val==2){
            return left|right;
        }else{
            return left&right;
        }

    }
}
