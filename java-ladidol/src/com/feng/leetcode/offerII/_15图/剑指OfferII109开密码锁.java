package com.feng.leetcode.offerII._15图;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/25 21:46
 * @description: {}
 */
public class 剑指OfferII109开密码锁 {
    //bfs
    class Solution {
        /**
         * 和108这题很像，就是找全部下一步，然后有限制条件，有些路走不通而已。
         * 最短距离就用bfs了
         *
         * @param deadends
         * @param target
         * @return
         */
        public int openLock(String[] deadends, String target) {
            Set<String> set = Arrays.stream(deadends).collect(Collectors.toSet());
            Deque<String> queue = new ArrayDeque<>();
            queue.offer("0000");
            int count = 0;
            if (target.equals("0000")) return 0;
            if (set.contains("0000")) return -1;
            Set<String> visited = new HashSet<>();
            visited.add("0000");
            while (!queue.isEmpty()){
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    String cur = queue.poll();
                    if (cur.equals(target))return count;
                    List<String> adjacentWords = getAdjacentWords(cur);
                    for (String next : adjacentWords) {
                        if (visited.contains(next)||set.contains(next)){
                            continue;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                count++;
            }
            return -1;
        }


        //得到一个字母不相等的全部单词组合
        public List<String> getAdjacentWords(String word) {
            List<String> adjacentWords = new ArrayList<String>();
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {//每一个位置都可以替换
                char original = arr[i];
                if (original == '0') {
                    arr[i] = (char) (arr[i] + 1);
                    adjacentWords.add(new String(arr));
                    arr[i] = '9';
                    adjacentWords.add(new String(arr));
                    //要复原
                    arr[i] = '0';
                } else if (original == '9') {
                    arr[i] = (char) (arr[i] - 1);
                    adjacentWords.add(new String(arr));
                    arr[i] = '0';
                    adjacentWords.add(new String(arr));
                    //要复原
                    arr[i] = '9';
                } else {
                    arr[i] = (char) (arr[i] + 1);
                    adjacentWords.add(new String(arr));
                    arr[i] = (char) (arr[i] - 2);
                    adjacentWords.add(new String(arr));
                    //要复原
                    arr[i] = (char) (arr[i] + 1);
                }
            }
            return adjacentWords;
        }

    }
}
