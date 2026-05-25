package top.dyw.leetcode.Hot100;

import java.util.*;

public class L128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            if (set.contains(num-1)) {
                continue;
            }

            int count = 0;
            int temp = num;
            while (set.contains(temp)) {
                count++;
                temp++;
            }

            maxLen = Math.max(count, maxLen);
        }

        return maxLen;
    }
}
