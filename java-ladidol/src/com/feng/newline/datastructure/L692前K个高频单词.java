package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L692前K个高频单词
 * @author: Ladidol
 * @description: 给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * 示例 1：
 * <p>
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * 注意：
 * <p>
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i]由小写英文字母组成。
 * k 的取值范围是[1, 不同 words[i] 的数量]
 * @date: 2022/9/7 16:33
 * @version: 1.0
 */
public class L692前K个高频单词 {

    public static void main(String[] args) {
//        String[] str = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        System.out.println(new Solution().topKFrequent(str, 4));
    }

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();

            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
                if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();// 按词频的降序。
                return a.getKey().compareTo(b.getKey());// 按照字典序升序。
            });
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                queue.offer(entry);
            }
            List<String> res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < k && i < size; i++) {// 今天又遭到罪了，就是queue.poll的同时queue.size会随时改变的因数，导致k==4的时候只能去k/2个元素。
                res.add(queue.poll().getKey());
            }
            return res;
        }
    }
}


