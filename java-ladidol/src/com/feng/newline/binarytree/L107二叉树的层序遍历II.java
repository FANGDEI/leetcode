package com.feng.newline.binarytree;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: LK107二叉树的层序遍历II
 * @author: Ladidol
 * @description:
 * @date: 2022/7/29 17:26
 * @version: 1.0
 */
public class L107二叉树的层序遍历II {//就是I的res数组翻转一下就行了
    //BFS--迭代方式--借助队列
    class Solution123 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()){//主要利用了每一层中queue都会增加的
                int len = queue.size();
                List<Integer> levelList = new ArrayList<>();
                while(len>0){//这是上一层的遍历,用len就不会受当前queue的大小影响.
                    TreeNode cur = queue.poll();
                    levelList.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    len--;
                }
                res.add(levelList);
            }
            Collections.reverse(res);
            return res;
        }
    }

    class Solution {//2022年10月19日17:13:34复习 you are always right
        /**
         * 参数：[root]
         * 返回值：java.util.List<java.util.List<java.lang.Integer>>
         * 作者： ladidol
         * 描述： 就是这是需要从最后一层往最上面一层走，这个方法的话可以正常的通过层序迭代遍历然后res翻转一下就行了。
         * 但是这里我不这么做
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            Deque<TreeNode> deque = new ArrayDeque<>();
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root != null) deque.offer(root);
            while (!deque.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int curSize = deque.size();//当前层父节点；
                while (curSize > 0) {
                    TreeNode cur = deque.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) deque.offer(cur.left);
                    if (cur.right != null) deque.offer(cur.right);
                    curSize--;
                }
                res.addFirst(tmp);
            }
            return res;
        }
    }

}
