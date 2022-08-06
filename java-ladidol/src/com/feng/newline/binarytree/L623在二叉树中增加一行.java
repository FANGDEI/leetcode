package com.feng.newline.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L623在二叉树中增加一行
 * @author: Ladidol
 * @description: 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 * 注意，根节点root位于深度1。
 * 加法规则如下:
 * 给定整数depth，对于深度为depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着depth - 1根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * 示例 1:
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * @date: 2022/8/5 13:50
 * @version: 1.0
 */
public class L623在二叉树中增加一行 {

    //层序遍历 bfs
    class Solution2 {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) return new TreeNode(val, root, null);
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int curDepth = 1;
            while (curDepth < depth - 1) {//需要先走到depth-1高度，来处理depth-1的子树
                int levelSize = queue.size();
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                curDepth++;
            }
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                cur.left = new TreeNode(val, cur.left, null);//存在左子树,有用到快捷插入节点的方法
                cur.right = new TreeNode(val, null, cur.right);//存在右子树
            }
            return root;
        }
    }


    //层序遍历 bfs 自己写的，开始理解错题意了，以为空子树不加新节点
    class Solution1 {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) return new TreeNode(val, root, null);
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {//需要先走到depth，来处理depth-1的子树
                int levelSize = queue.size();
                if (depth == 2) {
                    while (levelSize > 0) {
                        TreeNode cur = queue.poll();
                        cur.left = new TreeNode(val, cur.left, null);//存在左子树
                        cur.right = new TreeNode(val, null, cur.right);//存在右子树
                        levelSize--;
                    }
                    return root;
                }
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                depth--;
            }
            return root;
        }
    }

    //递归遍历 dfs
    class Solution {
        int val;
        int depth;

        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) return new TreeNode(val, root, null);
            this.val = val;
            this.depth = depth;
            dfs(root,1);
            return root;
        }

        void dfs(TreeNode root, int count) {
            if (root == null) return;
            if (count == depth - 1) {//到达depth-1
                root.left = new TreeNode(val, root.left, null);
                root.right = new TreeNode(val, null, root.right);
                return;//剪枝
            }
            dfs(root.left,count + 1);
            dfs(root.right,count + 1);
        }
    }
}
