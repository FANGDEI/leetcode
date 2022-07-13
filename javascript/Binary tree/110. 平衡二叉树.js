/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-12 17:20:40
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-12 17:26:02
 * @FilePath: \leetcode\javascript\Depth-First-Search\110. 平衡二叉树.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 */
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
 var isBalanced = function(root) {
    let p=0
    if(!root){
        return true
    }
    var calculate=function(r){
        if(!r){
            return 0
        }
        else{
            const right=calculate(r.right)
            const left=calculate(r.left)
            if(Math.abs(right-left)>1)
            p=1
            return Math.max(right,left)+1
        }
    }
    calculate(root)
    return p==0?true:false
};