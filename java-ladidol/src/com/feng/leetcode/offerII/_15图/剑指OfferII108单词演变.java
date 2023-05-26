package com.feng.leetcode.offerII._15图;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/25 20:55
 * @description: {}
 */
public class 剑指OfferII108单词演变 {

    //bfs模板题
    class Solution {
        /**
         * 最短路径，用bfs来算，
         * https://leetcode.cn/problems/om3reC/solutions/1871296/by-stormsunshine-1ppz/
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @return
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) {
                return 0;
            }

            int count = 0;
            Deque<String> queue = new ArrayDeque<>();
            Set<String> map = new HashSet<>();
            queue.offer(beginWord);//一般第一层就是一个
            map.add(beginWord);//染色
            while (!queue.isEmpty()) {
                count++;
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    String poll = queue.poll();
                    if (poll.equals(endWord)){
                        return count;
                    }
                    List<String> nexts = getAdjacentWords(poll);
                    for (int j = 0; j < nexts.size(); j++) {
                        String cur = nexts.get(j);
                        if (set.contains(cur) && !map.contains(cur)) {
                            queue.offer(cur);
                            map.add(cur);
                        }
                    }
                }
            }
            return 0;
        }


        //得到一个字母不相等的全部单词组合
        public List<String> getAdjacentWords(String word) {
            List<String> adjacentWords = new ArrayList<String>();
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {//每一个位置都可以替换
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {//26个字母的可能性
                    if (c == original) {
                        continue;
                    }
                    arr[i] = c;
                    adjacentWords.add(new String(arr));
                }
                arr[i] = original;
            }
            return adjacentWords;
        }

    }
}
