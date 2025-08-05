/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._04二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/5 10:24
 */
public class h236二叉树的最近公共祖先 {


  class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // 自底向上，回溯，通过递归的后续便利就能搞定
      if (root == q || root == p || root == null) {
        return root;
      }
      TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
      TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
      if (leftResult != null && rightResult != null) {
        return root;
      }
      return leftResult == null ? rightResult : leftResult;
    }
  }


  // 二叉树递归遍历
  public void traversal(TreeNode cur, List<TreeNode> result) {
    if (cur == null) {
      return;
    }
    traversal(cur.left, result);
    traversal(cur.right, result);
    result.add(cur);
  }

  // 二叉树迭代遍历
  // 前序遍历 中左右》入栈顺序是右左
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return result;
    }
    stack.push(root);
    TreeNode cur = new TreeNode();
    while (!stack.isEmpty()) {
      cur = stack.pop();
      result.add(cur.val);// 弹出的时候，才记录
      if (cur.right!= null) stack.push(cur.right);
      if (cur.left != null) stack.push(cur.left);
    }
    return result;
  }

  // 中序遍历 左中右
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return result;
    }
    TreeNode cur = root;
    while (cur!=null || !stack.isEmpty()) {
      // 先遍历到最左边
      if (cur != null){
        stack.push(cur);
        cur = cur.left;
      }else {
        cur = stack.pop();
        result.add(cur.val);
        cur = cur.right; // 将右节点压入栈，遍历右子树
      }
    }
    return result;
  }

  // 后序遍历 左右中》等价于中右左的反转，所以入栈顺序
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return result;
    }
    stack.push(root);
    TreeNode cur = new TreeNode();
    while (!stack.isEmpty()) {
      cur = stack.pop();
      result.add(cur.val);// 弹出的时候，才记录
      if (cur.left != null) stack.push(cur.left);
      if (cur.right!= null) stack.push(cur.right);
    }
    Collections.reverse(result);
    return result;
  }

}
