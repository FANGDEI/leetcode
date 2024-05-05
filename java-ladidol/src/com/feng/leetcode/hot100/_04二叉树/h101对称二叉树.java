package com.feng.leetcode.hot100._04二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class h101对称二叉树 {

    //bfs 我们不每一层，左右指针来判断，我们直接在第一层就用左右来存放左右节点
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;//或者是false
            Deque<TreeNode> queue = new LinkedList<>();//我超有啥子区别啊。
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {

                TreeNode leftOne = queue.poll();
                TreeNode rightOne = queue.poll();
                if (leftOne == null && rightOne == null) continue;//都是没有不存在的节点，即为null的时候
                if (leftOne == null || rightOne == null || leftOne.val != rightOne.val) return false;

                //左右 右左放到一起
                queue.offer(leftOne.left);//懂了这里用ArrayDeque要先判断加入进去的是不是null， 如果是空的话源码部分会报错。
                queue.offer(rightOne.right);//list可以不用判断que是不是负数，所以要常用尽量用LinkedList实现类吧
                queue.offer(leftOne.right);
                queue.offer(rightOne.left);
            }
            return true;
        }
    }


}
