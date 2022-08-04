package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L235二叉搜索树的最近公共祖先
 * @author: Ladidol
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 * @date: 2022/8/3 22:55
 * @version: 1.0
 */
//我是摆烂小王子！
public class L235二叉搜索树的最近公共祖先 {
    //普通二叉树求最近公共祖先需要使用回溯，从底向上来查找，二叉搜索树就不用了，因为搜索树有序（相当于自带方向），那么只要从上向下遍历就可以了。
    //https://img-blog.csdnimg.cn/20210204150858927.png
    //因为一定书里面一定存在pq的，所以，只要开始分流就证明该分流点就是最近公共祖先。
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root;
            if (root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);//往左边找
            if (root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);//往右边找
            return root;//一左一右
        }
    }
}
