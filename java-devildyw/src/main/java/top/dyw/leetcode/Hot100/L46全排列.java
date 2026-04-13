package top.dyw.leetcode.Hot100;

import java.util.*;

public class L46全排列 {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return result;
    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size()-1);
            set.remove(nums[i]);
        }
    }
}
