package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/10/2 13:06
 * @description: 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，
 * 当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 示例 :
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 提示：
 * <p>
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 */
public class L777在LR字符串中交换相邻字符 {


    class Solution {
        /**
         * 参数：[start, end]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：
         * 序号相同的 L : start 的下标不小于 end 的下标（即 L 不能往右移动）
         * 序号相同的 R : start 的下标不大于 end 的下标（即 R 不能往左移动）
         * 序号相同：start中第1个L，与end中第1个L，都是第一个，表示序号相同
         * 主要是对字母LR的判定。
         */
        public boolean canTransform(String start, String end) {
            int i = 0, j = 0;
            int n = start.length();
            while (true) {
                // 先寻找一下L和R的坐标i和j，需要满足一下L和R的关系。
                while (i < n && start.charAt(i) == 'X') {
                    i++;
                }
                while (j < n && end.charAt(j) == 'X') {
                    j++;
                }
                if (i == n || j == n) return i == j;//只要出现其中一个没有遍历完到n，return false；
                if (start.charAt(i) != end.charAt(j)) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
                if (start.charAt(i) == 'L' && i < j) return false;
                i++;
                j++;
            }
        }
    }
}