package com.feng.newline.hashtable;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L745前缀和后缀搜索
 * @author: Ladidol
 * @description:
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *
 * 示例:
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。

 * @date: 2022/7/14 10:02
 * @version: 1.0
 */
//每日一题2022年7月14日10:16:49
public class L745前缀和后缀搜索 {

    class WordFilter {

        int len;
        String[] words;

        public WordFilter(String[] words) {
            this.len = words.length;
            this.words = words;
        }

        public int f(String pref, String suff) {
            //返回最大角标, 就从后面往前遍历.
            for (int i = len-1;i>=0;i--) {
                if (words[i].startsWith(pref)&&words[i].endsWith(suff)){
                    return i;
                }
            }
            return -1;
        }
    }

    //优秀题解: https://leetcode.cn/problems/prefix-and-suffix-search/solution/-by-akax-n-zbyd/



/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
}
