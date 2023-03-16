package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-01-11-11:52
 */
@SuppressWarnings("all")
public class BM34判断是不是二叉搜索树 {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //记录上一个值 用来判断序列是否有序
    int pre = Integer.MIN_VALUE;

    //todo:复习
    /**
     * 二叉搜索树 特性就是对于每一个子树而言 左子树小于根节点 右子树大于根节点 但要注意不能简单地判断每个子树 还要考虑该子树的父节点 防止出现子节点的左子树大于根节点的情况
     *
     * 所以这里使用了中序遍历来判断顺序 因为二叉搜索树的中序遍历是有序的序列
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //中序遍历
        // write code here
        if (root==null){
            return true;
        }
        //先进入左子树
        if (!isValidBST(root.left)){
            return false;
        }
        //保证序列是单调递增的
        if (root.val<pre){
            return false;
        }
        //更新最小值
        pre = root.val;
        //再进入右子树
        return isValidBST(root.right);
    }


    public boolean isValidBSTTest(TreeNode root) {
        if (root==null){
            return true;
        }

        if (!isValidBSTTest(root.left)){
            return false;
        }
        if (root.val<pre){
            return false;
        }
        pre = root.val;

        return isValidBSTTest(root.right);
    }
}
