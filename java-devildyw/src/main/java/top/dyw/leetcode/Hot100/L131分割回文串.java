package top.dyw.leetcode.Hot100;

public class L131分割回文串 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(String s, List<String> path, int start) {
        if (start == s.length()) {
            result.add(new ArrayList(path));
        }

        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)){
                path.add(s.substring(start, i+1));
                dfs(s, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i=start, j=end; i<j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
