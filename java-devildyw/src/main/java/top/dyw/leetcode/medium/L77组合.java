package top.dyw.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class L77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList();

        dfs(1,n, k, path, result);

        return result;

    }

    public void dfs(int index, int n, int k, List<Integer> path, List<List<Integer>> result) {
        // 剩下的长度不够 直接返回
        if (path.size() + (n-index + 1) < k) {
            return;
        }
        if (path.size() == k) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = index; i<=n; i++) {
            path.add(i);
            dfs(i+1, n, k, path, result);
            path.remove(path.size()-1);
        }
    }
}
