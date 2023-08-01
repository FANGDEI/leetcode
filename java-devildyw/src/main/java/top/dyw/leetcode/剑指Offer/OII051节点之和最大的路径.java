package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/29 10:23
 **/
@SuppressWarnings("all")
public class OII051节点之和最大的路径 {

    //记录最大路径和
    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 计算当前节点最大的贡献值 自底向上
     * 就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大 就是贡献值
     *
     * @param root
     * @return
     */
    private int  maxGain(TreeNode root) {
        if (root==null){
            return 0;
        }

        //计算左右子树的最大贡献值
        //大于0时，才会选取对应的子节点
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);

        int priceNewPath = root.val+leftGain+rightGain;

        //更新最大路径和
        maxSum = Math.max(maxSum,priceNewPath);
        //返回当前节点的最大贡献值 为了计算父节点的最大贡献值 因为对于父节点来说，子树只能提供其从根节点到左右子树的一条路径因为父节点也有左子树
        return root.val+Math.max(leftGain,rightGain);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
