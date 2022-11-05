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
var zigzagLevelOrder = function (root) {
    if(root==null){
        return []
    }
    let ans = []
    let help = []
    help.push(root)
    let p = 0
    process(help, ans, p)
    return ans
};

function process( help, ans, p) {
    if (help.length == 0) return
    let r = help.length
    let res=[]
    for (let i = 0; i < r; i++) {
        let node = help.shift()
        res.push(node.val)
        if (node.left) help.push(node.left)
        if (node.right) help.push(node.right)
    }
    if(p==0){
        ans.push(res)
        p=1
    }else{
        ans.push(res.reverse())
        p=0
    }
    process(help,ans,p)
}
