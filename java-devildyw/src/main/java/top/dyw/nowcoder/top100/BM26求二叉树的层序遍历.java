package top.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-01-09-22:52
 */
@SuppressWarnings("all")
public class BM26求二叉树的层序遍历 {

    public static void main(String[] args) {

    }


    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> roots = new ArrayList<>();

        if (root==null){
            return roots;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-->0){
                TreeNode poll = deque.poll();
                temp.add(poll.val);
                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
            roots.add(temp);
        }

        return roots;

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
