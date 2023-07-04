package com.feng.leetcode.offerII._07队列;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 15:03
 * @description: {}
 */
public class 剑指OfferII046二叉树的右侧视图 {


    //bfs就是每一层的最右边的元素
    class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            if (root != null) deque.offer(root);

            while (!deque.isEmpty()) {
                int curSize = deque.size();
                TreeNode theLastNode = new TreeNode();//就用个指针来记录就行了。
                for (int i = 0; i < curSize; i++) {
                    TreeNode cur = deque.poll();
                    if (cur.left != null) deque.offer(cur.left);
                    if (cur.right != null) deque.offer(cur.right);
                    if (i == curSize - 1) theLastNode = cur;
                }
                res.add(theLastNode.val);
            }
            return res;
        }

    }

}
