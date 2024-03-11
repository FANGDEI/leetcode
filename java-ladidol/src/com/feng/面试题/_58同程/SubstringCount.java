package com.feng.面试题._58同程;

public class SubstringCount {
    public static int countSubstrings(String s, String sub) {
        int count = 0;
        char[] sChars = s.toCharArray();
        char[] subChars = sub.toCharArray();
        count = dfs(sChars, subChars, 0, 0);
        return count;
    }

    private static int dfs(char[] sChars, char[] subChars, int sIndex, int subIndex) {
        if (subIndex == subChars.length) {
            // 子串匹配完成，返回1
            return 1;
        }
        if (sIndex == sChars.length) {
            // 字符串遍历完成，返回0
            return 0;
        }

        int count = 0;
        if (sChars[sIndex] == subChars[subIndex]) {
            // 当前字符匹配成功，继续匹配下一个字符
            count += dfs(sChars, subChars, sIndex + 1, subIndex + 1);
        }
        // 不使用当前字符，继续匹配下一个字符
        count += dfs(sChars, subChars, sIndex + 1, subIndex);

        return count;
    }

    public static void main(String[] args) {
        String s = "aabcdd";
        String sub = "acd";

        int count = countSubstrings(s, sub);
        System.out.println("子串出现次数: " + count);
    }
}