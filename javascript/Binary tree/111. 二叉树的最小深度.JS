/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-12 18:02:07
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-12 18:12:42
 * @FilePath: \leetcode\javascript\Depth-First-Search\111. 二叉树的最小深度.JS
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。 */
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
 * @return {number}
 */
 var minDepth = function(root) {
    if(!root){
        return 0
    }
    let left=minDepth(root.left)
    let right=minDepth(root.right)
    if(!root.left||!root.right){
        return Math.max(left,right)+1
    }
    return Math.min(left,right)+1
};