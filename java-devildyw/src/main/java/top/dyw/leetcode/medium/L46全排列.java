package top.dyw.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class L46全排列 {

    List<List<Integer>> result = new ArrayList();
    List<Integer> path = new ArrayList();
    boolean[] set;
    public List<List<Integer>> permute(int[] nums) {
        set = new boolean[nums.length];
        dfs(nums);

        return result;
    }

    public void dfs(int[]nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for( int i = 0; i<nums.length; i++) {
            if (set[i]) {
                continue;
            }
            set[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size()-1);
            set[i] = false;
        }
    }

}
