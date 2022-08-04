package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    class Solution {
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
}
