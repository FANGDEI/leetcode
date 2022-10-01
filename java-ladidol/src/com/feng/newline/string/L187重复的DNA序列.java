package com.feng.newline.string;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/9/29 17:04
 * @description: DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G'or'T'
 */
public class L187重复的DNA序列 {

    // 滑动区间+哈希
    class Solution1 {

        /*
         * 参数：[s]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：这题告诉了目标串的大小为10，就好弄，直接一个字母当一个起点的遍历。
         */
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {//这里是细节之处：就是   i <= s.length() - 10，取等号了。
                String sub = s.substring(i, i + 10);
                int count = map.getOrDefault(sub, 0);
                if (count == 1) res.add(sub);//当且仅当出现两次的情况的时候，放入答案中。
                map.put(sub, count + 1);//维护哈希表
            }
            return res;
        }
    }

    // 字符串哈希
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            return null;
            // 以后有机会再做。
        }
    }





}