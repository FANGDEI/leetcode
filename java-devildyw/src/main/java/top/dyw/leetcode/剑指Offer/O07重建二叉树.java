package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-02-28-11:52
 */
@SuppressWarnings("all")
public class O07重建二叉树 {

    public static void main(String[] args) {

        System.out.println(new O07重建二叉树().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHepler(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHepler(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend) {
        if (pbegin > pend) {
            return null;
        }
        int rootVal = preorder[pbegin];
        //创建头结点
        TreeNode root = new TreeNode(rootVal);

        int midIndex = 0;
        //找到在中序遍历中的头结点的位置
        for (int i = ibegin; i <= iend; i++) {
            if (inorder[i] == rootVal) {
                midIndex = i;
                break;
            }
        }

        int leftVal = midIndex - ibegin;
        root.left = buildTreeHepler(preorder, pbegin + 1, pbegin + leftVal, inorder, ibegin, midIndex - 1);
        root.right = buildTreeHepler(preorder, pbegin + leftVal + 1, pend, inorder, midIndex + 1, iend);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


