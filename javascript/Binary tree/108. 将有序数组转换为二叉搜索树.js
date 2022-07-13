/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-12 20:39:12
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-12 20:56:01
 * @FilePath: \leetcode\javascript\Binary tree\108. 将有序数组转换为二叉搜索树.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
 var sortedArrayToBST = function(nums) {
    // 因为涉及到递归，所以必然会有数组为空的情况
    if(!nums.length) {
        return null;
    }

    // 找到序列中点：
    const headIndex = Math.floor(nums.length / 2);

    // 实例化节点头部
    const head = new TreeNode(nums[headIndex]);
    let temp = head;
    let left = headIndex - 1;
    let right = headIndex + 1;
    // 因为是有序升序列表，则当前头部索引的左侧应该都在树的左子树，同理右子树
    if(left >=0) {
        // 左侧有节点，对左侧节点递归，形成左子树
        head.left = sortedArrayToBST(nums.slice(0, headIndex));
    }
    if(right < nums.length) {
        // 右侧有节点，对右侧节点递归，形成右子树
        head.right = sortedArrayToBST(nums.slice(right));
    }
    // 返回节点
    return head;
};