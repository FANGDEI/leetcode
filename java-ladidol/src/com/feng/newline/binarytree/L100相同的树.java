package com.feng.newline.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline
 * @className: L100相同的树
 * @author: Ladidol
 * @description:
 * @date: 2022/7/31 13:03
 * @version: 1.0
 */
public class L100相同的树 {
    //和101类似 bsf
    class Solution1 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()) {

                TreeNode leftOne = queue.poll();
                TreeNode rightOne = queue.poll();
                if (leftOne == null && rightOne == null) continue;//都是没有不存在的节点，即为null的时候
                if (leftOne == null || rightOne == null || leftOne.val != rightOne.val) return false;

                queue.offer(leftOne.left);//注意这里的逻辑
                queue.offer(rightOne.left);
                queue.offer(leftOne.right);
                queue.offer(rightOne.right);
            }
            return true;
        }
    }

    //dfs 递归做法
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null || p.val != q.val) return false;
            boolean leftOne = isSameTree(p.left, q.left);
            boolean rightOne = isSameTree(p.right, q.right);
            return leftOne && rightOne;
        }
    }


}
