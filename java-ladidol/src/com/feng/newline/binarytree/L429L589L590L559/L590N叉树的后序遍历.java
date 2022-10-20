package com.feng.newline.binarytree.L429L589L590L559;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree.L429L589
 * @className: L590N叉树的后序遍历
 * @author: Ladidol
 * @description: 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * @date: 2022/7/30 0:20
 * @version: 1.0
 */
public class L590N叉树的后序遍历 {
    class Solution1 {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<Node> stack = new ArrayDeque<>();//一个节点群为单位下压.
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                res.add(cur.val);
                List<Node> children = cur.children;
                for (Node child : children) {
                    if (child != null) {
                        stack.push(child);
                    }
                }
            }
            Collections.reverse(res);
            return res;
        }
    }

    //递归
    class Solution {//2022年10月19日16:43:20复习

        public List<Integer> postorder(Node root) {
            dfs(root);
            return res;
        }

        List<Integer> res = new ArrayList<>();

        void dfs(Node root) {
            if (root == null) return;
            for (Node child : root.children) {
                dfs(child);
            }
            res.add(root.val);
        }
    }


}
