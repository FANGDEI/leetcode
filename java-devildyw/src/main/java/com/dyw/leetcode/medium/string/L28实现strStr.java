package com.dyw.leetcode.medium.string;

/**
 * 实现strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 说明：
 *
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 *
 * @author Devil
 * @since 2022-09-11-11:11
 */
@SuppressWarnings("all")
public class L28实现strStr {
    public static void main(String[] args) {
        System.out.println(new L28实现strStr().strStr01("aabaabaaf", "aabaaf"));
    }

    /**
     * BF算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle==null||needle.length()==0){
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        int count;
        for (int i = 0; i+m <= n; i++) {
            count=0;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }else{
                    count++;
                }
            }
            if (count==m){
                return i;
            }
        }
        return -1;
    }

    /**
     * kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr01(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        //初始化next数组
        int[] next = new int[needle.length()];
        // 计算next数组
        getNext(next,needle);

        //初始化指针
        int j = 0; //next数组指针 用于回溯

        for (int i = 0; i < haystack.length(); i++) {
            //回溯
            while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            //如果长度相等则代表匹配 返回结果
            if (j==needle.length()){
                return i - j + 1;
            }
        }
        //循环结束也没有匹配成功则代表没有匹配的结果
        return -1;
    }

    private void getNext(int[] next, String needle) {
        //j在这里即代表前缀串的末尾 又代表了此时最长公共前后缀的长度
        int j = 0, i = 0;
        //初始化为0号位上的公共前后缀长度为0 因为只有一个字符他没有前后缀
        next[i++] = j;
        for (; i < needle.length(); i++) {
            //i 与 j 指向字符不相等情况 需要回溯
            while (j>0&&needle.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            //如果相等 j++ 前缀末尾+1 公共前后缀长度加1
            if (needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            //在i号位置上天上公共前后缀长度j
            next[i] = j;
        }
    }
}
