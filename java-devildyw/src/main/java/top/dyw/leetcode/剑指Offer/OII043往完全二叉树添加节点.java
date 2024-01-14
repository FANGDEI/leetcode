package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/18 11:08
 **/
@SuppressWarnings("all")
public class OII043往完全二叉树添加节点 {

    public static void main(String[] args) {

    }

    class CBTInserter {

        TreeNode root;

        //存储待插入的节点
        Deque<TreeNode> candidate;

        boolean flag = true;
        public CBTInserter(TreeNode root) {
            this.root = root;
            candidate = new ArrayDeque<>();

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.push(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }

                if (!(node.left!=null&&node.right!=null)){ //存在有一个子节点为null就将其添加到queue 等待后续的插入节点
                    candidate.offer(node);
                }
            }

        }

        /**
         * 根据队列 从左到右插入
         * @param v
         * @return
         */
        public int insert(int v) {
            TreeNode child = new TreeNode(v);
            TreeNode node = candidate.peek();
            int ret = node.val;
            if (node.left==null){
                node.left = child;
            }else{
                node.right = child;
                candidate.poll(); //右节点被填充说该节点已经是完全二叉树节点了所以剔除
            }
            candidate.offer(child); //加入新节点
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
