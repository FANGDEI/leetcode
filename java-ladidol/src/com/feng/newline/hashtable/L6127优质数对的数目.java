package com.feng.newline.hashtable;

import java.util.HashSet;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L6127优质数对的数目
 * @author: Ladidol
 * @description: 给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。
 * 如果满足下述条件，则数对 (num1, num2) 是 优质数对 ：
 * num1 和 num2 都 在数组 nums 中存在。
 * num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按位 与 操作。
 * 返回 不同 优质数对的数目。
 * 如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。
 * 注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：5
 * 解释：有如下几个优质数对：
 * - (3, 3)：(3 AND 3) 和 (3 OR 3) 的二进制表示都等于 (11) 。值为 1 的位数和等于 2 + 2 = 4 ，大于等于 k = 3 。
 * - (2, 3) 和 (3, 2)： (2 AND 3) 的二进制表示等于 (10) ，(2 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等于 1 + 2 = 3 。
 * - (1, 3) 和 (3, 1)： (1 AND 3) 的二进制表示等于 (01) ，(1 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等于 1 + 2 = 3 。
 * 所以优质数对的数目是 5 。
 * <p>
 * 输入：nums = [5,1,1], k = 10
 * 输出：0
 * 解释：该数组中不存在优质数对。
 * @date: 2022/7/24 12:29
 * @version: 1.0
 */
public class L6127优质数对的数目 {
    //2022/7/24 303周赛t4看太明白这个解法, 只能说有点高深了.

    //通过瞪眼法不难发现, bitCount(i & j) + bitCount(i | j) >= k 等价于 bitCount(i) + bigCount(j) >= k;
    //优雅方法: 双百.
    class Solution {

        public long countExcellentPairs(int[] nums, int k) {
            HashSet<Integer> set = new HashSet<>();
            long map[] = new long[30], count = 0;//用到了另一种声明数组的方式.
            for (int num : nums) {
                //统计有相同"1"个数的数有多少个.
                map[Integer.bitCount(num)] += set.add(num) ? 1 : 0;
            }
            for (int i = 0; i < 30; i++) {
                for (int j = Math.max(0, k - i); j < 30; j++) {
                    count += map[i] * map[j];//瞪眼法看出.
                }
            }
            //这里通过统计出现次数, 然后再将他们进行遍历两层for循环后就可以得到排列组合总组数.
            return count;
        }
    }
}
