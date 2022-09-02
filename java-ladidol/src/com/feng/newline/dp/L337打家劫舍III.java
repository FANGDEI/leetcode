package com.feng.newline.dp;

import com.feng.newline.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L337打家劫舍III
 * @author: Ladidol
 * @description: 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释:小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释:小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * 提示：
 * <p>
 * 树的节点数在[1, 104] 范围内
 * 0 <= Node.val <= 104
 * @date: 2022/9/2 21:15
 * @version: 1.0
 */
public class L337打家劫舍III {


    // 暴力遍历(TLE)
    class Solution1 {// 树形dp

        // 如果抢了当前节点，两个孩子就不能动，如果没抢当前节点，就可以考虑抢左右孩子（注意这里说的是“考虑”）
        // 树状dp这里从最上层开始考虑。
        // 后序遍历
        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.right == null && root.left == null) return root.val;
            int yes = root.val;
            int no = 0;
            //考虑当前节点
            if (root.right != null) yes += rob(root.right.left) + rob(root.right.right);
            if (root.left != null) yes += rob(root.left.left) + rob(root.left.right);
            //不考虑当前节点
            no += rob(root.right) + rob(root.left);
            return Math.max(yes, no);
        }
    }

    // 记忆化遍历
    // 暴力解法有重复运算：我们计算了root的四个孙子（左右孩子的孩子）为头结点的子树的情况，又计算了root的左右孩子为头结点的子树的情况，计算左右孩子的时候其实又把孙子计算了一遍。
    class Solution2 {
        Map<TreeNode, Integer> cache = new HashMap<>();//记忆化当前节点的打劫数；

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.right == null && root.left == null) return root.val;
            if (cache.containsKey(root)) return cache.get(root);
            int yes = root.val;
            int no = 0;
            //不考虑当前节点
            int rightSon = rob(root.right);
            int leftSon = rob(root.left);
            no += rightSon + leftSon;
            cache.put(root.right, rightSon);
            cache.put(root.left, leftSon);

            //考虑当前节点
            if (root.right != null) yes += rob(root.right.left) + rob(root.right.right);
            if (root.left != null) yes += rob(root.left.left) + rob(root.left.right);

            return Math.max(yes, no);
        }
    }


    class Solution3 {// 同上，只是这里是记录头结点
        Map<TreeNode, Integer> cache = new HashMap<>();//记忆化当前节点的打劫数；

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (root.right == null && root.left == null) return root.val;
            if (cache.containsKey(root)) return cache.get(root);
            int yes = root.val;
            int no = 0;
            //不考虑当前节点
            no += rob(root.right) + rob(root.left);

            //考虑当前节点
            if (root.right != null) yes += rob(root.right.left) + rob(root.right.right);
            if (root.left != null) yes += rob(root.left.left) + rob(root.left.right);
            cache.put(root, Math.max(yes, no));
            return Math.max(yes, no);
        }
    }


    // 3.状态标记递归
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    class Solution {
        public int rob(TreeNode root) {
            int[] res = treeDp(root);
            return Math.max(res[0], res[1]);
        }

        int[] treeDp(TreeNode root) {
            int[] res = new int[2];//默认0是不考虑当前节点，1是考虑当前节点。
            if (root == null) return res;//0
            int[] left = treeDp(root.left);
            int[] right = treeDp(root.right);
            // 不考虑当前节点。
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 考虑当前节点。
            res[1] = left[0] + right[0] + root.val;
            return res;
        }
    }
}
