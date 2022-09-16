package com.dyw.leetcode.simple.string;

import com.dyw.leetcode.algorithm.KMP.KMP;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-06-29-11:56
 * <p>
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
@SuppressWarnings("all")
public class L459重复的子字符串 {
    public static void main(String[] args) {
        System.out.println(new L459重复的子字符串().repeatedSubstringPattern03("ababab"));
    }

    /**
     * 简单方法 通过规律发现如果一个字符串包括重复的子字符串 那么将这个字符串重复拼接 去掉头和尾后 一定包含该字符串本身
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 2).contains(s);
    }

    /**
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220629122502976.png" alt="题解">
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern01(String s) {
        int n = s.length();

        for (int i = 1; i * 2 <= n; i++) {
            //因为n是n'的n倍 这里通过n%i通过倍数关系判断 找到子串
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    //比较字符从两段子串的相同位置比较
                    if (s.charAt(j) != s.charAt(j - i)) {
                        //不相等就跳出该层循环.说明该字串不是整个字符串的重复子串 则寻找下一个子串
                        match = false;
                        break;
                    }
                }
                //如果满足就返回true
                if (match) {
                    return true;
                }
            }
        }
        //如果上述循环都没有找到一个满足条件的子串那么就返回false
        return false;
    }

    public boolean repeatedSubstringPattern02(String s) {
        int n = s.length();
        //这里的i即代表长度 又代表了比较下标j的开始所以从1开始 <=n
        for (int i = 1; i*2<=n; i++){
            //总字符串长度是子字符串的n倍
            if (n%i==0){
                //标记
                boolean match = true;
                //遍历比较
                for (int j = i; j<n; j++){
                    //一个从 j开始也就是此时的i开始 一个是从0开始 分别都走同样的距离 如果是由0-i的子字符串构成 则返回true 如果不是则break 继续寻找i
                    if (s.charAt(j)!=s.charAt(j-i)){
                        match= false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 假设字符串s使用多个重复子串构成（这个子串是最小重复单位），重复出现的字符串长度是 x ，所以 s 是由 n* x组成。
     * <p>
     * 因为字符串s的最长相同前后缀的长度一定是不包含s本身，所以最长相同前后缀长度必然是 m*x, 而且是 n-m = 1. (因为不能包含本身所以如果由子串重复构成 所以n-m = 1)
     * <p>
     * 所以如果 n*x % (n-m)*x = 0,就能判定有重复出现的子字符串。
     * <p>
     * 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern03(String s) {
        return kmp(s);
    }

    private boolean kmp(String s) {
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        next[0] = j;

        for (int i = 1; i < s.length(); i++) {
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        if (next[n-1]>0&&(n % (n-next[n-1]))==0){
            return true;
        }
        return false;
    }
}
