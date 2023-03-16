package top.dyw.nowcoder.top100;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-12-31-13:48
 */
@SuppressWarnings("all")
public class BM25二叉树的后序遍历 {

    public static void main(String[] args) {

    }


    public int[] postorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root,result);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    private void postorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root==null){
            return;
        }

        postorderTraversalHelper(root.left,result);
        postorderTraversalHelper(root.right,result);
        result.add(root.val);
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
