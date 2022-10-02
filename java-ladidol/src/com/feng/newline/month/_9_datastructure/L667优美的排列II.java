package com.feng.newline.month._9_datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L667优美的排列II
 * @author: Ladidol
 * @description: 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * 示例 2：
 * <p>
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * <p>
 * 提示：
 * <p>
 * 1 <= k < n <= 104
 * @date: 2022/9/8 13:54
 * @version: 1.0
 */
public class L667优美的排列II {
    // 脑经急转弯
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            int p = 1, q = n;
            for (int i = 0; i < k; i++) {// 先排出k-1种间隔
                if ((i & 1) == 0) {
                    res[i] = p++;
                } else {
                    res[i] = q--;
                }
            }
            if ((k & 1) == 0) {// 偶数是降序
                for (int i = k; i < n; i++) {
                    res[i] = res[i - 1] - 1;//注意自加会改变数组原来的值。
                }
            } else {
                for (int i = k; i < n; i++) {
                    res[i] = res[i - 1] + 1;
                }
            }
            return res;
        }
    }
}
