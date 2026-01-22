package top.dyw.leetcode.Hot100;

public class L17电话号码的字母组合 {
    List<String> result = new ArrayList();
    String[] Mapping = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public List<String> letterCombinations(String digits) {

        dfs(digits, 0, new StringBuilder());
        return result;
    }

    public void dfs(String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = Mapping[digits.charAt(index)-'0'];
        for (int i=0; i<letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(digits, index+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
