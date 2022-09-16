package com.feng.newline.math;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.math
 * @className: L672灯泡开关Ⅱ
 * @author: Ladidol
 * @description: 房间中有 n只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 * 这 4 个开关各自都具有不同的功能，其中：
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 * 示例 1：
 * <p>
 * 输入：n = 1, presses = 1
 * 输出：2
 * 解释：状态可以是：
 * - 按压开关 1 ，[关]
 * - 按压开关 2 ，[开]
 * 示例 2：
 * <p>
 * 输入：n = 2, presses = 1
 * 输出：3
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关]
 * - 按压开关 2 ，[开, 关]
 * - 按压开关 3 ，[关, 开]
 * 示例 3：
 * <p>
 * 输入：n = 3, presses = 1
 * 输出：4
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关, 关]
 * - 按压开关 2 ，[关, 开, 关]
 * - 按压开关 3 ，[开, 开, 开]
 * - 按压开关 4 ，[关, 开, 开]
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= presses <= 1000
 * @date: 2022/9/15 22:40
 * @version: 1.0
 */
public class L672灯泡开关Ⅱ {// 这题多多少少是你先推理，然后再把结果放给计算机。

    class Solution {
        public int flipLights(int n, int presses) {
            //不按开关
            if (presses == 0) {
                return 1;
            }
            //特殊情况处理
            if (n == 1) {
                return 2;
            } else if (n == 2) {
                //特殊情况
                return presses == 1 ? 3 : 4;
            } else {
                //n >= 3
                return presses == 1 ? 4 : presses == 2 ? 7 : 8;
            }
        }

    }
}
