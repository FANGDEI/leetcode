package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/29 09:40
 **/
@SuppressWarnings("all")
public class OII050向下的路径节点之和 {

    public static void main(String[] args) {

    }


    /**
     * 递归处理左右子树 选择一个节点的根 左 右分别作为路径的起点，再交由countPath方法计算满足条件的路径数量
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        //以当前节点为根节点的路径节点之和
        int startFromRoot = countPath(root, targetSum);
        //以当前节点的左子树为根节点的路径节点之和
        int startFromLeft = pathSum(root.left, targetSum);
        //以当前节点的右子树为根节点的路径节点之和
        int startFromRight = pathSum(root.right, targetSum);
        return startFromRight + startFromLeft + startFromRoot;
    }

    /**
     * 计算以当前节点为起点的满足条件的路径数量
     * 用long来存储targetSum的值，因为targetSum可能会超过int的范围
     * @param root
     * @param targetSum
     * @return
     */
    private int countPath(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        //计算以当前节点为起点的路径数量
        int count = 0;
        if (root.val == targetSum) {
            count++;
        }

        //继续递归遍历左子树和右子树
        count += countPath(root.left, targetSum - root.val);
        count += countPath(root.right, targetSum - root.val);
        return count;
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
