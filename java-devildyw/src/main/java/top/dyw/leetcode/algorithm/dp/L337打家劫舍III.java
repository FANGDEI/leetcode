package top.dyw.leetcode.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * @author Devil
 * @since 2022-11-12-14:56
 */
@SuppressWarnings("all")
public class L337打家劫舍III {
    public static void main(String[] args) {

    }

    /**
     * 与打家劫舍的区别 该题是树形dp
     * 动态规划 且防止超时 对递归的值做一个记录
     * 树的递归顺序：后序遍历
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        //用来记录递归的值 防止重复计算 又因为后序遍历 这样可以节省很多时间
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robAction(root, memo);
    }

    private int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root==null){
            return 0;
        }

        //如果当前的值已经缓存在了map 中 直接返回
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        /**
         * 因为左子树和右子树没有直接相连 所以可以同时偷左右子树的房屋
         */
        //如果偷了父节点 那么就不能偷父节点相连的两个子节点 而是子节点的左右字节点

        int money = root.val;
        if (root.left!=null){
            money+=robAction(root.left.left,memo)+robAction(root.left.right,memo);
        }
        if (root.right!=null){
            money+=robAction(root.right.right,memo)+robAction(root.right.left,memo);
        }
        int res = Math.max(money,robAction(root.left,memo)+robAction(root.right,memo));
        //将值存于map中 下次访问到节点时先判断是否访问了 如果有直接取出 减少了耗时
        memo.put(root,res);
        //与不偷父节点的左右子节点的值做对比取最大值
        return res;
    }


    /**
     * 动态规划 普通递归 会超时
     *
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 因为左子树和右子树没有直接相连 所以可以同时偷左右子树的房屋
         */
        //如果偷了父节点 那么就不能偷父节点相连的两个子节点 而是子节点的左右字节点
        int money = root.val;
        if (root.left != null) {
            money += rob1(root.left.left) + rob1(root.left.right);
        }
        if (root.right != null) {
            money += rob1(root.right.left) + rob1(root.right.right);
        }
        //与不偷父节点的左右子节点的值做对比取最大值
        return Math.max(money, rob1(root.left) + rob1(root.right));
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
