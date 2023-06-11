package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/11 14:17
 **/
@SuppressWarnings("all")
public class OII020回文子字符串的个数 {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <=j ; i++) {
                //判断当前指向的字符是否相同，如果相同再根据dp数组记录的dp[i+1][j-1](表示i+1字符串到j-1字符串是否是回文串)判断是否i到j是否是字符串
                if (chars[i]==chars[j]&&(j-i<3||dp[i+1][j-1])){
                   dp[i][j] = true;
                   count++;
                }
            }
        }
        return count;
    }
}
