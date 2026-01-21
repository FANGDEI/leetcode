package top.dyw.leetcode.Hot100;

public class L78子集 {
    List<List<Integer>> result = new ArrayList();
    List<Integer> path = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int start) {
        result.add(new ArrayList(path));

        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
