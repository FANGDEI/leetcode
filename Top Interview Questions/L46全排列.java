import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class L46全排列 {

//    class Solution {
//        public List<List<Integer>> permute(int[] nums) {
//            List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//            List<Integer> output = new ArrayList<Integer>();
//            for (int num : nums) {
//                output.add(num);
//            }
//
//            int n = nums.length;
//            backtrack(n, output, res, 0);
//            return res;
//        }
//
//        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//            // 所有数都填完了
//            if (first == n) {
//                res.add(new ArrayList<Integer>(output));
//            }
//            for (int i = first; i < n; i++) {
//                // 动态维护数组
//                Collections.swap(output, first, i);
//                // 继续递归填下一个数
//                backtrack(n, output, res, first + 1);
//                // 撤销操作
//                Collections.swap(output, first, i);
//            }
//        }
//    }


    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            List<Integer> pro = new ArrayList<>();
            process(ans, set, pro, nums);
            return ans;
        }

        public void process(List<List<Integer>> ans, HashSet set, List<Integer> pro, int[] nums) {
            if (pro.size() == nums.length) {
                List<Integer> pro1 = Arrays.asList(new Integer[pro.size()]);
                ;
                Collections.copy(pro1, pro);
                ans.add(pro1);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    pro.add(nums[i]);
                    process(ans, set, pro, nums);
                    set.remove(i);
                    pro.remove(new Integer(nums[i]));
                }
            }
        }
    }
}
