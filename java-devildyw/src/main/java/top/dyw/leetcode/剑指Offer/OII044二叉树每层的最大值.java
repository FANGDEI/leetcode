package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/07/19 21:45
 **/
@SuppressWarnings("all")
public class OII044二叉树每层的最大值 {

    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-->0){
                TreeNode poll = queue.poll();
                max = Math.max(max,poll.val);

                if (poll.left!=null){
                    queue.offer(poll.left);
                }

                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            res.add(max);
        }

        return res;
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
