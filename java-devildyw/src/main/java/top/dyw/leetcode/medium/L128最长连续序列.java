package top.dyw.leetcode.medium;

import java.util.HashSet;

public class L128最长连续序列 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for(int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        // 遍历set 防止因为太多重复元素而超时 重复元素并不影响最终结果
        for(int num : set) {
            if (set.contains(num-1)) {
                // 不是起点
                continue;
            }
            int temp = num;
            int count = 0;
            while(set.contains(temp)) {
                count++;
                temp++;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
