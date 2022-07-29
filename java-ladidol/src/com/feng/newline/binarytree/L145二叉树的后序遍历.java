package com.feng.newline.binarytree;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L145二叉树的后序遍历
 * @author: Ladidol
 * @description: 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * @date: 2022/7/29 14:57
 * @version: 1.0
 */
public class L145二叉树的后序遍历 {

    //递归方式
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorder(root, res);
            return res;
        }
        void postorder(TreeNode root, List<Integer> res){
            if (root == null) return;
            postorder(root.left, res);//前
            postorder(root.right, res);//后
            res.add(root.val);//中
        }
    }
    //后序遍历迭代方式
    //和前序遍历有点瓜葛, 可以通过前序遍历演变而来

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            if (root == null) return res;
            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(res);
            return res;
        }
    }

    //有统一的前中后序遍历, 这里就先不写了, 有点难度.

}
