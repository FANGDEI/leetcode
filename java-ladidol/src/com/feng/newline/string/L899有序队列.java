package com.feng.newline.string;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L899有序队列
 * @author: Ladidol
 * @description: 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * 示例 1：
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>
 * s = "aaccbb", k = 2
 * 怎么操作呢？看了一下京城仔的题解，就是参考一下冒泡排序，k大于1就一定能最小序的样子。这里就是要把两个a分步骤移动到c的右边就行了
 * <p>
 * 当k = 1时，其实字符串是有序的，相当于一个字符串是一个环，我们可以从任意位置开始遍历整个环，求其最小的字典序
 * 当k > 1时，经过不断的变换，我们总能让序列有序，直接对字符串进行字典序排序即可
 * @date: 2022/8/3 15:10
 * @version: 1.0
 */
public class L899有序队列 {

    class Solution {
        public String orderlyQueue(String s, int k) {
            if (k == 1) {
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < s.length(); i++) {
                    //将第一个字母移动到最后一个。
                    sb.append(sb.charAt(0)).deleteCharAt(0);
                    if (sb.toString().compareTo(s)<0){
                        s = sb.toString();
                    }
                }
                return s;
            }else {
                //对一个String进行排序的基本操作。
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }
        }
    }
}
