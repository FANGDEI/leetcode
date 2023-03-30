package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-05-21:05
 */
@SuppressWarnings("all")
public class O12矩阵中的路径 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = backTracking(board, visited, i, j, 0, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, boolean[][] visited, int row, int col, int index, String word) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean result = false;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if (!visited[newRow][newCol]) {
                    boolean flag = backTracking(board, visited, newRow, newCol, index + 1, word);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[row][col] = false;
        return result;
    }

    public boolean exist01(char[][] board, String word) {
        //要保证在回溯查找的过程中同一个单元格内的字母不允许被重复使用，我们这里使用visit数组记录被访问的单元格
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //回溯
                boolean flag = backTracking1(board, visited, i, j, 0, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯
     *
     * @param board   单元格数组
     * @param visited 单元格访问记录数组
     * @param row     当前访问行
     * @param col     当前访问列
     * @param index   单词下标指针
     * @param word    单词
     * @return
     */
    private boolean backTracking1(char[][] board, boolean[][] visited, int row, int col, int index, String word) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true; //标记该单元格已被访问
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean result = false;
        //回溯上下左右相邻的格子
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow>=0&&newRow<board.length&&newCol>=0&&newCol<board[0].length){
                if (!visited[newRow][newCol]) { //如果没有访问过新格子,就进行搜索
                    boolean flag = backTracking1(board, visited, newRow, newCol, index + 1, word);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[row][col] = false;
        return result;
    }
}
