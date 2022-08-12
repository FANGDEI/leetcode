package com.feng.leetcode.week;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.doubleweek
 * @className: D84
 * @author: Ladidol
 * @description:
 * @date: 2022/8/6 22:49
 * @version: 1.0
 */
public class D84 {


    class Solution合并相似的物品 {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            TreeMap<Integer, Integer> res = new TreeMap<>();
            for (int i = 0; i < items1.length; i++) {
                res.put(items1[i][0], res.getOrDefault(items1[i][0], 0) + items1[i][1]);
            }
            for (int i = 0; i < items2.length; i++) {
                res.put(items2[i][0], res.getOrDefault(items2[i][0], 0) + items2[i][1]);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(entry.getKey());
                tmp.add(entry.getValue());
                ans.add(tmp);
            }
            return ans;
        }
    }

    class 统计坏数对的数目1 {
        //什么垃圾暴力O（n2），已经超时嘞
        public long countBadPairs(int[] nums) {
            long count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j - i != nums[j] - nums[i]) count++;
                }
            }
            return count;
        }
    }

    class 统计坏数对的数目2 {
        //优化一下时间复杂度。O（n）
        //这里移动一下等式两边，的到i - nums[i]，只需要维护一个map<int,int>来装以存在的数字个数，用整体减去前面重复数字计算多过得次数。
        //把等式两边移项，变为 nums[i] - i == nums[j] = j。因此我们只需要维护一个map<int, int> map，map[x] 表示目前为止满足 nums[i] - i == x 的 i 有几个。我们枚举 j，并从答案中减去 map[nums[j] - j] 的值即可
        public long countBadPairs(int[] nums) {
            int n = nums.length;
            long res = (long) n * (n - 1) / 2;//这种累加直接带等差公式
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int temp = i - nums[i];
                res -= map.getOrDefault(temp, 0);//减去之前重复计算的，因为重复次数不止一次，所以用map来计算出现过的次数
                map.put(temp, map.getOrDefault(temp, 0) + 1);//维护map
            }
            return res;
        }
    }
}
