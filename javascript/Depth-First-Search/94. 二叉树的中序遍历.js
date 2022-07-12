/* 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 */
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
 * @return {number[]}
 */
 var inorderTraversal = function(root) {
    let res = [];
    function pushRoot (root) {
        if (root != null) {
            if (root.left != null) {
                pushRoot(root.left);
            }
            res.push(root.val);
            if (root.right != null) {
                pushRoot(root.right);
            }
        }
    }
    pushRoot(root);
    return res;
};
