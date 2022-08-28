package com.feng.newline.binarytree;

import javafx.util.Pair;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L662二叉树最大宽度
 * @author: Ladidol
 * @description: 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在 32 位 带符号整数范围内
 * @date: 2022/8/27 12:30
 * @version: 1.0
 */
public class L662二叉树最大宽度 {
    // u << 1 | 1 等价于 (u << 1) + 1
    //层序遍历，这一次简单的bfs就不行了，需要进行满二叉树编号
    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Deque<Pair<Integer, TreeNode>> queue = new ArrayDeque<>();
            queue.offer(new Pair<>(1, root));
            int maxWidth = 1;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int min = 0, max = 0;
                for (int i = 0; i < levelSize; i++) {
                    Pair<Integer, TreeNode> curPair = queue.poll();//这里取出来的是带编号的节点对
                    int order = curPair.getKey();
                    TreeNode cur = curPair.getValue();
                    if (i == 0) min = order;
                    if (i + 1 == levelSize) max = order;
                    if (cur.left != null) queue.offer(new Pair<>(order << 1, cur.left));//父代和子代编号的关系。
                    if (cur.right != null) queue.offer(new Pair<>((order << 1) + 1, cur.right));
                }
                maxWidth = Math.max(maxWidth, max - min + 1);//更新最大宽度，跨度记得加一
            }
            return maxWidth;
        }
    }

    //dfs，值得注意的是，前序遍历每一层最左边的节点一定是该层第一次出现的。
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();//深度和最左边非null节点的编号。
        int res;

        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 1, 0);
            return res;
        }

        void dfs(TreeNode root, int order, int depth) {
            if (root == null) return;
            if (!map.containsKey(depth)) map.put(depth, order);//该层第一个元素。
            res = Math.max(res, order - map.get(depth) + 1);
            dfs(root.left, order << 1, depth + 1);
            dfs(root.right, order << 1 | 1, depth + 1);
        }
    }


    //一个比较符合我之前写法的题解：
    class Solution2 { //用map来映射
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Map<TreeNode, Integer> map = new HashMap<>();//存储节点对应的下标
            Queue<TreeNode> queue = new LinkedList<>();//通过队列实现bfs
            //初始化
            int max = 1;
            queue.offer(root);
            map.put(root, 1);
            while (!queue.isEmpty()) {
                int start = map.get(queue.peek());//获取每层起始节点（即最左端点）的下标
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    size--;
                    int index = map.get(node);//获取此节点下标，用与给其的左右孩子确定下标
                    if (node.left != null) {
                        map.put(node.left, index * 2);//确定左孩子下标
                        queue.offer(node.left);//节点入队
                    }
                    if (node.right != null) {
                        map.put(node.right, index * 2 + 1);//确定右孩子下标
                        queue.offer(node.right);//节点入队
                    }
                    if (size == 0) max = Math.max(max, index - start + 1);//本层遍历结束，更新层宽最大值
                }
            }
            return max;
        }
    }


}
