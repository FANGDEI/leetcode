/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-13 11:25:15
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-21 22:13:30
 * @FilePath: \leetcode\javascript\Binary tree\102. 二叉树的层序遍历.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 */
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
 * @return {number[][]}
 */
/*  借助队列
 首先把根节点推入que，把根节点的值放入res[0]中存储。此时继续判断根节点下是否有left和rigt节点，如果有则将所有的left和right都推入que中继续处理，知道que中没有元素
 
 作者：60late
 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/102-er-cha-shu-de-ceng-xu-bian-li-js-by-5fwzx/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 */
 var levelOrder = function(root) {
    if(root === null ) return [] //边界条件，必须
    let res = []
    let que = []
    que.push(root)

    while(que.length){
        res.push([]) // 增加一个层级，res.length -1 即为当前到几级了
        const curLevelSize = que.length // 必须重新声明一份当前层级大小，因为下面会针对que用shift方法
        for(let i =0;i<curLevelSize;i++){
            let curNode = que.shift()
            res[res.length-1].push(curNode.val)
            if(curNode.left) que.push(curNode.left)
            if(curNode.right) que.push(curNode.right)
        }
    }
    return res
};

