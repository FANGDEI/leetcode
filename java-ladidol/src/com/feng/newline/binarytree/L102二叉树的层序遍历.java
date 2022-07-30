package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L102二叉树的层序遍历
 * @author: Ladidol
 * @description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @date: 2022/7/29 17:00
 * @version: 1.0
 */
public class L102二叉树的层序遍历 {
    //BFS--迭代方式--借助队列
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
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
            return res;
        }
    }


    class Solution2 {

        //checkFun01(root,0);

        //DFS--递归方式 这题主要是来熟悉bfs层序遍历的, 先简单过一下dfs
        public void checkFun01(TreeNode node, Integer deep) {
            List<List<Integer>> res = new ArrayList<>();
            if (node == null) return;
            deep++;

            if (res.size() < deep) {
                //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
                List<Integer> item = new ArrayList<Integer>();
                res.add(item);
            }
            res.get(deep - 1).add(node.val);

            checkFun01(node.left, deep);
            checkFun01(node.right, deep);
        }
    }
}
