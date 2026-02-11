package top.dyw.leetcode.Hot100;

public class L51N皇后 {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> d1 = new HashSet<>();
    HashSet<Integer> d2 = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] path = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                path[i][j] = '.';
            }
        }

        dfs(path, 0, n);
        return result;
    }

    public void dfs(char[][] path, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++) {
                    sb.append(path[i][j]);
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }

        for (int col=0; col < n; col++) {
            int d1V = row - col;
            int d2V = row + col;

            if (cols.contains(col) || d1.contains(d1V) || d2.contains(d2V)) {
                continue;
            }

            cols.add(col);
            d1.add(d1V);
            d2.add(d2V);
            path[row][col] = 'Q';

            dfs(path, row+1, n);

            cols.remove(col);
            d1.remove(d1V);
            d2.remove(d2V);
            path[row][col] = '.';
        }
    }
}
