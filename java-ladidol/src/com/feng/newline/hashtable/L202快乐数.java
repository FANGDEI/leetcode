package com.feng.newline.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L202快乐数
 * @author: Ladidol
 * @description: 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 提示：
 * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
 * @date: 2022/7/18 14:01
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