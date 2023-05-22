package com.feng.leetcode.week;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/14 10:57
 * @description: {}
 */
public class W345 {

    public static void main(String[] args) {
//        new Solution().circularGameLosers(2, 1);
    }


    //第一题
    class Solution1 {
        /**
         * @param n
         * @param k
         * @return
         */
        public int[] circularGameLosers(int n, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int key = 0;
            for (int i = 0; i < n; i++) {
                key = (key + (i + 1) * k) % n;//这里用i-1来表示，取余的时候方便表示，不然n%n就0了。
                int orDefault = map.getOrDefault(key, 0);
                if (orDefault == 1) break;
                map.put(key, orDefault + 1);
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (map.getOrDefault(i, 0) == 0) {
                    res.add(i + 1);
                }
            }
            int[] result = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;

        }
    }

    //第二题，类似于以前数学的左右式子分别合并。
    class Solution2 {

        /**
         * derived[0] = original[n-1] ⊕ original[0]
         * derived[1] = original[0] ⊕ original[1]
         * derived[2] = original[1] ⊕ original[2]
         * ...
         * derived[n-1] = original[n-2] ⊕ original[n-1]
         * 如果我们将所有的派生数组元素进行异或运算，即
         * xor = derived[0] ⊕ derived[1] ⊕ ... ⊕ derived[n-1]
         * 那么，根据异或运算的性质，如果所有的派生数组元素能够构成一个有效的原始二进制数组，那么它们的异或结果应该为0。
         * @param derived
         * @return
         */
        public boolean doesValidArrayExist(int[] derived) {
            int xor = 1;//将xor初始化为1，更好判断 xor = derived[0] ⊕ derived[1] ⊕ ... ⊕ derived[n-1]
            for (int i : derived) {
                xor ^= i;
            }
            return xor == 1;//只需要判断，经过一番折腾后，xor是不是还是等于原来的值
        }
    }


}
