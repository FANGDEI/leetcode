package com.dyw.leetcode.medium.string;

/**
 * @author Devil
 * @since 2022-08-02-9:38
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
@SuppressWarnings("all")
public class L5最长回文子串 {
    public static void main(String[] args) {
        System.out.println(new L5最长回文子串().longestPalindrome01("babad"));
    }

    /**
     * 暴力
     * 双重循环 把所有字符串都罗列出来
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                //记录出最大的回文串
                if (isPalindromic(test) && test.length() > max) {
                    ans = test;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    //通过该方法判断是否是回文
    private boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208021043530.png">
     * <p>
     * 要找出字符串中的回文串 可以将字符串导致 然后原字符串和倒置的字符串找出公共部分 那一部分就是回文串
     * 例如 abac 倒置 caba 公共部分aba 该部分是回文串
     * <p>
     * 通过二维数组遍历两个字符串
     * <p>
     * 如上图所示
     * <p>
     * 使用arr[i][j]保存的公共子串的长度。
     * <p>
     * arr[i][j]二维数组 行遍历的是原字符串,列遍历的倒置后的字符 组合到一起为arr[i][j] 如果i对应的值和j对应的值表示两个字符串有公共部分
     * <p>
     * arr[i][j] = arr [i-1][j-1] + 1。其中arr[i-1][j-1]就为原字符串和倒置字符串的公共子串 而i和i-1是在原字符串连续的 j和j-1则是倒置字符串中连续的
     * 所以这里表示的是两个字符串中公共子串长度的更新 因为i-1 j-1所处的点有值则表示该店对应的字符是公共字符串
     * <p>
     * 当 i = 0 或者 j = 0 的时候单独分析，字符相等的话 arr [ i ][ j ] 就赋为 1 。
     *
     * @param s
     * @return
     */
    public String longestPalindrome01(String s) {
        if (s.equals("")) {
            return "";
        }

        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int n = s.length();

        int[][] arr = new int[n][n];
        int maxLen = 0;
        int maxEnd = 0;

        //动态规划
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    //特殊情况 如果两个字符相等 但位于数组起始位置 赋初值
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        //不是位于起始位置 更新公共子串长度
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    //前置下标(倒置字符串 下标j)
                    int beforeRev = n - 1 - j;
                    //前置下标+公共子串长度-1 == i的下标  防止出现两边相等但并不为回文串的情况 例如 abc432cba 倒置 abc234cba 这两个字符串虽然有公共部分但并不是回文串
                    //而倒置字符串的遍历相当于从原字符串末尾开始遍历 这就会倒置 beforeRev + arr[i][j] - 1 != i
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        }
        //返回最大公共子串
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}
