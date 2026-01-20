package top.dyw.leetcode.Hot100;

public class L437路径总和III {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0L, 1);

        return backTracking(root, 0L, targetSum, prefixSumMap);
    }

    public int backTracking(TreeNode root, long curSum, int targetSum, Map<Long,Integer> prefixSumMap) {
        if (root == null) {
            return 0;
        }

        curSum += root.val;

        int res = prefixSumMap.getOrDefault(curSum-targetSum, 0);

        prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        res += backTracking(root.left, curSum, targetSum, prefixSumMap);
        res += backTracking(root.right, curSum, targetSum, prefixSumMap);

        // 回溯
        prefixSumMap.put(curSum, prefixSumMap.get(curSum)-1);
        return res;
    }
}
