package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L998最大二叉树II
 * @author: Ladidol
 * @description: 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * 给你最大树的根节点 root 和一个整数 val 。
 * 就像 之前的问题 那样，给定的树是利用 Construct(a)例程从列表a（root = Construct(a)）递归地构建的：
 * 如果 a 为空，返回null 。
 * 否则，令a[i] 作为 a 的最大元素。创建一个值为a[i]的根节点 root 。
 * root的左子树将被构建为Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root的右子树将被构建为Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b) 。
 * <p>
 * 示例 1：
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 * @date: 2022/8/30 17:23
 * @version: 1.0
 */
public class L998最大二叉树II {


    // 本办法，就是根据654最大二叉树，解法来。
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            List<Integer> list = new ArrayList<>();
            // 中序遍历，得到a数组，然后再a后面加上val
            inorder(root, list);
            list.add(val);
            // 再通过数组转化成最大二叉树
            root = traversal(list, 0, list.size());
            return root;
        }

        void inorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            inorder(root.left, res);//前
            res.add(root.val);//中
            inorder(root.right, res);//后
        }

        //左闭右开
        TreeNode traversal(List<Integer> list, int left, int right) {
            if (left >= right) return null;//终止条件。

            //第一步：先找分割点下标：maxIndex。
            int maxIndex = left;
            for (int i = left + 1; i < right; i++) {
                if (list.get(i) > list.get(maxIndex)) maxIndex = i;//寻找最大值下标；
            }
            //第二步：构建根节点，和它的子节点。
            TreeNode root = new TreeNode(list.get(maxIndex));//根节点
            // 左闭右开：
            root.left = traversal(list, left, maxIndex);
            root.right = traversal(list, maxIndex + 1, right);//注意去掉最大值。

            return root;
        }
    }

    // 这题的理解，从右子树上面找到小于val的cur节点，插入节点的左节点为cur节点
    class Solution1 {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val < val) {
                TreeNode newNode = new TreeNode(val, root, null);
                return newNode;
            }
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
