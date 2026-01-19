package top.dyw.leetcode.Hot100;

public class L108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 中间的中间 反复重复这个过程
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right || right < left) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid-1);
        root.right = sortedArrayToBSTHelper(nums, mid+1, right);
        return root;
    }
}
