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
 * @param {number} k
 * @return {number}
 */

//二叉搜索树真的难蚌

var kthSmallest = function (root, k) {
    const ans=[]
    porcess(TreeNode,ans)
    return ans[k-1]
}
function porcess(Node,ans){
    process(Node.left)
    ans.push(Node.val,ans)
    process(Node.right)
}

