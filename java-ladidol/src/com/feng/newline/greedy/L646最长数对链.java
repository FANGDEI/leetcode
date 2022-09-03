package com.feng.newline.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L646最长数对链
 * @author: Ladidol
 * @description: 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * 提示：
 * <p>
 * 给出数对的个数在[1, 1000] 范围内。
 * @date: 2022/9/3 15:08 每日一题
 * @version: 1.0
 */
public class L646最长数对链 {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);// 已经按第二位升序排序

            int ans = 1;
            int pre = pairs[0][1];
            for (int i = 1; i < pairs.length; i++) {
                if (pre < pairs[i][0]) {
                    ans++;
                    pre = pairs[i][1];
                }
            }
            return ans;
        }
    }


    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int ans = 1;
        int pre = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (pre < pairs[i][0]) {
                ans++;
                pre = pairs[i][1];
            }
        }

        return ans;
    }
}
