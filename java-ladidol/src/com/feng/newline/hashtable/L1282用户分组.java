package com.feng.newline.hashtable;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1282用户分组
 * @author: Ladidol
 * @description: 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。
 * 例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 * 每个人应该 恰好只 出现在 一个组 中，
 * 并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。可以保证给定输入至少有一个有效的解。
 * 示例 1：
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 第一组是 [5]，大小为 1，groupSizes[5] = 1。
 * 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
 * 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 示例 2：
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 * @date: 2022/8/12 12:35
 * @version: 1.0
 */
public class L1282用户分组 {

    class Solution1 {//用哈希的时候，答案和标答大相径庭的时候考虑一下是不是k-v意义理解错了。
        //可以使用list数组
        //这里先用map来做一下。
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            for (int i = 0; i < groupSizes.length; i++) {
                int sizeKey = groupSizes[i];//key
                if (!map.containsKey(sizeKey)) {
                    map.put(sizeKey, new LinkedList<>());
                }
                map.get(sizeKey).add(i);
                if (map.get(sizeKey).size() == sizeKey) {
                    res.add(new LinkedList<>(map.get(sizeKey)));//截取出来。
                    map.put(sizeKey, new LinkedList<>());//重置value。
                }
            }
            return res;
        }
    }

    //用list数组来模拟
    class Solution {//用哈希的时候，答案和标答大相径庭的时候考虑一下是不是k-v意义理解错了。

        LinkedList[] map = new LinkedList[500];
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            for (int i = 0; i < groupSizes.length; i++) {
                int sizeKey = groupSizes[i];//key
                if (map[sizeKey] == null) {
                    map[sizeKey] = new LinkedList<>();
                }
                map[sizeKey].add(i);
                if (map[sizeKey].size() == sizeKey) {
                    res.add(new ArrayList<>(map[sizeKey]));
                    map[sizeKey].clear();
                }
            }
            return res;
        }
    }

}
