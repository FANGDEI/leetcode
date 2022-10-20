package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L199二叉树的右视图
 * @author: Ladidol
 * @description: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * @date: 2022/7/29 19:54
 * @version: 1.0
 */
public class L199二叉树的右视图 {
    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (root == null) {
                return res;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                Integer rightOneValue = null;//这里巧用一个变量来代替判断每层最后一个元素的操作
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    rightOneValue = cur.val;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                res.add(rightOneValue);

            }
            return res;
        }
    }

    //迭代
    class Solution {//2022年10月19日17:14:37复习

        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            if (root != null) deque.offer(root);

            while (!deque.isEmpty()) {
                int curSize = deque.size();
                TreeNode theLastNode = new TreeNode();//就用个指针来记录就行了。
                while (curSize > 0) {
                    TreeNode cur = deque.poll();
                    if (cur.left != null) deque.offer(cur.left);
                    if (cur.right != null) deque.offer(cur.right);
                    theLastNode = cur;
                    curSize--;
                }
                res.add(theLastNode.val);
            }
            return res;
        }

    }
}
