package com.feng.leetcode.offerII._07队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/12 22:32
 * @description: {}
 */
public class 剑指OfferII043往完全二叉树添加节点 {


    //bfs，就是队列常用
    class CBTInserter {


        Deque<TreeNode> theLast = new ArrayDeque<>();

        TreeNode root;

        /**
         * 先找到下面的一个保护层（保护层有两种情况：全是最后一层or最后一层+最后一层右边的倒数第二层）
         * <p>
         * 看了题解：其实就是保存没有两个子树的节点
         *
         * @param root
         */
        public CBTInserter(TreeNode root) {
            this.root = root;
            theLast.offer(root);
            while (theLast.peek().left != null && theLast.peek().right != null) {
                TreeNode peek = theLast.poll();
                theLast.offer(peek.left);
                theLast.offer(peek.right);
            }
        }

        /**
         * 插入的时候，插入到没有满的节点后面，然后返回这个父节点。
         *
         * deque：从前往后，是层序遍历的先进先出。
         * @param v
         * @return
         */
        public int insert(int v) {

//            for (TreeNode treeNode : theLast) {
//                System.out.println("treeNode = " + treeNode.val);
//            }
//            System.out.println("====================================================");

            TreeNode peek = theLast.peek();
            if (peek.left == null) {
                peek.left = new TreeNode(v);
//                theLast.offer(peek.left);//感觉是等价的，但是答案不一样，会出现空nullpeek的情况。
            } else {
                TreeNode poll = theLast.poll();
                poll.right = new TreeNode(v);
                theLast.offer(poll.left);
                theLast.offer(poll.right);
            }

            return peek.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
