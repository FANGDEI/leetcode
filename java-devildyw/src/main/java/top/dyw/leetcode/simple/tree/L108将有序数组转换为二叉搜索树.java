package top.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-08-10-9:08
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
@SuppressWarnings("all")
public class L108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {

    }

    /**
     * 递归 二叉搜索树的中序遍历是升序的，因此本题等同于根据中序遍历恢复二叉搜索树
     * 因为要求高度平衡，因此选择升序序列的中间元素作为根节点 递归每次取中间节点就能保证左右节点平衡
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        //以升序数组的中间节点作为根节点root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建root的右子树和左子树
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }

    private TreeNode dfs01(int[] nums, int lo, int hi) {
        //判断终止条件
        if (lo > hi) {
            return null;
        }

        //找出中点
        int mid = lo + (hi - lo) / 2;
        //获取中间节点的值构建树节点
        TreeNode root = new TreeNode(nums[mid]);

        //为了平衡我们取得是中点 由此将树分为了两个部分 左右部分 分别代表了 左子树和右子树 根据这个规律去递归构建
        root.left = dfs01(nums, lo, mid - 1);
        root.right = dfs01(nums, mid + 1, hi);

        //返回根节点
        return root;
    }


    /**
     * 想构成平衡二叉搜索树 又因为题目已经给出了一个有序的数组 我们只需要从数组的中间开始建立根节点就必定是平衡的
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST01(int[] nums) {
        if (nums.length==0){
            return null;
        }
        TreeNode root = traversal(nums,0,nums.length-1);
        return root;
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = traversal(nums,left,mid-1);
        root.right = traversal(nums,mid+1,right);
        return root;
    }
}
