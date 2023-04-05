package top.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author Devil
 * @since 2022-10-16-11:26
 */
@SuppressWarnings("all")
public class L51N皇后 {

    public static void main(String[] args) {

    }

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c,'.'); //先初始化为全都为.
        }
        solveNQueensHelper(n,0,chessboard);
        
        return result;
    }

    private void solveNQueensHelper(int n, int row, char[][] chessboard) {
        if (row == n){
            result.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col<n; ++col){
            //判断是否有效位置 即该店的列和对角线上是否有 Q字符
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';
                solveNQueensHelper(n,row+1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        //检查列
        for (int i =0;i<row;++i){
            if (chessboard[i][col]=='Q'){
                return false;
            }
        }

        //检查 45 度对角线
        for (int i = row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }

        //检查135度对角线
        for (int i=row-1,j=col+1;i>=0&&j<=n-1;i--,j++){
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    //将数组转为为列表
    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }

        return list;
        
    }


}
