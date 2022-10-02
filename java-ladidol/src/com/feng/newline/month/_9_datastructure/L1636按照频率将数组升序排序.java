package com.feng.newline.month._9_datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1636按照频率将数组升序排序
 * @author: Ladidol
 * @description: 给你一个整数数组nums，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * @date: 2022/9/19 23:11 每日一题
 * @version: 1.0
 */
public class L1636按照频率将数组升序排序 {


    class Solution {
        // 先对每一个数字进行频率计数；
        // 按照频率从小到大，再按照数值的从大到小
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            //进行排序(链表的关系：先加入数据然后再排序)
            List<int[]> list = new ArrayList<>();

            for (int key : map.keySet()) {
                list.add(new int[]{key, map.get(key)});
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[1] == b[1]) return b[0] - a[0];//数值降序。
                    return a[1] - b[1];//频率升序。
                }
            });

            int[] res = new int[nums.length];
            int index = 0;
            //每种元素顺序已经排好了！开始构造答案咯。
            for (int[] ints : list) {
                while (ints[1] > 0) {
                    res[index] = ints[0];
                    index++;
                    ints[1]--;
                }
            }
            return res;
        }
    }
}

