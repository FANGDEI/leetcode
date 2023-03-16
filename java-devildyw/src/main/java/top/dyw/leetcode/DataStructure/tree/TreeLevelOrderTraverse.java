package top.dyw.leetcode.DataStructure.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 *
 * @author Devil
 * @since 2022-09-20-12:37
 */
@SuppressWarnings("all")
public class TreeLevelOrderTraverse {

    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun01(root,0);
//        checkFun02(root);

        return resList;
    }

    /**
     * DFS--递归方式
     * @param root
     * @param deep
     */
    private void checkFun01(TreeNode node, int deep) {
        if (node == null){
            return;
        }
        deep++;

        if (resList.size()<deep){
            //当层级增加时，list 的 Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }

        resList.get(deep - 1).add(node.val);

        checkFun01(node.left,deep);
        checkFun01(node.right,deep);
    }

    /**
     * BFS 迭代方式--借助队列
     * @param root
     */
    private void checkFun02(TreeNode root) {
        if (root==null){
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = deque.size();

            while (len>0){
                TreeNode tempNode = deque.poll();
                list.add(tempNode.val);
                if (tempNode.left!=null){
                    deque.offer(tempNode.left);
                }
                if (tempNode.right!=null){
                    deque.offer(tempNode.right);
                }
                len--;
            }
            resList.add(list);
        }
    }




}
