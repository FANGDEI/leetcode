import java.util.*;
public class L78子集 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            process(nums, ans, res, 0);
            return ans;
        }

        public void process(int[] nums, List<List<Integer>> ans, List<Integer> res, int i) {
            List<Integer> res2 = Arrays.asList(new Integer[res.size()]);
            Collections.copy(res2, res);
            ans.add(res2);
            for (int l = i; l < nums.length; l++) {
                res.add(nums[l]);
                process(nums, ans, res, l + 1);
                res.remove(new Integer(nums[l]));
            }
        }
    }
}
