package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L670最大交换
 * @author: Ladidol
 * @description: 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是[0, 108]
 * @date: 2022/9/13 22:19
 * @version: 1.0
 */
public class L670最大交换 {

    // 直接一个一个判断可不可以翻转。
    class Solution {
        public int maximumSwap(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int curMaxIndex = i;
                for (int j = i + 1; j < chars.length; j++) {
//                    if (chars[curMaxIndex] < chars[j]) {//这里有个小技巧这里必须天<=,一道最后面一个maxIndex。
                    if (chars[curMaxIndex] <= chars[j]) {
                        curMaxIndex = j;
                    }
                }
//                if (curMaxIndex > i) {//随之这里也要加一个大于条件判断。
                if (curMaxIndex > i && chars[curMaxIndex] > chars[i]) {
                    char tmp = chars[i];
                    chars[i] = chars[curMaxIndex];
                    chars[curMaxIndex] = tmp;
                    break;
                }
            }
            return Integer.parseInt(new String(chars));
        }
    }

}
