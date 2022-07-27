package com.feng.draft.template.string;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.string
 * @className: kmp
 * @author: Ladidol
 * @description:
 * @date: 2022/7/26 23:33
 * @version: 1.0
 */
public class kmp {
    //前缀表（不减一, 也不后移）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);//构造模式串的next数组.

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {//类似于getNext中字符串匹配的过程
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))//不匹配就回退.
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))//相等就后面移动
                j++;
            if (j == needle.length())//移动至模式串尾部就返回index;
                return i - needle.length() + 1;
        }
        return -1;
    }
    private void getNext(int[] next, String s) {
        int j = 0;//默认next的值是0;
        next[0] = j;//默认next第一位下标是0;
        for (int i = 1; i < s.length(); i++) {//默认next从下标1开始慢慢修改.
            while (j > 0 && s.charAt(j) != s.charAt(i))//只要不匹配,就回退.
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))//相等就往后面移动
                j++;
            next[i] = j;//记录当前j的值作为next的值.
        }
    }
}

