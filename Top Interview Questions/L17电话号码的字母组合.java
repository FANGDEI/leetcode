import java.util.ArrayList;
import java.util.List;

public class L17电话号码的字母组合 {
    class Solution {

        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List ans = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            combinations(digits, "");
            return ans;
        }

        public void combinations(String digits, String hp) {
            if (digits.equals("")) {
                if (hp.equals("")) {
                    return;
                }
                ans.add(hp);
                return;
            }
            for (int i = 0; i < str[digits.charAt(0) - '2'].length(); i++) {
                String s = hp + str[digits.charAt(0) - '2'].charAt(i);
                combinations(digits.substring(1), s);
            }
        }
    }
}
