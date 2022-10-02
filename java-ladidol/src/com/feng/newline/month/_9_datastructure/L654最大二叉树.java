package com.feng.newline.month._9_datastructure;

import com.feng.newline.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L654最大二叉树
 * @author: Ladidol
 * @description: 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 * @date: 2022/8/3 17:59
 * @version: 1.0 每日一题
 */
public class L654最大二叉树 {


    class Solution1 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traversal(nums, 0, nums.length);
        }

        //左闭右开
        TreeNode traversal(int[] nums, int left, int right) {
            if (left >= right) return null;//终止条件。

            //第一步：先找分割点下标：maxIndex。
            int maxIndex = left;
            for (int i = left + 1; i < right; i++) {
                if (nums[i] > nums[maxIndex]) maxIndex = i;//寻找最大值下标；
            }
            //第二步：构建根节点，和它的子节点。
            TreeNode root = new TreeNode(nums[maxIndex]);//根节点
            // 左闭右开：
            root.left = traversal(nums, left, maxIndex);
            root.right = traversal(nums, maxIndex + 1, right);//注意去掉最大值。

            return root;
        }
    }


    class Solution2 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traversal(nums, 0, nums.length);
        }

        //左闭右开
        TreeNode traversal(int[] nums, int left, int right) {
            if (left + 1 == right) return new TreeNode(nums[left]);
            if (left == right) return null;
            int maxIndex = left;
            int max = nums[left];
            for (int i = left; i < right; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(nums[maxIndex], traversal(nums, left, maxIndex), traversal(nums, maxIndex + 1, right));
            return root;
        }
    }



    //2022年9月26日21:16:51：再做这一题
    // 这一次用单调栈来做。
    // 自己的第一感觉：就是用两个单调栈记录每一个元素的左边右边第一个小于它的元素。（理解题意失败！）
    // 然后我就迷茫了，
    //
    // 官解：这里可以类比一棵树的「深度优先搜索」和「广度优先搜索」，二者都可以起到遍历整棵树的效果。
    // 问题就转化为：
    // 在最终构造出的树上，以 nums[i] 为根节点的子树，在原数组中对应的区间，左边界为 nums[i] 左侧第一个比它大的元素所在的位置，右边界为 nums[i] 右侧第一个比它大的元素所在的位置。左右边界均为开边界。
    // 如果某一侧边界不存在，则那一侧边界为数组的边界。如果两侧边界均不存在，说明其为最大值，即根节点。
    // 找出每一个元素左侧和右侧第一个比它大的元素所在的位置。这就是一个经典的单调栈问题了，可以参考 503. 下一个更大元素 II。
    // 如果左侧的元素较小，那么该元素就是左侧元素的右子节点；如果右侧的元素较小，那么该元素就是右侧元素的左子节点。

    // 看不懂呜呜呜呜呜呜呜呜呜呜呜呜呜
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left, -1);
            Arrays.fill(right, -1);
            TreeNode[] tree = new TreeNode[n];
            for (int i = 0; i < n; ++i) {
                tree[i] = new TreeNode(nums[i]);
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    right[stack.pop()] = i;
                }
                if (!stack.isEmpty()) {
                    left[i] = stack.peek();
                }
                stack.push(i);
            }

            TreeNode root = null;
            for (int i = 0; i < n; ++i) {
                if (left[i] == -1 && right[i] == -1) {
                    root = tree[i];
                } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                    tree[left[i]].right = tree[i];
                } else {
                    tree[right[i]].left = tree[i];
                }
            }
            return root;
        }
    }







}
