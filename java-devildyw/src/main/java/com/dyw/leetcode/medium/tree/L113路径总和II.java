package com.dyw.leetcode.medium.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-11-10:02
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
@SuppressWarnings("all")
public class L113路径总和II {
    public static void main(String[] args) {

    }
    //初始化返回结果集
    List<List<Integer>> ret = new LinkedList<>();
    //记录中间值防止重复计算
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //调用dfs 完成深度优先遍历
        dfs(root,targetSum);
        return ret;
    }

    /**
     * dfs 深度优先遍历
     * @param root
     * @param targetSum
     */
    private void dfs(TreeNode root, int targetSum) {
        if (root==null){
            return;
        }
        //进入该层递归 先将该节点值存放到队列末尾中
        path.offerLast(root.val);
        //更新targetSum
        targetSum-=root.val;
        //如果该节点既是叶子节点 targetSum又更新为0了 说明该路径为目标路径之一 将此时的队列中的元素生成链表 加入结果集
        if (root.left==null&&root.right==null&&targetSum==0){
            ret.add(new LinkedList<Integer>(path));
        }
        //深度优先搜索
        dfs(root.left,targetSum);
        //深度优先搜索
        dfs(root.right,targetSum);
        //退出该层递归时需要将该层加入队列的值删除才行 否则会影响结果
        path.pollLast();
    }

    private void dfs01(TreeNode root, int targetSum) {
        if (root==null){
            return;
        }
        path.offerLast(root.val);

        targetSum-=root.val;

        if (root.left==null&&root.right==null&&targetSum==0){
            ret.add(new LinkedList<>(path));
        }

        dfs01(root.left,targetSum);
        dfs01(root.right,targetSum);
        path.pollLast();
    }
}
