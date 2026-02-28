package top.dyw.leetcode.Hot100;

public class L105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight){
        if (pLeft > pRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pLeft]);

        int index = iLeft;
        while (index<=iRight) {
            if (inorder[index] == root.val) {
                break;
            }
            index++;
        }
        int leftSize = index - iLeft;
        root.left = buildTreeHelper(preorder, pLeft+1, pLeft+leftSize, inorder, iLeft, index-1);
        root.right = buildTreeHelper(preorder, pLeft+leftSize+1, pRight, inorder, index+1, iRight);

        return root;
    }
}
