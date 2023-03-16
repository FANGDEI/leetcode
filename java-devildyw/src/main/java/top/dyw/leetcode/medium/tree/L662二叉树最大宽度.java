package top.dyw.leetcode.medium.tree;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-08-27-9:58
 *
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在 32 位 带符号整数范围内。
 *
 */
@SuppressWarnings("all")
public class L662二叉树最大宽度 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        System.out.println(new L662二叉树最大宽度().widthOfBinaryTree(treeNode));
    }

    /**
     * 使用list记录每一层的最小编号的下标 和最大编号的下标 每一层的宽度就是他们两者的差
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        ArrayList<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root,1));
        while (!arr.isEmpty()){
            ArrayList<Pair<TreeNode, Integer>> temp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                Integer value = pair.getValue();
                //如果该节点左子树或右子树不为空 那么他们的编号值*2 右子树比左子树多一所以+1 因为按照规律 下一层的最大节点个数是上一层的两倍
                if (node.left!=null){
                    temp.add(new Pair<>(node.left,value*2));
                }
                if (node.right!=null){
                    temp.add(new Pair<>(node.right,value*2+1));
                }
            }
            res = Math.max(res,arr.get(arr.size()-1).getValue()-arr.get(0).getValue()+1);
            arr = temp;
        }
        return res;
    }
}
