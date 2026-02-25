package top.dyw.leetcode.Hot100;
import java.util.*;
public class L102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-->0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}
