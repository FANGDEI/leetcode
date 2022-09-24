package com.dyw.leetcode.simple.tree;

import java.util.*;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author Devil
 * @since 2022-09-24-11:48
 */
@SuppressWarnings("all")
public class L257二叉树的所有路径 {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        //结果集
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //记录路径
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    /**
     * 递归法
     *
     * @param root
     * @param paths
     * @param res
     */
    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        //先将当前节点加入paths中
        paths.add(root.val);
        //如果是叶子节点 并且也是递归的终止条件
        if (root.left == null && root.right == null) {
            //输出路径到 res结果集中
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        //如果不是叶子节点 则向下到 它的左右子节点 并且遍历后还要回溯 因为我们只拿了一个paths列表来记录路径 需要回溯将前面遍历过的节点的路径删除
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1); //回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);//回溯
        }
    }


    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths01(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Object> deque = new LinkedList<>();
        //节点和路径同时入栈
        deque.push(root);
        deque.push(root.val + "");
        while (!deque.isEmpty()){
            //节点和路径同时出栈
            String path = (String) deque.pop();
            TreeNode node = (TreeNode) deque.pop();

            //如果是叶子节点 就将路径填入结果集
            if (node.left==null&&node.right==null){
                result.add(path);
            }

            //如果不是叶子节点 去看他的左右子节点是否为空 不为空则将其压栈比较将路径更新再压栈
            if (node.right!=null){
                deque.push(node.right);
                deque.push(path+"->"+node.right.val);
            }

            if (node.left!=null){
                deque.push(node.left);
                deque.push(path+"->"+node.left.val);
            }
        }
        return result;

    }
}
