package com.dyw.leetcode.simple.string;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-06-22-12:57
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
@SuppressWarnings("all")
public class L257二叉树的所有路径 {
    public static void main(String[] args) {

    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String s, ArrayList<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(s);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPaths(root.right, pathSB.toString(), paths);
                constructPaths(root.left, pathSB.toString(), paths);
            }
        }

    }
}
