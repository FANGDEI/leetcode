package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L98验证二叉搜索树
 * @author: Ladidol
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @date: 2022/8/3 18:50
 * @version: 1.0
 */
public class L98验证二叉搜索树 {
    //要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
    //有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了。

    //方法一：通过判断中序遍历数组是不是递增就行。
    class Solution2 {

        List<Integer> inorder;

        public boolean isValidBST(TreeNode root) {
            inorder = new ArrayList<>();
            inorderTraversal(root);
            for (int i = 1; i < inorder.size(); i++) {
                if (inorder.get(i) <= inorder.get(i - 1)) return false;
            }
            return true;
        }

        void inorderTraversal(TreeNode root) {
            if (root == null) return;
            inorderTraversal(root.left);
            inorder.add(root.val);
            inorderTraversal(root.right);
        }
    }


    //方法二：纯纯的中序递归遍历，加了一个max节点来辅助
    class Solution1 {
        // 递归
        TreeNode max;//只要是向右遍历，max会根据root不断更新只会越来越小，只要是向右子树节点遍历max就停留到root上面，只会越来越大。

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 左
            boolean left = isValidBST(root.left);
            if (!left) {
                return false;
            }
            // 中
            if (max != null && root.val <= max.val) {
                return false;
            }
            max = root;
            // 右
            boolean right = isValidBST(root.right);
            return right;
        }
    }


    // 就是中序遍历
    class Solution {
        /**
         * 参数：[root]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：保证前一个节点一定小于当前节点。
         */
//        TreeNode pre = new TreeNode(Integer.MIN_VALUE);//前一个节点。
        long preValue = Long.MIN_VALUE;//为了避免[-2147483648]的测试用例。


        public boolean isValidBST(TreeNode root) {

            if (root == null) return true;
            //左
            boolean left = isValidBST(root.left);
            //中
            if (preValue >= root.val) return false;
            preValue = root.val;//维护pre节点。
            //右
            boolean right = isValidBST(root.right);
            return left && right;//left的比较可以放到前面判断，就可以少走一点路了。
        }
    }


}
