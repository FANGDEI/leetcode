package com.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Devil
 * @since 2022-09-23-10:17
 */
@SuppressWarnings("all")
public class L572另一棵树的子树 {

    /**
     * 先找到一个符合节点 再通过这个节点往下对比 查看是否相等
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null&&subRoot==null){
            return true;
        }
        if (root==null||subRoot==null){
            return false;
        }
        boolean flag = false;
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.peek();
            if (node!=null){
                deque.pop();
                if (node.right!=null){
                    deque.push(node.right);
                }
                if (node.left!=null){
                    deque.push(node.left);
                }
                deque.push(node);
                deque.push(null);
            }else{
                deque.pop();
                node = deque.pop();
                if (node.val==subRoot.val){
                   flag =  compareSubtree(node,subRoot);
                }
                if (flag==true){
                    return flag;
                }
            }
        }
        return flag;
    }

    private boolean compareSubtree(TreeNode node, TreeNode subRoot) {
        if (node==null&&subRoot==null){
            return true;
        }
        if (node==null||subRoot==null){
            return false;
        }
        return (node.val==subRoot.val)&&compareSubtree(node.left,subRoot.left)&&compareSubtree(node.right,subRoot.right);
    }

}
