package top.dyw.leetcode.Hot100;

import java.util.HashSet;

public class L73矩阵置零 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        int n = matrix.length, m = matrix[0].length;

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j]==0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
