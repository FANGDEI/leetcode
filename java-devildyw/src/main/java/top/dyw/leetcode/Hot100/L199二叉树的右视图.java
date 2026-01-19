package top.dyw.leetcode.Hot100;

public class L199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()) {

            int n = deque.size();

            for (int i = 0; i<n; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

                if (i==n-1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
