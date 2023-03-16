package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-22-12:14
 */
@SuppressWarnings("all")
public class L392判断子序列 {

    public static void main(String[] args) {
        System.out.println(new L392判断子序列().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();

        /**
         * dp[i][j] 表示以i-1为结尾的t 与 以j-1为结尾的字符串s 相同的子序列长度为dp[i][j]
         */
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //if (s[i - 1] == t[j - 1])，那么dp[i][j] = dp[i - 1][j - 1] + 1;，因为找到了一个相同的字符，相同子序列长度自然要在dp[i-1][j-1]的基础上加1
                if (s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    //根据dp[i][j]数组的定义 以i-1为结尾的t 与 以j-1为结尾的字符串s 相同的子序列长度为dp[i][j] 这里t[i-1]与s[j-1]不同所以让t[i-2]与s[j-1]比较
                    //而这个值刚好可以取上一层的 dp[i-1][j] 就是 t[i-2]与s[j-1]比较的结果
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if (dp[n][m]==m){
            return true;
        }
        return false;


    }
}
