package com.feng.leetcode.hot100._01哈希;

import java.util.HashSet;
import java.util.Set;

public class h128最长连续序列 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<>();
            for (int num : nums) {
                num_set.add(num);
            }
            int ans = 0;
            for (Integer num : num_set) {
                //巧妙的剪枝
                if (!num_set.contains(num - 1)) {
                    int curNum = num;
                    int curLength = 1;
                    while (num_set.contains(curNum + 1)) {
                        curNum++;
                        curLength++;
                    }
                    ans = Math.max(curLength, ans);
                }

            }
            return ans;
        }
    }


}
