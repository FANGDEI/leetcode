package top.dyw.nowcoder.top100;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-12-31-13:46
 */
@SuppressWarnings("all")
public class BM24二叉树的中序遍历 {

    public static void main(String[] args) {

    }

    public int[] inorderTraversal(TreeNode root) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root,result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root==null){
            return;
        }
        inorderTraversalHelper(root.left,result);
        result.add(root.val);
        inorderTraversalHelper(root.right,result);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
