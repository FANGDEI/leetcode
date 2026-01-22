package top.dyw.leetcode.Hot100;

public class L39组合总和 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, List<Integer> path, int curSum, int index) {
        if (curSum == target) {
            result.add(new ArrayList(path));
            return;
        }
        if (curSum>target) {
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target, path, curSum+candidates[i], i);
            path.remove(path.size()-1);
        }
    }
}
