package top.dyw.leetcode.Hot100;

import java.util.HashMap;
// 并不是每道题都能用滑动窗口
public class L560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();

        map.put(0,1);

        // preSum[i] - preSum[j] = k
        // preSum[i] - k = preSum[j]
        // 这就代表有 j 到 i 这个子数组的和=k
        for(int i = 0; i<nums.length; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum-k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
