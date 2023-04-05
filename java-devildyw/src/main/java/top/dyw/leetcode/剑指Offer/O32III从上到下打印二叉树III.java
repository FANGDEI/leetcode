package top.dyw.leetcode.剑指Offer;

import java.util.*;

/**
 * @author Devil
 * @since 2023-03-05-20:52
 */
@SuppressWarnings("all")
public class O32III从上到下打印二叉树III {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            int size = deque.size();
            flag = !flag;
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-->0){
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
            if (flag){
                Collections.reverse(temp);
            }
            res.add(temp);
        }
        return res;
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
