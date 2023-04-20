package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Devildyw
 * @date 2023/04/20 12:32
 **/
@SuppressWarnings("all")
public class O34二叉树中和为某一值的路径 {

    public static void main(String[] args) {

    }

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        pathSumHelper(root,target);
        return result;
    }

    private void pathSumHelper(TreeNode root, int target) {

        if (root==null){
            return;
        }

        path.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null){
            result.add(new LinkedList<>(path));//创建多个LinkedList对象
        }
        //先序遍历 == 记录经过的节点 中左右 左右模拟回溯的情况 这里就不用回溯target了 但是path需要回溯
        pathSumHelper(root.left,target);
        pathSumHelper(root.right,target);

        //回溯
        path.removeLast();

        return;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
