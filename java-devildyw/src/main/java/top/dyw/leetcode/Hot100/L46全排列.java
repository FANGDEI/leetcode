package top.dyw.leetcode.Hot100;

public class L46全排列 {
    List<List<Integer>> rseult = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        dfs(nums, set);
        return rseult;
    }

    public void dfs(int[] nums, Set<Integer> set) {
        if (path.size() == nums.length) {
            rseult.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i<nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, set);
            path.remove(path.size()-1);
            set.remove(nums[i]);
        }
    }
}
