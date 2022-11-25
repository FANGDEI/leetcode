package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/11/25 11:28
 * @description: 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * 示例：
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * 提示：
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成。
 */
public class L809情感丰富的文字 {


    //双指针模拟
    class Solution {
        /**
         * 作者：Ladidol
         * 描述：判断相同的字母的长度是不是符合情况：l1>=3&&l1>=l2||l1==l2
         * 现在就开始计数每一个重复字符的长度吧，其中只有字母出现的顺序对不上就报错。
         */
        public int expressiveWords(String s, String[] words) {
            int n = s.length();
            int ans = 0;
            out:
            for (String word : words) {
                int m = word.length(), i = 0, j = 0;
                while (i < n && j < m) {
                    if (s.charAt(i) != word.charAt(j)) continue out;
                    int ii = i, jj = j;
                    //分别对重复字符进行遍历，然后计算重复字符长度。
                    while (ii < n && s.charAt(ii) == s.charAt(i)) ii++;
                    while (jj < m && word.charAt(jj) == word.charAt(j)) jj++;
                    int sLen = ii - i, wLen = jj - j;
                    //判断是不是扩张能得到
                    if (sLen != wLen && (wLen > sLen || sLen < 3)) continue out;
                    i = ii;
                    j = jj;
                }
                //如果这个word比对完成，就说明满足扩张要求
                if (i == n && j == m) ans++;
            }
            return ans;
        }
    }


}