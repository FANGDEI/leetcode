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
const levelOrder = function(root) {
    let ans=[]
    let queue=[]
    if(root==null){
        return ans
    }
    queue.push(root)
    process(queue,ans)
    return ans
};
function process(queue,ans){
    if(queue.length==0){
        return
    }

    let hp=queue.length
    let res=[]
    for(let i=0;i<hp;i++){
        let p=queue.shift()
        if(p){
            res.push(p.val===undefined?0:p.val)
            if(p.left!==null) queue.push(p.left)
            if(p.right!==null) queue.push(p.right)
        }
    }
    ans.push(res)

    process(queue,ans)
}
