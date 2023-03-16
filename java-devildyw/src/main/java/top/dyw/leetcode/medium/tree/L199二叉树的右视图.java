package top.dyw.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-11-8:52
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
@SuppressWarnings("all")
public class L199二叉树的右视图 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);
        System.out.println(new L199二叉树的右视图().rightSideView01(treeNode));
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        //初始化
        deque.offer(root);

        while (!deque.isEmpty()){
            //既然要取每一层中最右边的节点 那么我们每次都将队列的末尾取出 这样就能达到效果了
            int size = deque.size();
            TreeNode last = deque.getLast();
            list.add(last.val);
            while (size-->0){
                //层序遍历
                TreeNode poll = deque.poll();
                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
        }
        return list;
    }


    public List<Integer> rightSideView01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null){
            return result;
        }

        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            while (len-->0){
                TreeNode node = deque.poll();
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                if (len==0){
                    result.add(node.val);
                }
            }

        }
        return result;
    }
}
