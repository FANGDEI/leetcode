/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-12 10:28:50
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-12 11:37:23
 * @FilePath: \leetcode\javascript\Depth-First-Search\给你一个二叉树的根节点 root ， 检查它是否轴对称。.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个二叉树的根节点 root ， 检查它是否轴对称。 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function (root) {
    if (root.left == null && root.right == null) {
        return true
    }
    if (!root.left || !root.right)
        return false
    if (root.val != root.right.val) {
        return false
    }
    var isSameTree = function (p, q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    isSameTree(root.left, root.right)
}