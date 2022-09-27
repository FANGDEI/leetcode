package com.feng.leetcode.LCCUP;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.LCCUP
 * @className: 第七题舒适的湿度
 * @author: Ladidol
 * @description:
 * @date: 2022/9/24 16:04
 * @version: 1.0
 */
public class _5第五题舒适的湿度 {
//    class Solution {
//        public int unSuitability(int[] operate) {
//            var mx = Arrays.stream(operate).max().orElseThrow() * 2 + 1;
//            int[] pre = new int[mx], f = new int[mx];
//            Arrays.fill(pre, Integer.MAX_VALUE);
//            pre[0] = 0;
//            for (var x : operate) {
//                Arrays.fill(f, Integer.MAX_VALUE);
//                for (var j = 0; j < mx; ++j) {
//                    var dis = pre[j];
//                    if (dis == Integer.MAX_VALUE) continue; // 无效的长度（无法组成）
//                    if (j + x < mx) f[j + x] = Math.min(f[j + x], Math.max(dis, j + x));
//                    if (j >= x) f[j - x] = Math.min(f[j - x], dis);
//                    else f[0] = Math.min(f[0], dis - j + x);
//                }
//                var tmp = pre;
//                pre = f;
//                f = tmp;
//            }
//            return Arrays.stream(pre).min().orElseThrow();
//        }
//    }

}
