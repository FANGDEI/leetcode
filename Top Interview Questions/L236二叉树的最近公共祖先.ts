/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}


function lowestCommonAncestor(
    root?: TreeNode | null,
    p?: TreeNode | null,
    q?: TreeNode | null,
): TreeNode | null {
    if (!root) return null;
    const visited = new WeakSet<TreeNode>();

    const parent = new WeakMap<TreeNode, TreeNode | null>();
    dfs(root, parent);

    while (p) {
        visited.add(p);
        p = parent.get(p);
    }
    while (q) {
        if (visited.has(q)) return q;
        q = parent.get(q);
    }
    return null;
}

function dfs(root: TreeNode, parent: WeakMap<TreeNode, TreeNode | null>) {
    if (root.left) {
        parent.set(root.left, root);
        dfs(root.left, parent);
    }
    if (root.right) {
        parent.set(root.right, root);
        dfs(root.right, parent);
    }
}
