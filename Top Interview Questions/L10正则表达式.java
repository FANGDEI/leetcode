public class L10正则表达式 {
//    暴力递归
    //class Solution {
//    public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
//        if(p1 >= p.length) return s1 >= s.length;
//        boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
//        if(p.length - p1 >= 2 && p[p1 + 1] == '*') return isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
//        return match && isMatchChar(s, s1 + 1, p, p1 + 1);
//    }
//    public boolean isMatch(String s, String p) {
//        char[] ss = s.toCharArray(), pp = p.toCharArray();
//        return isMatchChar(ss, 0, pp, 0);
//    }
//}
//
//记忆化搜索
//class Solution {
//    int[][] mem;
//    public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
//        if(p1 >= p.length) return s1 >= s.length;
//        if(mem[s1][p1] != 0) return mem[s1][p1] > 0;
//        boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
//        if(p.length - p1 >= 2 && p[p1 + 1] == '*') {
//            boolean t = isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
//            if(t) mem[s1][p1] = 1;
//            else mem[s1][p1] = -1;
//            return t;
//        }
//        boolean t = match && isMatchChar(s, s1 + 1, p, p1 + 1);
//        if(t) mem[s1][p1] = 1;
//        else mem[s1][p1] = -1;
//        return t;
//    }
//    public boolean isMatch(String s, String p) {
//        this.mem = new int[s.length() + 1][p.length() + 1];
//        char[] ss = s.toCharArray(), pp = p.toCharArray();
//        return isMatchChar(ss, 0, pp, 0);
//    }
//}
//

//动态规划
    public class Solution {

        public boolean isMatch(String s, String p) {
            char[] str = s.toCharArray(), ptr = p.toCharArray();
            boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
            dp[0][0] = true;
            for (int i = 0; i <= str.length; i++) {
                for (int j = 1; j <= ptr.length; j++) {
                    if(ptr[j - 1] != '*') {
                        if(i > 0 && (str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')) dp[i][j] = dp[i - 1][j - 1];
                    }else { //ptr[j - 1] == '*'
                        if(j > 1) dp[i][j] |= dp[i][j - 2];   //不看
                        if(i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.'))dp[i][j] |= dp[i - 1][j];    //看
                    }
                }
            }
            return dp[str.length][ptr.length];
        }
    }

}
