package com.feng.newline.month._9_datastructure;

import com.feng.newline.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L987二叉树的垂序遍历
 * @author: Ladidol
 * @description: 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * @date: 2022/9/6 14:17
 * @version: 1.0
 */
public class L987二叉树的垂序遍历 {


    // 优先级队列：根据题意，我们需要按照优先级「“列号从小到大”，对于同列节点，“行号从小到大”，对于同列同行元素，“节点值从小到大”」进行答案构造。
    class Solution {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {//排序优先级：col，row，value；
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            int[] nodeInfo = new int[]{0, 0, root.val};//row,col,value;
            dfs(root, nodeInfo);
            List<List<Integer>> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                //将queue中一段段的分隔开
                List<Integer> tmp = new ArrayList<>();
                int[] info = queue.poll();
                tmp.add(info[2]);
                while (!queue.isEmpty() && info[1] == queue.peek()[1]) {
                    info = queue.poll();
                    tmp.add(info[2]);
                }
                // 可以将这个tmp这个指针在循环前加入list中去，因为是指针的原因。
                res.add(tmp);

            }
            return res;
        }

        void dfs(TreeNode root, int[] nodeInfo) {
            queue.offer(nodeInfo);//维护队列。
            if (root.left != null) dfs(root.left, new int[]{nodeInfo[0] + 1, nodeInfo[1] - 1, root.left.val});
            if (root.right != null) dfs(root.right, new int[]{nodeInfo[0] + 1, nodeInfo[1] + 1, root.right.val});
        }
    }
}
