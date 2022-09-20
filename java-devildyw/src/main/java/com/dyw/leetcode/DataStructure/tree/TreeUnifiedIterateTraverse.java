package com.dyw.leetcode.DataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Stack;

/**
 * 二叉树的统一迭代法
 * <p>
 * 前面的迭代法的风格不是很统一 这里用一种很统一的写法来完成。
 *
 * @author Devil
 * @since 2022-09-20-10:51
 */
@SuppressWarnings("all")
public class TreeUnifiedIterateTraverse {

    /**
     * 中序遍历 统一迭代法
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209201120694.gif">
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();//将该节点弹出，避免重复操作，如果节点不为空 则将该节点的子节点按 右 中 左 的顺序假如栈中
                if (node.right != null) { //添加右节点
                    stack.push(node.right);
                }
                stack.push(node); //添加中间节点
                stack.push(null); //中间节点访问过，但是没有处理，加入空节点做标记 方便后面处理
                if (node.left != null) {//添加左节点
                    stack.push(node.left);
                }
            } else { //如果 node 为空节点
                stack.pop();
                node = stack.pop(); //弹出
                result.add(node.val); //加入到结果集中
            }
        }

        return result;
    }


    /**
     * 线序遍历 统一迭代法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //初始化结果集
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){ //如果node 节点不为空节点 那么将其子节点按 右 左 中的顺序来加入栈中 这样遍历时就是按 中 左 右了
                stack.pop();
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null); //同样 中间节点只是访问但是没有处理 这里做一个标记
            }else{
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    /**
     * 后续遍历 统一迭代法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }else{
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
