package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-11-11:12
 */
@SuppressWarnings("all")
public class BM32合并二叉树 {

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        return mergeTreesHelper(t1,t2);
    }

    private TreeNode mergeTreesHelper(TreeNode t1, TreeNode t2) {
        //若只有一个节点返回另一个，两个都为null自然返回null
        if (t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        //剩下就为两个都不为null的情况了
        t1.val +=  t2.val;
        TreeNode node = t1;
        node.left = mergeTreesHelper(t1.left,t2.left);
        node.right = mergeTreesHelper(t1.right,t2.right);

        return node;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
