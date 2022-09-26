package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1652拆炸弹
 * @author: Ladidol
 * @description: 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * <p>
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * 示例 1：
 * <p>
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * 示例 2：
 * <p>
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 * 示例 3：
 * <p>
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 * @date: 2022/9/24 19:09
 * @version: 1.0
 */
public class L1652拆炸弹 {

    //前缀和：
    // 第一眼看过去就是前缀和咯，但是是循环数组，统一解决方法就是用两个数组拼接起来就行了。
    class Solution {
        // 从0开始计数我们试试。
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] preSum = new int[n * 2];
            preSum[0] = code[0];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + code[(i - 1) % n];
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                if (k >= 0) res[i] = preSum[i + k + 1] - preSum[i + 1];
                else res[i] = preSum[i + n] - preSum[i + n + k];//这里k是负数直接加
            }
            return res;
        }
    }

    //可能有些大佬会这样：前缀和：
    // 第一眼看过去就是前缀和咯，但是是循环数组，统一解决方法就是用两个数组拼接起来就行了。
    class Solution1 {
        // 前缀和一般都是会preSum[0] = 0，从1开始计数。为了方便吧。
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] preSum = new int[n * 2 + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + code[(i - 1) % n];
            }

            int[] res = new int[n];
            for (int i = 1; i <= n; i++) {
                if (k >= 0) res[i - 1] = preSum[i + k] - preSum[i];
                else res[i - 1] = preSum[i + n - 1] - preSum[i + n + k - 1];//这里k是负数直接加
            }
            return res;
        }
    }


}
