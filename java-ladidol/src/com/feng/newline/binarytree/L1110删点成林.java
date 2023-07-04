package com.feng.newline.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/30 9:23
 * @description: {}
 */
public class L1110删点成林 {

    class Solution {

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            //这里用的哈希表去重，值得注意的是每一个节点的值都是不一样的，所以用Integer来去重
            Set<Integer> set = new HashSet<>();
            for (int i : to_delete) {
                set.add(i);
            }
            if (dfs(root, set) != null) res.add(root);
            return res;
        }

        List<TreeNode> res = new LinkedList<>();

        public TreeNode dfs(TreeNode root, Set<Integer> set) {
            if (root == null) return null;
            root.left = dfs(root.left, set);
            root.right = dfs(root.right, set);
            if (!set.contains(root.val)) return root;//不删除
            if (root.left != null && !set.contains(root.left.val)) res.add(root.left);
            if (root.right != null && !set.contains(root.right.val)) res.add(root.right);
            return null;
        }
    }
}
