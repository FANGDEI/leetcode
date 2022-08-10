package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L257二叉树的所有路径
 * @author: Ladidol
 * @description: 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * @date: 2022/8/9 21:15
 * @version: 1.0
 */
public class L257二叉树的所有路径 {
    class Solution {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return res;
            traversal(root);
            return res;
        }

        void traversal(TreeNode root) {

            path.add(root.val);

            if (root.left == null && root.right == null) {//叶子结点
                StringBuilder sb = new StringBuilder(String.valueOf(path.get(0)));
                for (int i = 1; i < path.size(); i++) {
                    sb.append("->").append(path.get(i));
                }
                res.add(String.valueOf(sb));
                return;
            }

            if (root.left != null) {
                traversal(root.left);
                path.remove(path.size() - 1);//回溯，自始至终path都是同一个变量。
            }
            if (root.right != null) {
                traversal(root.right);
                path.remove(path.size() - 1);//回溯,回溯一般跟在递归后面，有一个递归，就俩一个回溯这样方便一点。
            }
        }
    }
    //下面是把回溯的位置换了一下。
    class Solution2 {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return res;
//            path.add(root.val);
            traversal(root);
            return res;
        }

        void traversal(TreeNode root) {//这里传入的引用参数是同一个。

            path.add(root.val);

            if (root.left == null && root.right == null) {//叶子结点
                StringBuilder sb = new StringBuilder(String.valueOf(path.get(0)));
                for (int i = 1; i < path.size(); i++) {
                    sb.append("->").append(path.get(i));
                }
                path.remove(path.size() - 1);//回溯！！！！！！！！！！这里不要忘记回溯了
                res.add(String.valueOf(sb));
                return;
            }

            if (root.left != null) {
                traversal(root.left);
//                path.remove(path.size() - 1);//回溯，自始至终path都是同一个变量。
            }
            if (root.right != null) {
                traversal(root.right);
//                path.remove(path.size() - 1);//回溯
            }
            path.remove(path.size() - 1);//回溯！！！！！！！！！回溯改到这里来了
        }
    }
}
