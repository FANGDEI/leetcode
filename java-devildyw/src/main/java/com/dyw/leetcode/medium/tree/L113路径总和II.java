package com.dyw.leetcode.medium.tree;

import java.util.ArrayList;
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


    /**
     * 递归 因为我们讲结果集 List<List<Interger>> 作为了参数传入递归函数 所以这里我们不需要让递归函数拥有返回值
     *
     * path 用于记录路径 没到一个节点就会记录一个节点 每一层返回也有相应的回溯。
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum01(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        preorderdfs(root,targetSum,res,path);
        return res;
    }

    private void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        //遇到了叶子节点
        if (root.left==null&&root.right==null){
            //如果找到了和为 targetSum 的路径
            if ((targetSum-=root.val)==0){
                res.add(new ArrayList<>(path));
            }
            return;//如果不为targetSum，则返回
        }

        if (root.left!=null){
            preorderdfs(root.left,targetSum-root.val,res,path);
            path.remove(path.size()-1);//回溯
        }
        if (root.right!=null){
            preorderdfs(root.right,targetSum-root.val,res,path);
            path.remove(path.size()-1);
        }
    }


}
