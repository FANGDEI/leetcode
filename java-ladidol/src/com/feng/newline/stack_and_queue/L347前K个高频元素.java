package com.feng.newline.stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L347前K个高频元素
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * @date: 2022/7/28 15:46
 * @version: 1.0
 */
public class L347前K个高频元素 {


    //优先级队列.

    //首先统计元素出现的频率，这一类的问题可以使用map来进行统计。
    //然后是对频率进行排序，这里我们可以使用一种 容器适配器就是优先级队列。
    //什么是优先级队列呢？
    //其实就是一个披着队列外衣的堆，因为优先级队列对外接口只是从队头取元素，从队尾添加元素，再无其他取元素的方式，看起来就是一个队列。


    //好巧不巧java就自带有优先级队列PriorityQueue
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //设定优先规则.根据map的value值，构建于一个大顶堆（o1 - o2: 小顶堆， o2 - o1 : 大顶堆）
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(entry);//初始化优先级队列.
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }
}
