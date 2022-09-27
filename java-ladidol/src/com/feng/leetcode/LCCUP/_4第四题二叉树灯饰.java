package com.feng.leetcode.LCCUP;

import com.feng.newline.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.LCCUP
 * @className: 第四题
 * @author: Ladidol
 * @description:
 * @date: 2022/9/24 15:57
 * @version: 1.0
 */
public class _4第四题二叉树灯饰 {
    class Solution {
        public int closeLampInTree(TreeNode root) {
            return 0;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    // 2022年9月27日20:32:53什么神仙打架啊看不懂。
    class Solution2 {

        Map<TreeNode, int[][]> map;


        public int closeLampInTree(TreeNode root) {

            //动态规划时间复杂度分析：
            //O（状态个数） * （单个状态的转移个数）
            //O(4n) * O(8) = O(n) * O(1) = O(n)
            //空间复杂度是：
            //O(状态个数)
            //O(n)

            //需要加上记忆化搜索
            //每个节点有4个状态，因此需要记录每个节点的四个状态

            map = new HashMap<>();

            return dfs(root, false, false);
        }

        /**
         * 灯开
         * ① 开关1
         * ② 开关2
         * ③ 开关3
         * ④ 开关1、2、3
         * <p>
         * <p>
         * 灯关
         * ①开关1、开关2
         * ②开关1、开关3
         * ③开关2、开关3
         * 不操作
         * <p>
         */
        int dfs(TreeNode node, boolean switch2_odd, boolean switch3) {

            if (node == null) return 0;


            int x = switch2_odd ? 1 : 0;
            int y = switch3 ? 1 : 0;

            int[][] temp = map.getOrDefault(node, new int[2][2]);

            if (temp[x][y] > 0) return temp[x][y];

            int res = 100005;

            //灯是打开的，并且开关2和开关3抵消掉，因此灯是开的
            //灯是关闭的，并且开关2和开关3没有抵消掉，因此灯是开的
            if ((node.val == 1) == (switch2_odd == switch3)) {
                //开启一个开关 或者 开启三个开关
                int res1 = dfs(node.left, switch2_odd, false) + dfs(node.right, switch2_odd, false) + 1;
                int res2 = dfs(node.left, !switch2_odd, false) + dfs(node.right, !switch2_odd, false) + 1;
                int res3 = dfs(node.left, switch2_odd, true) + dfs(node.right, switch2_odd, true) + 1;
                int res123 = dfs(node.left, !switch2_odd, true) + dfs(node.right, !switch2_odd, true) + 3;

                //最终的答案等于其中的最小值
                res = Math.min(res1, Math.min(res2, Math.min(res3, res123)));
            } else {
                //灯是 关闭 的
                //开启0个开关 或者 开启两个开关
                int res0 = dfs(node.left, switch2_odd, false) + dfs(node.right, switch2_odd, false);
                int res12 = dfs(node.left, !switch2_odd, false) + dfs(node.right, !switch2_odd, false) + 2;
                int res13 = dfs(node.left, switch2_odd, true) + dfs(node.right, switch2_odd, true) + 2;
                int res23 = dfs(node.left, !switch2_odd, true) + dfs(node.right, !switch2_odd, true) + 2;


                res = Math.min(res0, Math.min(res12, Math.min(res13, res23)));
            }

            temp[x][y] = res;

            map.put(node, temp);

            return res;
        }

    }

}
