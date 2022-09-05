package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L652寻找重复的子树
 * @author: Ladidol
 * @description: 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * 示例 1：
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * @date: 2022/9/5 13:58
 * @version: 1.0
 */
public class L652寻找重复的子树 {
    // DFS + 哈希表
    // 设计递归函数 String dfs(TreeNode root)，含义为返回以传入参数 root 为根节点的子树所对应的指纹标识。
    // 对于标识的设计只需使用 "|" 分割不同的节点值，同时对空节点进行保留（定义为空串 " "）即可。
    // 使用哈希表记录每个标识（子树）出现次数，当出现次数为 22（首次判定为重复出现）时，将该节点加入答案。
    class Solution {

        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();


        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return res;
        }

        // 得到当前root的指纹（key）
        String dfs(TreeNode root) {
            if (root == null) return " ";
            StringBuilder sb = new StringBuilder();
            //为避免出现11+1==1+11的字符串情况，这里把子代和父代用标记隔开。
            sb.append(root.val).append("|").append(dfs(root.left)).append(dfs(root.right));
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 2) res.add(root);
            return key;
        }

    }
}
