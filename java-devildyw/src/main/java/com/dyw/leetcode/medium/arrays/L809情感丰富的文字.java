package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-11-25-10:47
 */
@SuppressWarnings("all")
public class L809情感丰富的文字 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param s
     * @param words
     * @return
     */
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        /**
         * 遍历 words 字符串数组，通过expand自定义函数来比较是否符合题目要求
         */
        for (String word : words) {

            if (expand(s,word)){
                //计数
                ans++;
            }
        }
        return ans;
    }

    private boolean expand(String s, String word) {
        //定义双指针
        int i = 0, j = 0;
        while (i<s.length()&&j<word.length()){
            //起始的字符应该是相等的 否则不存在添加相同字符得到目标字符串
            if (s.charAt(i)!=word.charAt(j)){
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0; //定义计数 记录s字符串中ch字符串连续出现的次数
            while (i<s.length()&&s.charAt(i)==ch){
                cnti++;
                i++;
            }
            int cntj = 0;//记录word字符串中 ch字符串连续出现的次数
            while (j<word.length()&&word.charAt(j)==ch){
                cntj++;
                j++;
            }

            //如果cntj > cnti 代表word中连续出现ch 的次数比s中还要多 并不能往其中添加字符 而是只能删除字符 与题意不符 返回false
            if (cntj>cnti){
                return false;
            }
            //如果 cnti 本身就不到3 那么word中添加了 即使相等长度也不能到达3 不符题意 返回 false
            if (cntj<cnti&&cnti<3){
                return false;
            }
        }
        //遍历到最后也没有出现不符题意的情况 那么就可以返回true
        return i==s.length()&&j==word.length();
    }
}
