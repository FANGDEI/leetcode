package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L236二叉树的最近公共祖先
 * @author: Ladidol
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @date: 2022/8/3 22:14
 * @version: 1.0
 */
public class L236二叉树的最近公共祖先 {


    //听评论说这就是LCA——最近公共祖先（Least Common Ancestors，LCA）问题(* ￣︿￣)这不名字就摆在这里吗！能不是吗。
    //”从节点处往祖先那里找，这里就要用到回溯，后序遍历就是天然的回溯“说实话看不太明白回溯在哪里。
    class Solution {
        //显而易见，
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //麻了有点看不太懂。那我就直接硬记了！https://img-blog.csdnimg.cn/2021020415105872.png
            if (root == p || root == q || root == null) return root;//寻找到p/q就返回它们，没寻找到就返回null；
            //后序遍历
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

            //处理返回值，美其名曰：回溯
            if (leftNode == null && rightNode == null) return null;//知道都没找到了；
            if (leftNode == null && rightNode != null) return rightNode;//传递存在的那一条
            if (leftNode != null && rightNode == null) return leftNode;//传递
            return root;//知道就只有当前
        }
    }
    //提示中的这些条件很有用，造就pg一定会回溯到自己的最近祖先面前，且一直把答案传回最外层！！！！
    //所有 Node.val 互不相同 。
    //p != q
    //p 和 q 均存在于给定的二叉树中。
}
