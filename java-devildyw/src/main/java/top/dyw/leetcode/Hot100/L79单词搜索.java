package top.dyw.leetcode.Hot100;

public class L79单词搜索 {
    public boolean exist(char[][] board, String word) {
        if (board.length==0 || board[0].length==0) {
            return false;
        }

        int n = board.length;
        int m = board[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i>board.length-1 || j > board[0].length-1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean result = dfs(board, i+1, j, word, index+1) || dfs(board, i, j+1, word, index+1) || dfs(board, i-1, j, word, index+1) || dfs(board, i, j-1, word, index+1);
        board[i][j] = temp;
        return result;
    }
}
