package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L968监控二叉树
 * @author: Ladidol
 * @description: 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * @date: 2022/8/15 21:27
 * @version: 1.0
 */
public class L968监控二叉树 {
    //在某个节点上安装，保证其父代和子代都被监控。
    //摄像头可以覆盖上中下三层
    //因为头结点放不放摄像头也就省下一个摄像头， 叶子节点放不放摄像头省下了的摄像头数量是指数阶别的。所以咱们从底层遍历
    class Solution {

        int res = 0;

        public int minCameraCover(TreeNode root) {
            if (root == null) return 0;
            if (checkStatus(root) == 0){//检查当前节点的状态，如果没被覆盖就直接寄。
                return res + 1;
            }
            //其他两种情况就直接不需要安装。
            return res;
        }


        /**
         * 节点的状态值：
         * 0 表示无覆盖
         * 1 表示 有摄像头
         * 2 表示有覆盖
         * 后序遍历，根据左右节点的情况,来判读 自己的状态
         */
        //后序遍历，左右中
        public int checkStatus(TreeNode root) {//检查当前节点的状态。

            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            if (root == null) {
                return 2;
            }

            int left = checkStatus(root.left);
            int right = checkStatus(root.right);

            // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,也不需要摄像头
            // 状态 ——0
            if (left == 2 && right == 2) {
                return 0;
            }

            // 左右节点只要有一个无覆盖状态,那根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 ——1 摄像头数 ++;
            else if (left == 0 || right == 0) {
                res++;
                return 1;
            }


            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态 ——2
            else {
                return 2;
            }
        }
    }
}
