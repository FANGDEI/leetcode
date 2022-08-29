package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L655输出二叉树
 * @author: Ladidol
 * @description: 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2^(height-r-1)] ，右子节点放置在 res[r+1][c+2^(height-r-1)] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * @date: 2022/8/25 23:16
 * @version: 1.0 每日一题，这个好神奇啊。二分法。
 */
public class L655输出二叉树 {
    class Solution {
        String[][] res;//因为有 空和数字，这里用String类型比较合适。
        List<List<String>> list = new ArrayList<>();

        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            res = new String[height][(1 << height) - 1];
            for (String[] re : res) {
                Arrays.fill(re, "");//初始化String数组。
            }
            fillInto(root, 0, 0, res[0].length);
            for (String[] re : res) {
                list.add(Arrays.asList(re));
            }
            return list;
        }


        void fillInto(TreeNode root, int i, int leftIndex, int rightIndex) {
            if (root == null) return;

            //处理当前节点。
            res[i][(leftIndex + rightIndex) >> 1] = "" + root.val;
            fillInto(root.left, i + 1, leftIndex, (leftIndex + rightIndex) / 2);//这里后多或少有点没看懂。应该就是二分法。
            fillInto(root.right, i + 1, (leftIndex + rightIndex + 1) / 2, rightIndex);
        }


        //dfs得到高度
        int getHeight(TreeNode root, int height) {//这里可以把height隐藏的
            if (root == null) return height;
            return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
        }

        /**
         * dfs获取树的高度
         * 这里面的高度和题中高度不一致，这里是指有多少层，比较好理解。
         *
         * @param root
         * @return
         */
        int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }

    }
}
