package top.dyw.leetcode.Hot100;

public class L22括号生成 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return result;
    }

    public void dfs(int n, int open, int close, StringBuilder path) {
        if (open < close) {
            return;
        }

        if (open == close && open+close == 2*n) {
            result.add(path.toString());
            return;
        }

        if (open < n) {
            path.append('(');
            dfs(n, open+1, close, path);
            path.deleteCharAt(path.length()-1);
        }

        if (open > close) {
            path.append(')');
            dfs(n, open, close+1, path);
            path.deleteCharAt(path.length()-1);
        }

    }
}
