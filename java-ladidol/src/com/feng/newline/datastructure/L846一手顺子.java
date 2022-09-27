package com.feng.newline.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L846一手顺子
 * @author: Ladidol
 * @description: Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。
 * 如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * @date: 2022/9/1 13:15
 * @version: 1.0
 */
public class L846一手顺子 {
    class Solution1 {
        //先哈希表计数，再优先队列排序输出，最后从最小的开始一个一个取出顺子
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Map<Integer, Integer> map = new HashMap<>();//哈希表
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);//优先级队列
            for (int i : hand) {//哈希表和队列初始化
                map.put(i, map.getOrDefault(i, 0) + 1);
                queue.add(i);//添加进去的话不会去重。
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (map.get(cur) == 0) continue;//没有，或者包含在前面的顺子中就不管。
                for (int i = 0; i < groupSize; i++) {
                    int cnt = map.getOrDefault(cur + i, 0);
                    if (cnt == 0) return false;
                    map.put(cur + i, cnt - 1);//减一更新。
                }
            }
            return true;
        }
    }

    // 2022年9月27日14:31:50再做这题
    class Solution {
        // 有点忘记了，看了一下提示：需要map和queue来协作。map计数优先级队列来顺序取出。
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.sort(hand);
            for (int i = 0; i < hand.length; i++) {
                map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            }
            for (int i = 0; i < hand.length; i++) {
                int cur = hand[i];
                if (map.get(cur) == 0) continue;//包含于前面的对子中。
                for (int j = 0; j < groupSize; j++) {
                    int count = map.getOrDefault(cur + j, 0);
                    if (count == 0) return false;//不够减了。
                    map.put(cur + j, count - 1);
                }
            }
            return true;
        }
    }
}
