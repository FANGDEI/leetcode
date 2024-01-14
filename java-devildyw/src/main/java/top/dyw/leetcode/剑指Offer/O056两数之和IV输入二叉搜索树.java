package top.dyw.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/08/04 14:52
 **/
@SuppressWarnings("all")
public class O056两数之和IV输入二叉搜索树 {

    public static void main(String[] args) {

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


    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root==null){
            return false;
        }

        boolean left = findTarget(root.left,k);
        boolean mid = false;
        if (set.contains(k - root.val)){
            mid = true;
        }
        set.add(root.val);
        boolean right = findTarget(root.right,k);

        return left || mid || right;
    }
}
