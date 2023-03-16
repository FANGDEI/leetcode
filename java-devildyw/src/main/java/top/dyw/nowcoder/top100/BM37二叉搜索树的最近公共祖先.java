package top.dyw.nowcoder.top100;


/**
 * @author Devil
 * @since 2023-01-12-11:12
 */
@SuppressWarnings("all")
public class BM37二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

    }


    //todo：复习
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        return lowestCommonAncestorHelper(root,p,q).val;


    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, int p, int q) {
        if (root==null){
            return null;
        }
        TreeNode ancestor = root;
        //无限循环 根据二叉搜索树的性质
        while (true){
            //如果根节点的值同时大于 p 和 q 说明他们的最近公共祖先在该节点的左子树上
            if (ancestor.val>p&&ancestor.val>q){
                ancestor = ancestor.left;
            //如果根节点的值同时小于 p 和 q 说明他们的最近公共祖先在该节点的右子树上
            }else if (ancestor.val<p&&ancestor.val<q){
                ancestor = ancestor.right;
            }else{//都不是说明一个节点的最近祖先在该节点的左子树 另一个在右子树所以他们的最近祖先就是现祖先节点 直接跳出循环返回
                break;
            }
        }
        return ancestor;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
