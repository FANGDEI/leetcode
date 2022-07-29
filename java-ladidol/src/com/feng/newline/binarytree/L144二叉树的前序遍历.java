package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L144二叉树的前序遍历
 * @author: Ladidol
 * @description: 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * @date: 2022/7/29 14:45
 * @version: 1.0
 */
public class L144二叉树的前序遍历 {
    //递归方式
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(root, res);
            return res;
        }

        void preorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);//中
            preorder(root.left, res);//前
            preorder(root.right, res);//后
        }
    }

    // 迭代遍历
    //通过栈来实现
    /*前序遍历是中左右，每次先处理的是中间节点，
    那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
    为什么要先加入 右孩子，再加入左孩子呢？
    因为这样出栈的时候才是中左右的顺序。*/
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左，出栈顺序：中-左-右
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            if (root == null) return res;
            stack.push(root);//将根节点放入栈
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
            return res;
        }
    }


}
