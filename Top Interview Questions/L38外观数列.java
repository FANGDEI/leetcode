public class L38外观数列 {
    class Solution {
        public String countAndSay(int n) {
            String hp = "1", ans = "";
            for (int i = 1; i < n; i++) {
                // System.out.print(hp.charAt(0));
                char a = hp.charAt(0);
                int p = 1;
                for (int j = 1; j < hp.length(); j++) {
                    if (hp.charAt(j) == a) {
                        p++;
                    } else {
                        ans = ans + p + a;
                        p = 1;
                        a = hp.charAt(j);
                    }
                }
                ans = ans + p + a;
                hp=ans;
                ans="";
            }
            return hp;

        }
    }
}
