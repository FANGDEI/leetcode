package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L637二叉树的层平均值
 * @author: Ladidol
 * @description: 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * @date: 2022/7/29 20:12
 * @version: 1.0
 */
public class L637二叉树的层平均值 {
    class Solution123 {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();//注意放的位置
                double sum = 0;
                double fenMu = levelSize;
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    sum += cur.val;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                res.add(sum / fenMu);
            }
            return res;
        }
    }


    //就是迭代法呜呜呜，简单到吐了。
    class Solution {//2022年10月19日17:18:52复习

        public List<Double> averageOfLevels(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Double> res = new ArrayList<>();
            if (root != null) deque.offer(root);

            while (!deque.isEmpty()) {
                int curSize = deque.size();
                Double curSum = 0.0;//就用个指针来记录就行了。
                Double fenMu = curSize * 1.0;
                while (curSize > 0) {
                    TreeNode cur = deque.poll();
                    if (cur.left != null) deque.offer(cur.left);
                    if (cur.right != null) deque.offer(cur.right);
                    curSum += cur.val;
                    curSize--;
                }
                res.add(curSum / fenMu);
            }
            return res;
        }
    }
}
