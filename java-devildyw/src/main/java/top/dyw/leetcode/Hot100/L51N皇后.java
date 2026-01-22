package top.dyw.leetcode.Hot100;

public class L51N皇后 {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> mDiagonal = new HashSet<>();
    HashSet<Integer> sDiagonal = new HashSet<>();
    List<List<String>> result = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] path = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                path[i][j] = '.';
            }
        }
        dfs(0, n, path);
        return result;
    }
    public void dfs(int row, int n, char[][] path) {
        if (row == n) {
            List<String> tempResult = new ArrayList<>();
            for (int i=0; i<n; i++) {
                StringBuilder sb =new StringBuilder();
                for (int j=0; j<n; j++) {
                    sb.append(path[i][j]);
                }
                tempResult.add(sb.toString());
            }
            result.add(tempResult);
        }


        for (int col = 0; col<n; col++) {
            int d1 = row+col;
            int d2 = row-col;

            if (cols.contains(col) || mDiagonal.contains(d1) || sDiagonal.contains(d2)) {
                continue;
            }

            cols.add(col);
            mDiagonal.add(d1);
            sDiagonal.add(d2);
            path[row][col] = 'Q';
            dfs(row+1, n, path);
            path[row][col] = '.';
            cols.remove(col);
            mDiagonal.remove(d1);
            sDiagonal.remove(d2);
        }
    }
}
