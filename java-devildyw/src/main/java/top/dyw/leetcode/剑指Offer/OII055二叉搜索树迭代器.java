package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/31 12:32
 **/
@SuppressWarnings("all")
public class OII055二叉搜索树迭代器 {

    public static void main(String[] args) {

    }

//    class BSTIterator {
//        private TreeNode cur = null;
//        private Deque<TreeNode> stack;
//
//        /**
//         * 使用栈模拟递归遍历树的场景
//         * @param root
//         */
//        public BSTIterator(TreeNode root) {
//            this.cur = root;
//            stack = new ArrayDeque<>();
//        }
//
//        /**
//         * 如果cur不为null 则取其最左边的节点放入 中序遍历左中右
//         * 随着cur指针的走向会将其要遍历的节点按照右根左的顺序放入栈中
//         * @return
//         */
//        public int next() {
//            while (cur!=null){ //左 如果当前cur不为null则放入栈中去维护一个满足中序遍历顺序的栈序列
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop(); //中
//            int ret = cur.val;
//            cur = cur.right; //右
//            return ret;
//        }
//
//        public boolean hasNext() {
//            return cur!=null || !stack.isEmpty();
//        }
//    }

    class BSTIterator {

        TreeNode root;
        Deque<TreeNode> stack; //栈模拟递归 模拟中序遍历二叉搜索树

        public BSTIterator(TreeNode root) {
            this.root = root;
            stack = new ArrayDeque<>();
        }

        public int next() {
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int res = root.val;
            root = root.right;
            return res;
        }

        public boolean hasNext() {
            return root!=null||!stack.isEmpty();
        }
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
