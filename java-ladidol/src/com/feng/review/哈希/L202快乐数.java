package com.feng.review.哈希;

import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L202快乐数
 * @author: Ladidol
 * @description:
 * 提示：
 * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
 * @date: 2022/7/18 14:01 2023年2月28日23:54:01
 * @version: 1.0
 */
public class L202快乐数 {


//    public static void main(String[] args) {
//        System.out.println(new Solution().isHappy(19));
//    }

    class Solution {
        public boolean isHappy(int n) {
//            boolean[] hashTable = new boolean[Integer.MAX_VALUE];//不能使用int数组了,会超出内存范围.
            Set<Integer> hashTable = new HashSet<>();
            while (n != 1 && !hashTable.contains(n)) {
                hashTable.add(n);
                n = getNext(n);
            }
            return n == 1;//判断是不是等于1;
        }

        public int getNext(int n) {
            int res = 0;
            while (n > 0) {
                int temp = n % 10;
                n = n / 10;
                res += temp * temp;
            }
            return res;
        }
    }
}