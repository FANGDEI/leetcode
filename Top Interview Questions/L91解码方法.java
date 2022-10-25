public class L91解码方法 {
    class Solution {
        public int numDecodings(String s) {
            int res = s.length() + 1;
            int[] ans = new int[res];
            ans[res - 1] = 1;
            for (int i = res - 2; i >= 0; i--) {
                if (s.charAt(i) - '0' != 0) {
                    if (i < s.length() - 1 && (s.charAt(i) - '0' < 2 || (s.charAt(i) - '0' == 2 && s.charAt(i + 1) - '0' <= 6))) {
                        ans[i] += ans[i + 2];
                    }
                    ans[i] += ans[i + 1];
                }
            }
            return ans[0];
        }

    }
}
