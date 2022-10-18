import java.util.ArrayList;
import java.util.List;

public class L22括号生成 {

    class Solution {
        List<String> ans = new ArrayList<>();
        int p;

        public List<String> generateParenthesis(int n) {
            p = n;
            if (n == 0) {
                return ans;
            }
            System.out.println(123);
            process(n - 1, n - 1, "(");
            return ans;
        }

        public void process(int i, int j, String s) {
//            System.out.println("s:"+s);
            if (i == 0 && j == 0) {
                ans.add(s + ")");
                return;
            }
            if (i - 1 >= 0) {
                process(i - 1, j, s + "(");
            }
            if (j - 1 >= 0 && p - 1 - i >= p - j - 1) {
                process(i, j - 1, s + ")");
            }
        }
    }

}
