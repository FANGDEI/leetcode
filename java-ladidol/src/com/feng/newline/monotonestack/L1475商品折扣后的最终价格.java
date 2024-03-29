package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1475商品折扣后的最终价格
 * @author: Ladidol
 * @description: 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 * 示例 3：
 * <p>
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 * @date: 2022/9/1 13:49
 * @version: 1.0
 */
public class L1475商品折扣后的最终价格 {
    // 直接通过暴力遍历解法
    class Solution1 {
        public int[] finalPrices(int[] prices) {
            for (int i = 0; i < prices.length; i++) {
                int k = 0;
                for (int j = i + 1; j < prices.length && k == 0; j++) {
                    if (prices[i] >= prices[j]) k = prices[j];//遇到可以的情况就开始更新k
                }
                prices[i] -= k;
            }
            return prices;
        }
    }

    // 单调栈
    class Solution {
        // 用的是从栈头到栈底递减。（从上到下从大到小）
        public int[] finalPrices(int[] ps) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < ps.length; i++) {
                while (!stack.isEmpty() && ps[i] <= ps[stack.peek()]) {
                    ps[stack.peek()] = ps[stack.peek()] - ps[i];
                    stack.pop();
                }
                stack.push(i);
            }
            return ps;//直接用原数组封装答案
        }
    }

}
