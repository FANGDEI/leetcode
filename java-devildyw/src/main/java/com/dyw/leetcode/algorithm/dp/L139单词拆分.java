package com.dyw.leetcode.algorithm.dp;

import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author Devil
 * @since 2022-11-10-11:55
 */
@SuppressWarnings("all")
public class L139单词拆分 {

    public static void main(String[] args) {

    }

    /**
     * 背包问题（完全背包）
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        /**
         * dp数组下标以及含义：valid[i] 表示下标s字符串从0切割到i处的字符串被wordDict拼接结果为 valid[i]
         */
        boolean[] valid = new boolean[s.length()+1];

        //初始化为true 只是为了递推无其他含义
        valid[0] =true;

        for (int i = 1; i < s.length() + 1; i++) { // 先遍历背包
            for (int j = 0; j<i && !valid[i]; j++){ // 再遍历物品
                //在set 中包含 s.substring(j,i)说明能构成 s.substring(0,i)   并且 valid[j] 有效的情况下在上一个能够拼接成功的情况下
                if (set.contains(s.substring(j,i))&&valid[j]){
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}
