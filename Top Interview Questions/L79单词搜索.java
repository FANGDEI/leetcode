public class L79单词搜索 {


    class Solution {


        public boolean exist(char[][] board, String word) {
            int[][] hp=new int[board.length][board[0].length];
            char[] p = word.toCharArray();
            int index = 0;
            boolean ans = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == p[0]) {
                        if (process(hp,board, p, i, j, index)) {
                            ans = true;
                            break;
                        }
                    }
                }
            }
            return ans;
        }

        public boolean process(int[][]hp,char[][] board, char[] p, int i, int j, int index) {
            hp[i][j]=1;
            if (index == p.length -1) {
                return true;
            }
            boolean a = false, b = false, c = false, d = false;

            if (i - 1 >= 0 && board[i - 1][j] == p[index+1]&&hp[i-1][j]!=1) {
                a = process(hp,board, p, i - 1, j, index + 1);
                hp[i-1][j]=0;
            }
            if (j - 1 >= 0 && board[i][j - 1] == p[index+1]&&hp[i][j-1]!=1) {
                b = process(hp,board, p, i, j - 1, index + 1);
                hp[i][j-1]=0;
            }
            if (i + 1 < board.length && board[i + 1][j] == p[index+1]&&hp[i+1][j]!=1) {
                c = process(hp,board, p, i + 1, j, index + 1);
                hp[i+1][j]=0;
            }
            if (j + 1 < board[0].length && board[i][j + 1] == p[index+1]&&hp[i][j+1]!=1) {
                d = process(hp,board, p, i, j + 1, index + 1);
                hp[i][j+1]=0;
            }
            hp[i][j]=0;
            return a || b || c || d;
        }

    }
}
