package top.dyw.leetcode.Hot100;

public class L102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while(deque.size()>0) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
