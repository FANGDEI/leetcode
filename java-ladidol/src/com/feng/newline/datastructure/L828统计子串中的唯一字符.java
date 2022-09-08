package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L828统计子串中的唯一字符
 * @author: Ladidol
 * @description: 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为32 位整数。
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 * 示例 1：
 * <p>
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 * 其中，每一个子串都由独特字符构成。
 * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * 示例 2：
 * <p>
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 * 示例 3：
 * <p>
 * 输入：s = "LEETCODE"
 * 输出：92
 * 提示：
 * @date: 2022/9/6 15:37
 * @version: 1.0
 */
public class L828统计子串中的唯一字符 {

    // 哈希表+乘法大法+巧妙的思维。
    // 乘法大法就是秒啊~
    // 这里注意last，cur，next；因为需要一次遍历就知道每一个字母的前中后位置更新变化情况。
    class Solution1 {
        public int uniqueLetterString(String s) {
            // 注意对每一个位置的赋值。
            Map<Character, Integer> lastIndexMap = new HashMap<>();
            Map<Character, Integer> curIndexMap = new HashMap<>();

            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (curIndexMap.containsKey(c)) {//依旧有当前值了（无论前面的last有没有值，这个-1的默认值就很妙）
                    ans += (curIndexMap.get(c) - lastIndexMap.getOrDefault(c, -1)) * (i - curIndexMap.get(c));
                }
                // 滚动存储lastIndex和curIndex
                lastIndexMap.put(c, curIndexMap.getOrDefault(c, -1));
                curIndexMap.put(c, i);

            }
            //计算最后next字符(每个字母出现的最后一个位置)的贡献值，最后虚拟next位置就是s.length()
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'A');
                if (curIndexMap.containsKey(c)) {
                    ans += (curIndexMap.get(c) - lastIndexMap.getOrDefault(c, -1)) * (s.length() - curIndexMap.get(c));
                }
            }

            return ans;
        }
    }


    // 哈希表+乘法大法+巧妙的思维。
    // 乘法大法就是秒啊~
    // 这里注意last，cur，next；因为需要一次遍历就知道每一个字母的前中后位置更新变化情况。
    class Solution {
        public int uniqueLetterString(String s) {
            // 注意对每一个位置的赋值。
            // 这里我们用数组来模拟最多只有26个的字母出现位置。
            int[] lastIndexMap = new int[26];
            int[] curIndexMap = new int[26];
            Arrays.fill(lastIndexMap, -1);
            Arrays.fill(curIndexMap, -1);

            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'A';
                if (curIndexMap[c] != -1) {//依旧有当前值了（无论前面的last有没有值，这个-1的默认值就很妙）
                    ans += (curIndexMap[c] - lastIndexMap[c]) * (i - curIndexMap[c]);
                }
                // 滚动存储lastIndex和curIndex
                lastIndexMap[c] = curIndexMap[c];
                curIndexMap[c] = i;

            }
            //计算最后next字符(每个字母出现的最后一个位置)的贡献值，最后虚拟next位置就是s.length()
            for (int i = 0; i < 26; i++) {
                if (curIndexMap[i] != -1) {//依旧有当前值了（无论前面的last有没有值，这个-1的默认值就很妙）
                    ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
                }
            }
            return ans;
        }
    }
}
