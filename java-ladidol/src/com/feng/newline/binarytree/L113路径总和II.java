package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L113路径总和II
 * @author: Ladidol
 * @description: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * @date: 2022/8/4 13:18
 * @version: 1.0
 */
public class L113路径总和II {

    //会操作，当前层的数据，需要下一层子节点的状态，所以遍历中不存在空间点root
    //还有优化空间就是不需要sum这个参数，字节targetSum-- == 0即可
    class Solution {
        List<Integer> path = new ArrayList<>();//路径
        List<List<Integer>> res = new ArrayList<>();//装路径的结果

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root ==null) return res;
            path.add(root.val);//把根节点放进去，初始化path
            traversal(root, root.val, targetSum);//只要存在path，res里面就一定有值了。
            return res;
        }

        void traversal(TreeNode root, int sum, int targetSum) {
            if (root.left == null && root.right == null && sum == targetSum) {
                res.add(new ArrayList<>(path));//叶子结点，且满足条件
                return;
            }
            if (root.left == null && root.right == null) return;//叶子结点

            if (root.left != null) {// 左 （空节点不遍历）
                sum += root.left.val;
                path.add(root.left.val);
                traversal(root.left, sum, targetSum);//递归
                sum -= root.left.val;                //回溯
                path.remove(path.size()-1);   //回溯
            }
            if (root.right != null) {// 右 （空节点不遍历）
                sum += root.right.val;
                path.add(root.right.val);
                traversal(root.right, sum, targetSum);//递归
                sum -= root.right.val;                //回溯
                path.remove(path.size()-1);    //回溯
            }

        }
    }
}
