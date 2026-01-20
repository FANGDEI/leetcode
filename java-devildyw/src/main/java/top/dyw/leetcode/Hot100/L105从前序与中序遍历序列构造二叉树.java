package top.dyw.leetcode.Hot100;

public class L105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }

        int rootVal = preorder[pLeft];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i = iLeft; i<=iRight; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        root.left = buildTreeHelper(preorder, pLeft + 1, pLeft + index - iLeft, inorder, iLeft, index-1);
        root.right = buildTreeHelper(preorder, pLeft + index - iLeft + 1, pRight, inorder, index+1, iRight);
        return root;
    }
}
