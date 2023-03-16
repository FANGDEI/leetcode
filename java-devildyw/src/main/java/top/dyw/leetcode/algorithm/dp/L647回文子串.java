package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-24-16:26
 */
@SuppressWarnings("all")
public class L647回文子串 {

    public static void main(String[] args) {
        System.out.println(new L647回文子串().countSubstrings01("abc"));
    }

    /**
     * dp
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s==null||(len=s.length())<1) return 0;

        /**
         * dp[i][j]:s字符串下标i到下标j的子串是否是一个回文串，即s[i,j]
         */
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            //之所以从 0 开始遍历到 j 是为了达到递归的效果
            for (int i = 0; i <= j; i++) {
                //如果两端字母一样时，才可以收缩进一步判断
                if (s.charAt(i)==s.charAt(j)){
                    //如果j-i 之间的插值小于3 则代表两个字符可能相邻也可能是同一个字符
                    if (j-i<3){
                        //在相等的情况下则直接设置dp[i][j] 为true
                        dp[i][j] = true;
                    }else{
                        //如果 j-i 的插值大于或等于3 则不能仅仅通过两个字符相等来判断 需要判断dp[i+1][j-1]进一步判断 以判断是否是回文串
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    //不相等的话直接置为false
                    dp[i][j] = false;
                }
            }
        }
        //遍历每个字符串，统计会问串个数。
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }



    /**
     * 暴力
     * @param s
     * @return
     */
    public int countSubstrings01(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans += isManacher(s,i,j)?1:0;
            }
        }
        return ans;
    }

    private boolean isManacher(String s, int i, int j) {
        for (; i<=j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
